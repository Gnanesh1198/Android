package com.annular.developer.dashboardFragments;

public class JobsModel {

        public String jobtitle;
        public String salary;
        public String explevel;
        public String description;

    public JobsModel() {
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public String getSalary() {
        return salary;
    }

    public String getExplevel() {
        return explevel;
    }

    public String getDescription() {
        return description;
    }

    public JobsModel(String jobtitle, String salary, String explevel, String description) {
        this.jobtitle = jobtitle;
        this.salary = salary;
        this.explevel = explevel;
        this.description = description;




    }
}
