package com.example.finalpractice;

public class Phone {
    int phoneColor;
    String phoneName;

    public Phone(int phoneColor, String phoneName) {
        this.phoneColor = phoneColor;
        this.phoneName = phoneName;
    }


    public int getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(int phoneColor) {
        this.phoneColor = phoneColor;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }
}
