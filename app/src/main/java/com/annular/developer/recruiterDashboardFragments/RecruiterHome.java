package com.annular.developer.recruiterDashboardFragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
// * Use the {@link RecruiterHome#newInstance} factory method to
// * create an instance of this fragment.
// */
public class RecruiterHome extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<RecruiterHomeModel> recruiterHomeModels;
    RecruiterHomeAdapter recruiterHomeAdapter;
    RecruiterResponse developerList;
    CardView cardView;



    public RecruiterHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_recruiter_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Call<List<RecruiterHomeModel>> call = ApiClient.getservice().getRecruiter();
        call.enqueue(new Callback<List<RecruiterHomeModel>>() {
            @Override
            public void onResponse(Call<List<RecruiterHomeModel>> call, Response<List<RecruiterHomeModel>> response) {
                recruiterHomeModels = response.body();
                for(int i=0;i<recruiterHomeModels.size();i++){
                    recyclerView = view.findViewById(R.id.recruiter_home_recycler);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recruiterHomeAdapter = new RecruiterHomeAdapter(RecruiterHome.this.getActivity(),recruiterHomeModels);
                    recyclerView.setAdapter(recruiterHomeAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<RecruiterHomeModel>> call, Throwable throwable) {

                Toast.makeText(RecruiterHome.this.getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, throwable.getMessage());
            }
        });



    }




//    private void data(){
//        recruiterHomeModels = new ArrayList<>();
//        recruiterHomeModels.add(new RecruiterHomeModel("gnaneshwaran", "java, spring Boot", "1"));
//        recruiterHomeModels.add(new RecruiterHomeModel("ganesh", "android Development", "2"));
//        recruiterHomeModels.add(new RecruiterHomeModel("madhan", "react, Angular", "5"));
//        recruiterHomeModels.add(new RecruiterHomeModel("dinesh", "spring, Java", "1"));
//        recruiterHomeModels.add(new RecruiterHomeModel("mani", "java", "2"));
//        recruiterHomeModels.add(new RecruiterHomeModel("jaga", "Testing", "10"));
//        recruiterHomeModels.add(new RecruiterHomeModel("manish", "c++", "2"));
//        recruiterHomeModels.add(new RecruiterHomeModel("kesavan", "Typescript", "2"));
//        recruiterHomeModels.add(new RecruiterHomeModel("charan", "Automation", "2"));
//    }
}