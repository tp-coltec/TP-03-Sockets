package com.example.haasi.tp_03;

public class Message {
    String Message;
    boolean Control_mine;

    public Message (String message, boolean control_mine){
        this.Message = message;
        this.Control_mine = control_mine;
    }

    public boolean isControl_mine() {
        return Control_mine;
    }

    public void setControl_mine(boolean control_mine) {
        Control_mine = control_mine;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
