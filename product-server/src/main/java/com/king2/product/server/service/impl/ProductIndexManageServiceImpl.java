package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductIndexAppoint;
import com.king2.product.server.dto.ProductIndexDto;
import com.king2.product.server.dto.SystemStateDto;
import com.king2.product.server.dto.ShowProductIndexDto;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.service.ProductIndexManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/*=======================================================
	˵��:    ��Ʒ��ҳ����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.11   			����
=======================================================*/
@Service
public class ProductIndexManageServiceImpl implements ProductIndexManageService {

    // ע����Ʒ��ҳ����ί����
    @Autowired
    private ProductIndexAppoint productIndexAppoint;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ����ҳ
     * <p>
     * ����:
     * K2Member         K2Member        �������û���Ϣ
     * dto              ProductIndexDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, ProductIndexDto dto) {

        // ��װ��Ʒ״̬
        List<SystemStateDto> stateDtos = new ArrayList<>();
        ProductStateEnum[] values = ProductStateEnum.values();
        for (int i = 0; i < values.length; i++) {
            SystemStateDto stateDto = new SystemStateDto();
            stateDto.setKey(values[i].getKey());
            stateDto.setValue(values[i].getValue());
            stateDtos.add(stateDto);
        }
        dto.setStates(stateDtos);

        // ����������ȡ��Ʒ����Ϣ
        SystemResult productInfoByQuery = productIndexAppoint.getProductInfoByQuery(k2MemberAndElseInfo.getK2Member(), dto);

        // ��װ��������
        ShowProductIndexDto data = (ShowProductIndexDto) productInfoByQuery.getData();
        dto.setTotalSize(data.getTotalSize());
        dto.setTotlaPage(data.getTotalPage());

        // ��ȡָ������Ʒ����
        SystemResult currentRequestProductInfos = productIndexAppoint.getCurrentRequestProductInfos(k2MemberAndElseInfo.getK2Member(), dto, data.getProductInfoToRedisDataDtos());
        dto.setProductDatas((List) currentRequestProductInfos.getData());
        return new SystemResult(dto);
    }
}
