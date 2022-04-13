package com.annular.developer.dashboardFragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.annular.developer.ApiClient;
import com.annular.developer.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link jobsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class jobsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<JobsModel> jobsList ;
    JobsAdapter adapter;
//    LinearLayoutManager layoutManager;


    public jobsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jobs, container, false);


//        adapter = new JobsAdapter(getContext(),jobsList);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Call<List<JobsModel>> call = ApiClient.getservice().getAllJobs();
        call.enqueue(new Callback<List<JobsModel>>() {
            @Override
            public void onResponse(Call<List<JobsModel>> call, Response<List<JobsModel>> response) {

                jobsList = response.body();
                for (int i=0;i<jobsList.size();i++){
                    recyclerView = view.findViewById(R.id.jobs_recycler);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    adapter = new JobsAdapter(jobsFragment.this.getActivity(),jobsList);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<JobsModel>> call, Throwable throwable) {

                Toast.makeText(jobsFragment.this.getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, throwable.getMessage());
            }
        });

    }

    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        initData();
//    }
//
//    private void initData() {
//        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
//                "$10","Entry Level",
//                "Android software development is the process by which " +
//                        "applications are created for devices running the Android operating system"));
//
//        jobsList.add(new JobsModel("Web Development",
//                "$20","Entry Level",
//                "Web development is the work involved in developing " +
//                        "a website for the Internet or an intranet. Web development can range from developing a simple single static page of plain text to complex web applications, electronic businesses, and social network services"));
//
//        jobsList.add(new JobsModel("Testing Automation",
//                "$10","Entry Level",
//                "Test automation is the process of leveraging automation tools" +
//                        "to maintain test data, execute tests, and analyze test results to improve software quality"));
//
//        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
//                "$10","Entry Level",
//                "Android software development is the process by which " +
//                        "applications are created for devices running the Android operating system"));
//    }





}