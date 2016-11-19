package com.nappy.root.cubesdemo;

/**
 * Created by root on 11/18/16.
 */

public class Transaction {
    private String amount,type, message,status, from, reason, id;

    public Transaction(String amount, String type, String message,String status, String from, String reason, String id){
        this.amount = amount;
        this.type = type;
        this.message  = message;
        this.status  = status;
        this.from = from;
        this.reason = reason;
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getFrom() {
        return from;
    }

    public String getReason() {
        return reason;
    }

    public String getId() {
        return id;
    }
}
