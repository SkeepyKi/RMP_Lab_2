package com.example.lab_2;

public class MessageEvent {
    private final String text;

    public MessageEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}