package ru.shift.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Message {

    @ApiModelProperty(
            value = "Message ID in the database. Not specified at creation",
            name = "messageId",
            dataType = "int",
            example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;

    @ApiModelProperty(
            value = "User ID in the database",
            name = "userId",
            dataType = "int",
            example = "6")
    @Column
    private int userId;

    @ApiModelProperty(
            value = "Message text",
            name = "text",
            dataType = "String",
            example = "Hello!")
    @JsonIgnore
    @Column
    private String text;

    @JsonIgnore
    @Column
    private String sendTime;

    @ApiModelProperty(
            value = "The lifetime of the message. If -1, then the time is not limited",
            name = "lifetimeSec",
            dataType = "int",
            example = "60")
    @Column
    private int lifetimeSec;

    @Column
    private int delaySec;

    @ManyToOne()
    @JoinColumn(name = "chatId")
    @JsonIgnore
    private Chat chat;

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Chat getChat() {
        return chat;
    }

    public void toUserView(){
        sendTime = sendTime.replace('T', ' ');
    }

    public int getMessageId() {
        return messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public void setLifetimeSec(int lifetimeSec) {
        this.lifetimeSec = lifetimeSec;
    }

    public int getLifetimeSec() {
        return lifetimeSec;
    }

    public void setDelaySec(int delaySec) {
        this.delaySec = delaySec;
    }

    public int getDelaySec() {
        return delaySec;
    }
}
