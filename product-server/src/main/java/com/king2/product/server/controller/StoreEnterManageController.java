package com.king2.product.server.controller;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.StoreEntryIndexDto;
import com.king2.product.server.service.StoreEnterManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*=======================================================
	˵��:    ������פ����Controller

	����		ʱ��					ע��
  	����		2019.09.02   		����
=======================================================*/
@RestController
@Validated
@RequestMapping("/store/enter")
public class StoreEnterManageController {

    // ע�������פService
    @Autowired
    private StoreEnterManageService storeEnterManageService;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ��פ����ҳ��Ϣ
     * <p>
     * ����:
     * dto              StoreEntryIndexDto          ��ҳ��������Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/index")
    public SystemResult index(HttpServletRequest request, @Validated StoreEntryIndexDto indexDto) {

        // ��ȡ��¼���û���Ϣ
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = storeEnterManageService.index(indexDto, k2Member);
        return index;
    }

    /**
     * -----------------------------------------------------
     * ����:  ͨ��״̬�޸ĵ�����פ����Ϣ
     * <p>
     * ����:
     * storeEnterId         Integer                 ������פ��id
     * state                Integer                 ״̬
     * content              String                  ���״̬Ϊ�ܾ�  ��ô�ܾ���������ʲô
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @RequestMapping("/edit/state")
    public SystemResult editState(HttpServletRequest request,
                                  @NotBlank(message = "״̬����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String state,
                                  @NotBlank(message = "����id����Ϊ��") @Pattern(regexp = "[0-9]{1,}") String storeEnterId, String content) {

        // ��ȡ��¼���û���Ϣ
        K2MemberAndElseInfo k2Member = (K2MemberAndElseInfo) request.getAttribute("user");
        SystemResult index = storeEnterManageService.editEnterState(k2Member,
                Integer.parseInt(storeEnterId), Integer.parseInt(state), content);
        return index;
    }
}
