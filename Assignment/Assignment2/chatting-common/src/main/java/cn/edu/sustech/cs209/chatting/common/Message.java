package cn.edu.sustech.cs209.chatting.common;

import java.io.Serializable;

public class Message implements Serializable {

    private Long timestamp;

    private String sentBy;

    private String sendTo;

    private String data;

    private String[] userList;

    private final int model; //0表示用户列表，1表示个人信息,2表示群信息,3系统信息，

    public Message(Long timestamp, String sentBy, String sendTo, String data) {
        this.timestamp = timestamp;
        this.sentBy = sentBy;
        this.sendTo = sendTo;
        this.data = data;
        model = 1;
    }

    public Message(String[] userList){
        this.userList = userList;
        model = 0;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getSentBy() {
        return sentBy;
    }

    public String getSendTo() {
        return sendTo;
    }

    public String getData() {
        return data;
    }

    public String[] getUserList() {
        return userList;
    }

    public int getModel() {
        return model;
    }
}
