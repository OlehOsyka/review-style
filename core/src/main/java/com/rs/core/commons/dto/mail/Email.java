package com.rs.core.commons.dto.mail;

public class Email {

    private String receiverAddress;
    private String subject;
    private String message;
    private String senderAddress;

    public Email() {
    }

    public Email(String message, String subject, String senderAddress, String receiverAddress) {
        this.message = message;
        this.subject = subject;
        this.senderAddress = senderAddress;
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
}
