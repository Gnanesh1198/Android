package com.annular.developer.recruiterDashboardFragments;

import java.util.ArrayList;
import java.util.List;

public class RecruiterResponse {

    ArrayList<RecruiterHomeModel> fetchDeveloper;

    public RecruiterResponse(ArrayList<RecruiterHomeModel> fetchDeveloper) {
        this.fetchDeveloper = fetchDeveloper;
    }

    public List<RecruiterHomeModel> getFetchDeveloper() {
        return fetchDeveloper;
    }

    public void setFetchDeveloper(ArrayList<RecruiterHomeModel> fetchDeveloper) {
        this.fetchDeveloper = fetchDeveloper;
    }


}
