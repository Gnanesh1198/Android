package com.annular.developer.recruiterDashboardFragments;

public class RecruiterHomeModel {

    public String dev_username;
    public String dev_skills;
    public String exp;

    public RecruiterHomeModel() {
    }

    public RecruiterHomeModel(String dev_username, String dev_skills, String exp) {
        this.dev_username = dev_username;
        this.dev_skills = dev_skills;
        this.exp = exp;
    }

    public String getDev_username() {
        return dev_username;
    }

    public void setDev_username(String dev_username) {
        this.dev_username = dev_username;
    }

    public String getDev_skills() {
        return dev_skills;
    }

    public void setDev_skills(String dev_skills) {
        this.dev_skills = dev_skills;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
