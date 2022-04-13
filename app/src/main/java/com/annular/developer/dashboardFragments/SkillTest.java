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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillTest extends Fragment {

    RecyclerView recyclerView;
    List<SkillTestModel> skillTestModels;
    SkillTestAdapter skillTestAdapter;


    public SkillTest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Call<List<SkillTestModel>> call = ApiClient.getservice().getLanguages();
        call.enqueue(new Callback<List<SkillTestModel>>() {
            @Override
            public void onResponse(Call<List<SkillTestModel>> call, Response<List<SkillTestModel>> response) {

                skillTestModels = response.body();
                for(int i=0;i<skillTestModels.size();i++){
                    recyclerView = view.findViewById(R.id.skill_test_recycler);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    skillTestAdapter = new SkillTestAdapter(SkillTest.this.getActivity(),skillTestModels);
                    recyclerView.setAdapter(skillTestAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<SkillTestModel>> call, Throwable throwable) {
                Toast.makeText(SkillTest.this.getActivity(), "API not getting", Toast.LENGTH_SHORT).show();
                Log.d(TAG, throwable.getMessage());
            }
        });
    }
}