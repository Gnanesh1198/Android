package com.annular.developer;

import com.annular.developer.dashboardFragments.JobsModel;
import com.annular.developer.dashboardFragments.SkillTestModel;
import com.annular.developer.recruiterDashboardFragments.RecruiterHomeModel;
import com.annular.developer.recruiterDashboardFragments.RecruiterResponse;
import com.annular.developer.recruiterDto.RecruiterLoginRes;
import com.annular.developer.recruiterDto.RecruiterReqDto;
import com.annular.developer.recruiterDto.RecruiterRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("devconnect/CreateProfile/developerSignUp")
    Call<RegisterRes> registerUser(@Body RegisterReq registerReq);

    @POST("Recruiter/signUp")
    Call<RecruiterRes> recruiterSignup(@Body RecruiterReqDto recruiterReqDto);

    @GET("Recruiter/login")
    Call<RecruiterLoginRes> recruiterLogin(@Query("EmailId") String email_id, @Query("Password") String password);

    @GET("devconnect/CreateProfile/devs")
    Call<List<RecruiterHomeModel>> getRecruiter();

    @GET("devconnect/jobs/allJobs")
    Call<List<JobsModel>> getAllJobs();

    @GET("skillTest/getAllLanguages")
    Call<List<SkillTestModel>> getLanguages();
}
