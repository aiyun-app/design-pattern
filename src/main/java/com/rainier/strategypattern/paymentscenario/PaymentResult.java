package com.rainier.strategypattern.paymentscenario;

public class PaymentResult {
    private String code;
    private String message;
    private Object data;

    public PaymentResult(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Code：" + code + " Message:" + message + " Data:" + data;
    }
}
