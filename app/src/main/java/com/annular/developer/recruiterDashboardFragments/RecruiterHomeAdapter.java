package com.annular.developer.recruiterDashboardFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.annular.developer.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecruiterHomeAdapter extends RecyclerView.Adapter<RecruiterHomeAdapter.MyViewHolder>{

    public Context context;
    public ArrayList<RecruiterHomeModel> recruiterHomeModelList;

    public RecruiterHomeAdapter(Context context, ArrayList<RecruiterHomeModel> recruiterHomeModelList) {
        this.context = context;
        this.recruiterHomeModelList = recruiterHomeModelList;
    }

    public RecruiterHomeAdapter() {
    }


    @NonNull
    @Override
    public RecruiterHomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recruiter_home_content,parent,false);
        return new RecruiterHomeAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        RecruiterHomeModel recruiterHomeModel = recruiterHomeModelList.get(position);
        holder.username.setText(recruiterHomeModelList.get(position).getDev_username());
        holder.skills.setText(recruiterHomeModelList.get(position).getDev_skills());
        holder.exp.setText(recruiterHomeModelList.get(position).getExp());
    }

    @Override
    public int getItemCount() {
        return recruiterHomeModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView username;
    public TextView skills;
    public TextView exp;


    public MyViewHolder(@NotNull View itemView){
        super(itemView);

        username = (TextView) itemView.findViewById(R.id.dev_username);
        skills = (TextView) itemView.findViewById(R.id.dev_skills);
        exp = (TextView) itemView.findViewById(R.id.dev_exp);
    }
}
}

