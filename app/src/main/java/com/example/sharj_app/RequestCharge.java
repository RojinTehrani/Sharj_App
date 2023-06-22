package com.example.sharj_app;

public class RequestCharge {
    private String MobileNo;
    private String mid;
    private int OperatorType;
    private int AmountPure;

    public RequestCharge(String mobileNo, String mid, int operatorType, int amountPure) {
        MobileNo = mobileNo;
        this.mid = mid;
        OperatorType = operatorType;
        AmountPure = amountPure;
    }
}
