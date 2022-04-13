package com.annular.developer.dashboardFragments;

public class JobsModel {

        public String job_title;
        public String salary;
        public String skills;
        public String job_description;
        public String recruitment_type;

    public JobsModel() {
    }

    public String getRecruitment_type() {
        return recruitment_type;
    }

    public void setRecruitment_type(String recruitment_type) {
        this.recruitment_type = recruitment_type;
    }

    public JobsModel(String job_title, String salary, String skills, String job_description,String recruitment_type) {
        this.job_title = job_title;
        this.salary = salary;
        this.skills = skills;
        this.job_description = job_description;
        this.recruitment_type = recruitment_type;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }


}

