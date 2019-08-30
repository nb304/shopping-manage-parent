package com.king2.product.server.pojo;

// 用户聊天记录页面显示的POJO类
public class UserCharHtmlDataPojo {

    // 发送者的id
    private Integer userId;
    // 发送者的头像
    private String image;
    // 发送者的名称
    private String name;
    // 最后一句的消息
    private String content;
    // 未读消息
    private Integer notReadSize;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNotReadSize() {
        return notReadSize;
    }

    public void setNotReadSize(Integer notReadSize) {
        this.notReadSize = notReadSize;
    }
}
