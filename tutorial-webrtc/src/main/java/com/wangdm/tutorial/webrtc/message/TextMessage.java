package com.wangdm.tutorial.webrtc.message;

public class TextMessage {

    private String type = "";
    
    private String sender = "";
    
    private String message = "";

    public TextMessage(String type, String sender, String message) {
        super();
        this.type = type;
        this.sender = sender;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String encode(){
        return "{\"type\":\""+this.type+"\",\"sender\":\""+this.sender+"\",\"message\":\""+this.message+"\"}";
    }
    
}
