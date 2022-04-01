package com.annular.developer.recruiterDashboardFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
// * Use the {@link RecruiterHome#newInstance} factory method to
// * create an instance of this fragment.
// */
public class RecruiterHome extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<RecruiterHomeModel> recruiterHomeModels = new ArrayList<>();
    RecruiterHomeAdapter recruiterHomeAdapter;
    ArrayList<RecruiterModel> developerList;



    public RecruiterHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_recruiter_home, container, false);

        recyclerView = view.findViewById(R.id.recruiter_home_recycler);

        recruiterHomeAdapter = new RecruiterHomeAdapter(getContext(), recruiterHomeModels);
        recyclerView.setAdapter(recruiterHomeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data();
    }


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        recyclerView = view.findViewById(R.id.recruiter_home_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        Call<RecruiterResponse> call = ApiClient.getservice().getRecruiter();
//        call.enqueue(new Callback<RecruiterResponse>() {
//            @Override
//            public void onResponse(Call<RecruiterResponse> call, Response<RecruiterResponse> response) {
//                if(response.isSuccessful()){
//                    developerList = response.body().getFetchDeveloper();
//                    recyclerView.setAdapter(new RecruiterHomeAdapter(getActivity(), developerList));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecruiterResponse> call, Throwable throwable) {
//                Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    private void data(){
        recruiterHomeModels = new ArrayList<>();
        recruiterHomeModels.add(new RecruiterHomeModel("gnaneshwaran", "java, spring Boot", "1"));
        recruiterHomeModels.add(new RecruiterHomeModel("ganesh", "android Development", "2"));
        recruiterHomeModels.add(new RecruiterHomeModel("madhan", "react, Angular", "5"));
        recruiterHomeModels.add(new RecruiterHomeModel("dinesh", "spring, Java", "1"));
        recruiterHomeModels.add(new RecruiterHomeModel("mani", "java", "2"));
        recruiterHomeModels.add(new RecruiterHomeModel("jaga", "Testing", "10"));
        recruiterHomeModels.add(new RecruiterHomeModel("manish", "c++", "2"));
        recruiterHomeModels.add(new RecruiterHomeModel("kesavan", "Typescript", "2"));
        recruiterHomeModels.add(new RecruiterHomeModel("charan", "Automation", "2"));
    }
}