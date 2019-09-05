package com.king2.commons.result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/*================================================================
˵����ҵ�������Ӧ���

����          ʱ��            ע��
��Ϊݼ       2018.5.22	     ����
==================================================================*/
public class SystemResult implements Serializable {

    // ����jackson����
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // ��Ӧҵ��״̬
    // 200 Ϊ�����ɹ�
    // 100 Ϊ����У���쳣
    // 404 Ϊ�Ҳ���·��
    // 500 Ϊ�����ڲ�����
    private Integer status;

    // ��Ӧ��Ϣ
    // Ĭ��Ϊ�����ɹ�
    private String msg;

    // ��Ӧ�е�����
    private Object data;

    /**
     * =================================================================
     * ���ܣ�������Ӧ���
     * <p>
     * ������status			Integer		״̬��
     * msg				String		��Ӧ��Ϣ
     * data			Object		��Ӧ����
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult build(Integer status, String msg, Object data) {
        return new SystemResult(status, msg, data);
    }

    /**
     * =================================================================
     * ���ܣ����سɹ���Ϣ��������Ϣ��������
     * <p>
     * ������data			Object		��Ӧ����
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult ok(Object data) {
        return new SystemResult(data);
    }

    /**
     * =================================================================
     * ���ܣ����سɹ���Ϣ��������Ϣ������
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult ok() {
        return new SystemResult(null);
    }

    public SystemResult() {

    }

    /**
     * =================================================================
     * ���ܣ�������Ӧ�������������
     * <p>
     * ������status			Integer		״̬��
     * msg				String		��Ӧ��Ϣ
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult build(Integer status, String msg) {
        return new SystemResult(status, msg, null);
    }

    public SystemResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public SystemResult(Object data) {
        this.status = 200;
        this.msg = "�����ɹ�";
        this.data = data;
    }

    public SystemResult(Integer status , String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * =================================================================
     * ���ܣ���json�����ת��ΪSystemResult����(Object���Ǽ��϶����ת��)
     * <p>
     * ������jsonData			String		json����
     * clazz			Class		SystemResult�е�object����
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, SystemResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * =================================================================
     * ���ܣ���json�����ת��ΪSystemResult����(û��object�����ת��)
     * <p>
     * ������jsonData			String		json����
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult format(String json) {
        try {
            return MAPPER.readValue(json, SystemResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * =================================================================
     * ���ܣ���json�����ת��ΪSystemResult����(Object�Ǽ��϶����ת��)
     * <p>
     * ������jsonData			String		json����
     * clazz			Class		�����е�����
     * <p>
     * ���أ�SystemResult		ҵ�������Ӧ���
     * ===================================================================
     */
    public static SystemResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
