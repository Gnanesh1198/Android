package com.annular.developer.recruiterDashboardFragments;

public class RecruiterModel {

    int id;
    String username, skills, experience;

    public RecruiterModel(int id, String username, String skills, String experience) {
        this.id = id;
        this.username = username;
        this.skills = skills;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
