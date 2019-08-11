package com.king2.commons.utils;

import com.king2.commons.exceptions.UserManageException;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Map;

/*=======================================================
	˵��:    �û���������

	����		ʱ��					ע��
  	����		2019.08.05   			����
=======================================================*/
public class UserManageUtil {

    /**
     * ����jedisģ��
     */
    private JedisPool jedisPool = null;

    /**
     * �û����Ƶ�key
     */
    public static final String USER_COOKIE_TOKEN = "king2-token";

    /**
     * �û��˺Ŵ���Cookie�е�key
     */
    public static final String USER_COOKIE_USERNAME = "king2-user-name";

    /**
     * -----------------------------------------------------
     * ����:  �ṩjedis���ι���
     * <p>
     * ����:
     * jedis        Jedis    Jedisʵ������
     * <p>
     * ����: UserManageUtil               �����û�������
     * -----------------------------------------------------
     */
    public UserManageUtil(JedisPool jedisPool) throws Exception {
        if (jedisPool == null) {
            throw new UserManageException("JedisPollʵ������Ϊnull,�����Ƿ�ע��ɹ���");
        }
        this.jedisPool = jedisPool;
    }

    /**
     * -----------------------------------------------------
     * ����:  �����û��˺ź�Token��ȡ�û���redis�е���Ϣ
     * <p>
     * ����:
     * account        String      �û��������ݿ��Ψһ��ʶ
     * token          String      �û�����redis�е�Ψһ��ʶ
     * <p>
     * ����: SystemResult               ���ر���ִ�еĽ��
     * ���ؽ����Ϊnull˵���û�������redis��
     * ״̬�룺100 �쳣
     * -----------------------------------------------------
     */
    public SystemResult getUserInfoByAccountAndToken(String account, String token) {

        // ��ȡjedisʵ��
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // �ж�accout�Ƿ�Ϊ��
            if (StringUtils.isEmpty(account) || StringUtils.isEmpty(token)) {
                return null;
            }
            // ��ȡ�û���redis�е���Ϣ
            String userJson = jedis.hget(account, token);
            // �ж��Ƿ���ڸ��û���Ϣ
            if (StringUtils.isEmpty(userJson)) {
                jedis.close();
                return new SystemResult(100, "���˺��������ط���¼", null);
            }
            // ���û�Jsonת�����û�����
            K2Member k2Member = JsonUtils.jsonToPojo(userJson, K2Member.class);
            return new SystemResult(k2Member);
        } catch (IOException e) {
            return new SystemResult(100, "�û�JSONת��ʧ��,����JSON��ʽ�Ƿ���ȷ��", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "���ӳػ�ȡʧ�ܡ�", null);
        } finally {
            if (jedis != null) jedis.close();
        }

    }


    /**
     * -----------------------------------------------------
     * ����:  ��֤һ���˻�ֻ��һ���û���ʹ��
     * <p>
     * ����:
     * k2Member        K2Member      �û���Ϣ
     * token          String         �û�����redis�е�Ψһ��ʶ
     * <p>
     * ����: SystemResult               ���ر���ִ�еĽ��
     * ���ؽ����SystemResult
     * ״̬�룺200��¼�ɹ���201��¼�ɹ�������ǰ���Ѿ����˵�¼��100�쳣
     * -----------------------------------------------------
     */
    public SystemResult refresh(K2Member k2Member, String token) throws Exception {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // �ж��û��Ƿ��¼
            Map<String, String> userMap = jedis.hgetAll(k2Member.getMemberAccount());
            if (CollectionUtils.isEmpty(userMap)) {
                // ˵��redis��û�и��û�����Ϣ
                // ��redis���������
                jedis.hset(k2Member.getMemberAccount(), token, JsonUtils.objectToJson(k2Member));
                jedis.close();
                return new SystemResult(200, "��¼�ɹ�", k2Member);
            }

            SystemResult userInfoResult = getUserInfoByAccountAndToken(k2Member.getMemberAccount(), token);
            if (userInfoResult != null && userInfoResult.getStatus() == 200) {
                // ˵������
                jedis.close();
                return userInfoResult;
            }

            // ����ˢ���û���redis�е�����
            jedis.del(k2Member.getMemberAccount());
            jedis.hset(k2Member.getMemberAccount(), token, JsonUtils.objectToJson(k2Member));
            return new SystemResult(201, "��¼�ɹ�", k2Member);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(500, "ϵͳ�ڲ��쳣", k2Member);
        } finally {
            if (jedis != null) jedis.close();
        }


    }


}
