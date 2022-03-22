package com.annular.developer.dashboardFragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annular.developer.R;

import java.util.ArrayList;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link jobsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class jobsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<JobsModel> jobsList = new ArrayList<>();
    JobsAdapter adapter;


//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;
//
    public jobsFragment() {
        // Required empty public constructor
    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment jobsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static jobsFragment newInstance(String param1, String param2) {
//        jobsFragment fragment = new jobsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jobs, container, false);

        recyclerView = recyclerView.findViewById(R.id.jobs_recycler);
        adapter = new JobsAdapter(getContext(),jobsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new JobsAdapter(jobsList);
//        recyclerView.setAdapter(adapter);
//
//        initData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    private void initData() {
        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
                "$10","Entry Level",
                "Android software development is the process by which " +
                        "applications are created for devices running the Android operating system"));

        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
                "$10","Entry Level",
                "Android software development is the process by which " +
                        "applications are created for devices running the Android operating system"));

        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
                "$10","Entry Level",
                "Android software development is the process by which " +
                        "applications are created for devices running the Android operating system"));

        jobsList.add(new JobsModel("Mobile App Developer Needed For small tasks",
                "$10","Entry Level",
                "Android software development is the process by which " +
                        "applications are created for devices running the Android operating system"));
    }


//    private void initRecyclerView() {
//
//
//        recyclerView = recyclerView.findViewById(R.id.recyleview);
//        linearLayoutManager = new LinearLayoutManager(this.getContext());
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter =  new JobsAdapter(jobsList, getContext());
//        recyclerView.setAdapter(adapter);
//         adapter.notifyDataSetChanged();
//
//
//
//
//    }

//    private void setupData(List<JobsModel> jobsList) {
//
//        adapter=new JobsAdapter(jobsList, getContext());
//        recyclerView.setAdapter(adapter);
//
//    }


}