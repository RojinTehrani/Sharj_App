package com.example.sharj_app;

public class UserRequest {
    public String getFixedLineNumber() {
        return FixedLineNumber;
    }

    public void setFixedLineNumber(String fixedLineNumber) {
        FixedLineNumber = fixedLineNumber;
    }

    public UserRequest(String fixedLineNumber) {
        FixedLineNumber = fixedLineNumber;
    }

    private String FixedLineNumber;
}
