package com.example.finalpractice;

import java.time.LocalDate;

public class DeepPhone {
   int id;
   String companyName;
   String monthlyRate;
   String phoneCameraSpec;

    String phoneTotalPrice;
   int phonePicDrawable;

   LocalDate phonereleaseDate;

    public DeepPhone(int id, String companyName, String monthlyRate, String phoneCameraSpec, String phoneTotalPrice, int phonePicDrawable, LocalDate phonereleaseDate) {
        this.id = id;
        this.companyName = companyName;
        this.monthlyRate = monthlyRate;
        this.phoneCameraSpec = phoneCameraSpec;
        this.phoneTotalPrice = phoneTotalPrice;
        this.phonePicDrawable = phonePicDrawable;
        this.phonereleaseDate = phonereleaseDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(String monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getPhoneCameraSpec() {
        return phoneCameraSpec;
    }

    public void setPhoneCameraSpec(String phoneCameraSpec) {
        this.phoneCameraSpec = phoneCameraSpec;
    }

    public int getPhonePicDrawable() {
        return phonePicDrawable;
    }

    public void setPhonePicDrawable(int phonePicDrawable) {
        this.phonePicDrawable = phonePicDrawable;
    }

    public LocalDate getPhonereleaseDate() {
        return phonereleaseDate;
    }

    public void setPhonereleaseDate(LocalDate phonereleaseDate) {
        this.phonereleaseDate = phonereleaseDate;
    }

    public String getPhoneTotalPrice() {
        return phoneTotalPrice;
    }

    public void setPhoneTotalPrice(String phoneTotalPrice) {
        this.phoneTotalPrice = phoneTotalPrice;
    }

    @Override
    public String toString() {
        return "DeepPhone{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", monthlyRate='" + monthlyRate + '\'' +
                ", phoneCameraSpec='" + phoneCameraSpec + '\'' +
                ", phoneTotalPrice=" + phoneTotalPrice +
                ", phonePicDrawable=" + phonePicDrawable +
                ", phonereleaseDate=" + phonereleaseDate +
                '}';
    }
}
