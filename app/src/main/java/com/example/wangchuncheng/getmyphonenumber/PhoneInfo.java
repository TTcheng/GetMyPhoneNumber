package com.example.wangchuncheng.getmyphonenumber;

/**
 * Created by WangChunCheng on 2017/12/11.
 */

public class PhoneInfo {
    String name,number;
    public PhoneInfo(String name,String phoneNumber){
        setName(name);
        setNumber(phoneNumber);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
