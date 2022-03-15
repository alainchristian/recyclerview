package com.example.recyclerview;

public class Student {
    String stName,stPhone,stFaculty,stEmail;

    public Student(String stName, String stPhone, String stFaculty, String stEmail) {
        this.stName = stName;
        this.stPhone = stPhone;
        this.stFaculty = stFaculty;
        this.stEmail = stEmail;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStPhone() {
        return stPhone;
    }

    public void setStPhone(String stPhone) {
        this.stPhone = stPhone;
    }

    public String getStFaculty() {
        return stFaculty;
    }

    public void setStFaculty(String stFaculty) {
        this.stFaculty = stFaculty;
    }

    public String getStEmail() {
        return stEmail;
    }

    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }
}
