package com.annular.developer.recruiterDashboardFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.annular.developer.R;
import com.annular.developer.dashboardFragments.JobsAdapter;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecruiterHomeAdapter extends RecyclerView.Adapter<RecruiterHomeAdapter.MyViewHolder>{

    public Context context;
    public List<RecruiterHomeModel> recruiterHomeModelList;

    public RecruiterHomeAdapter(Context context, List<RecruiterHomeModel> recruiterHomeModelList) {
        this.context = context;
        this.recruiterHomeModelList = recruiterHomeModelList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.recruiter_home_content,parent,false);
        View view = LayoutInflater.from(context).inflate(R.layout.recruiter_home_content,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        RecruiterHomeModel recruiterHomeModel = recruiterHomeModelList.get(position);
        holder.username.setText(recruiterHomeModelList.get(position).getUsername());
        holder.skills.setText(recruiterHomeModelList.get(position).getSkills());
    }

    @Override
    public int getItemCount() {
        return recruiterHomeModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView username;
    TextView skills;


    public MyViewHolder(@NotNull View itemView){
        super(itemView);

        username = (TextView) itemView.findViewById(R.id.dev_username);
        skills = (TextView) itemView.findViewById(R.id.dev_skills);
    }
}
}

