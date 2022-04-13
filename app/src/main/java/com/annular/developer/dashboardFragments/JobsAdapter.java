package com.annular.developer.dashboardFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.annular.developer.R;

import java.util.ArrayList;
import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {

    public Context context;
    public List<JobsModel> joblist;

    public JobsAdapter(Context context, List<JobsModel> joblist) {
        this.context = context;
        this.joblist = joblist;
    }

    public JobsAdapter() {
    }

    @NonNull
    @Override
    public JobsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.jobitem,parent,false);
            return new JobsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsAdapter.MyViewHolder holder, int position) {
            holder.title.setText(joblist.get(position).getJob_title());
            holder.salary.setText(joblist.get(position).getSalary());
            holder.desc.setText(joblist.get(position).getJob_description());
            holder.recruitType.setText(joblist.get(position).getRecruitment_type());

    }

    @Override
    public int getItemCount() {
        return joblist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView salary;
        public TextView desc;
        public TextView recruitType;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.jobtitle);
            salary = (TextView) itemView.findViewById(R.id.salary);
            desc = (TextView) itemView.findViewById(R.id.desc);
            recruitType = (TextView) itemView.findViewById(R.id.recruit);
        }
    }
}
