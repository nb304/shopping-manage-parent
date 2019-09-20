package com.king2.login.server.service.impl;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2MemberExample;
import com.king2.commons.pojo.K2Role;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.commons.utils.MD5Utils;
import com.king2.commons.utils.NetworkUtil;
import com.king2.commons.utils.UserManageUtil;
import com.king2.login.server.cache.UserLoginCacheManage2;
import com.king2.login.server.service.LoginManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	˵��:    �û��������Serviceʵ����

	����		ʱ��					ע��
  	����		2019.09.06   		����
=======================================================*/
@Service
public class LoginManageServiceImpl implements LoginManageService {

    // �û���Mapper
    @Autowired
    private K2MemberMapper k2MemberMapper;
    // jedis���ӳ�
    @Autowired
    private JedisPool jedisPool;
    // Զ�����ӹ���
    @Autowired
    private RestTemplate restTemplate;

    // ��־��Ϣ
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginManageServiceImpl.class);

    /**
     * -----------------------------------------------------
     * ����:  SSO�����¼ϵͳ
     * <p>
     * ����:
     * username         String          �û���
     * password         String          ����
     * code             String          ��֤��
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult login(String username, String password, HttpServletRequest request, String code) throws IOException {

        // ����
        synchronized (LOGGER) {

            // ��ȡ����֤��Ļ���ṹ
            ConcurrentHashMap<String, String> codeHashMap = UserLoginCacheManage2.getInstance().getCodeHashMap();
            // �鿴��֤���Ƿ���ȷ
            String sessionKey = NetworkUtil.getHostIpAddress(request);
            String sessionCode = codeHashMap.get(sessionKey);
            if (StringUtils.isEmpty(sessionCode) || !sessionCode.toUpperCase().equals(code.toUpperCase())) {
                return new SystemResult(100, "��֤�����,�����»�ȡ��");
            }
            // ����߾�ֻ���в�ѯ�û��Ƿ���� ���Ľ�ɫ��Ϣ����������Ϣ �ҾͲ���ѯ��
            // У�黺�������Ƿ���ڸ��û�����Ϣ
            SystemResult checkCacheResult = checkCacheIsUserInfo(username, password);
            // ״̬==200 ˵�������д��ڸ��û���������Ϣ �����˺�����ͨ������֤ ����ֵ��һ���û���������Ϣ
            if (checkCacheResult.getStatus() == 200) {
                // ȡ����Ϣ
                K2MemberAndElseInfo member = (K2MemberAndElseInfo) checkCacheResult.getData();

                // ���û��������´���redis��
                SystemResult result = null;
                try {
                    result = userInfoGotoRedisCache(member, request);
                } catch (Exception e) {
                    LOGGER.error("���û���Ϣ����redis�г���,������Ϣ:" + e);
                    LOGGER.error(GetErrorInfo.getTrace(e));
                    e.printStackTrace();
                }
                // ������Ϣ  ״̬==200����201˵������ɹ� ����ɹ��� ��Я�����ص�token ��Ҫ�����ֶ�д�ؿͻ���
                if (result.getStatus() == 201) {
                    // ˵���Ƕ�����Ϊ  ������Ҫ�Ƚ���������IP��ַ �ж��Ƿ���Ҫ�����˺�
                    K2MemberAndElseInfo data = (K2MemberAndElseInfo) result.getData();

                    // ����Զ�̷��� ɾ�����������Ӧ���û�������Ϣ
                    // ɾ����Ʒ����Ļ�����Ϣ
                    restTemplate.postForObject("http://KING2-PRODUCT-MANAGE-7778/user/cache/del/cloud?token=" + data.getOldToken(), null, String.class);
                }

                codeHashMap.remove(sessionKey);
                return result;
            }

            // ˵��������û�и��û���������Ϣ ������Ҫ��ѯ���ݿ��е���Ϣ
            SystemResult checkMySqlInfoResult =
                    cacheNotFoundUserInfoCurrentGotoMySqlGetInfo(username, password);
            if (checkMySqlInfoResult.getStatus() != 200) return checkMySqlInfoResult;

            // У��ɹ� ˵���û�����ɹ��� checkMySqlInfoResult���ص�data��Я���˸��û����˺���Ϣ
            K2MemberAndElseInfo data = (K2MemberAndElseInfo) checkMySqlInfoResult.getData();

            // ����������˼·
            // 1������������û�token�����ظ��û�  �����û���¼�ɹ� Ȼ�󴴽�һ����ȫ���߳̽��û���Ϣ����reids�ͱ��ػ�����
            //      1��1���ȡ�Ĺ�������һ��Ҫ������ �����������ݰ�ȫ������
            // 2��һ��������ȥ

            // ������ѡ��ڶ��ְ취
            SystemResult result = null;
            try {

                // ���û���Ϣ���뱾�صĻ�������
                userInfoAddToCache(data);

                // ����ɹ��� ����redis��
                result = userInfoGotoRedisCache(data, request);
            } catch (Exception e) {
                e.printStackTrace();
            }

            codeHashMap.remove(sessionKey);
            return result;
        }
    }

    /**
     * �ڻ�����û���ҵ����û�����Ϣ  ��������ȥ�����ݿ��ѯ���û�����Ϣ
     *
     * @return
     */
    public SystemResult cacheNotFoundUserInfoCurrentGotoMySqlGetInfo(String username, String password) {

        // ��ѯ���ݿ����Ϣ
        K2MemberExample example = new K2MemberExample();
        example.createCriteria().andMemberAccountEqualTo(username);
        List<K2Member> k2Members = k2MemberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(k2Members)) {
            // ˵���û������� �Ƚ�����
            K2Member member = k2Members.get(0);
            // ���ܹ����Լ�����
            if (!password.equals(member.getMemberPassword())) {
                return new SystemResult(100, "�û������������!!");
            }
        } else {
            return new SystemResult(100, "�û������������!!");
        }

        // ���ɼ�����
        K2MemberAndElseInfo elseInfo = new K2MemberAndElseInfo();
        elseInfo.setK2Member(k2Members.get(0));
        // ��ɫ��Ϣ
        List<K2Role> roles = new ArrayList<>();
        K2Role role = new K2Role();
        role.setCreateUserName("��������Ա");
        role.setRetain1("KING2_SYSTEM_ADMIN");
        roles.add(role);
        elseInfo.setK2Roles(roles);
        // ����token��Ϣ
        // token����������Լ�����
        String token = MD5Utils.md5(elseInfo.getK2Member().getMemberAccount() + new Date().getTime() + UUID.randomUUID().toString());
        elseInfo.setCurrentToken(token);
        return new SystemResult(elseInfo);
    }

    /**
     * ���û��������´���redis��
     *
     * @param k2Member
     * @return
     * @throws Exception
     */
    public SystemResult userInfoGotoRedisCache(K2MemberAndElseInfo k2Member, HttpServletRequest request) throws Exception {

        // ����Redis����Ҫ�����ݽṹ
        // k2Member.getK2Member().setReqeustUserMac(NetworkUtil.getHostMacAddress(request));


        // ����UserUtil��ˢ�¹���
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);

        // �����refresh�᷵�ر��ε����״̬ ���鿴�����ڲ�
        SystemResult refresh = userManageUtil.refresh(k2Member, k2Member.getCurrentToken());
        return refresh;
    }

    /**
     * ���û���Ϣ���뱾�ػ���
     *
     * @param k2Member
     * @return
     */
    public static void userInfoAddToCache(K2MemberAndElseInfo k2Member) {
        // ��Ҫ��
        UserLoginCacheManage2 instance = UserLoginCacheManage2.getInstance();
        // ����instance�ǵ����� ���Կ���ֱ����������ʹ��
        synchronized (instance) {
            instance.getUserCacheHashMapDatas().put(k2Member.getK2Member().getMemberAccount(), k2Member);
        }
    }

    /**
     * ɾ���û��ڻ����е�����
     */
    public static void delUserCaCheInfo(String account) {
        // ��Ҫ��
        UserLoginCacheManage2 instance = UserLoginCacheManage2.getInstance();
        // ����instance�ǵ����� ���Կ���ֱ����������ʹ��
        synchronized (instance) {
            instance.getUserCacheHashMapDatas().remove(account);
        }
    }

    /**
     * У�黺����Ϣ���û�������Ϣ
     *
     * @param username
     * @param password
     * @return
     */
    public static SystemResult checkCacheIsUserInfo(String username, String password) {
        // ��ȡ��������
        // ��Ҫ��
        UserLoginCacheManage2 instance = UserLoginCacheManage2.getInstance();
        // ����instance�ǵ����� ���Կ���ֱ����������ʹ��
        synchronized (instance) {

            // �û���������Ϣ
            ConcurrentHashMap<String, K2MemberAndElseInfo> userCacheHashMapDatas =
                    instance.getUserCacheHashMapDatas();

            // �жϻ�����Ϣ�Ƿ���ڸ��û�
            if (CollectionUtils.isEmpty(userCacheHashMapDatas)) {
                return new SystemResult(100, "�������ݲ���������");
            } else if (!userCacheHashMapDatas.containsKey(username)) {
                return new SystemResult(100, "�������ݲ���������");
            }

            // �û����ڻ������Ϣ  ����û����и�����������������ݵĲ���  ��סɾ�������������Ϣ
            K2MemberAndElseInfo k2Member = userCacheHashMapDatas.get(username);
            if (k2Member == null) return new SystemResult(100, "�������ݲ���������");

            // �Ƚ�����
            if (!password.equals(k2Member.getK2Member().getMemberPassword())) {
                return new SystemResult(100, "�û������������!!");
            }

            k2Member.setOldToken(k2Member.getCurrentToken());
            // token����������Լ�����
            String token = MD5Utils.md5(k2Member.getK2Member().getMemberAccount() + new Date().getTime() + UUID.randomUUID().toString());
            k2Member.setCurrentToken(token);
            return new SystemResult(k2Member);
        }

    }
}
