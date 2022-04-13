package com.annular.developer.recruiterDashboardFragments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecruiterHomeModel {

    @SerializedName("username")
    public String username;

    @SerializedName("skills")
    public String skills;

    @SerializedName("experience")
    public String experience;

    public RecruiterHomeModel() {
    }

    public RecruiterHomeModel(String username, String skills, String experience) {
        this.username = username;
        this.skills = skills;
        this.experience = experience;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
