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
    public ArrayList<JobsModel> joblist;

    public JobsAdapter(Context context, ArrayList<JobsModel> joblist) {
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
            holder.title.setText(joblist.get(position).getJobtitle());
            holder.salary.setText(joblist.get(position).getSalary());
            holder.expLevel.setText(joblist.get(position).getExplevel());
            holder.desc.setText(joblist.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return joblist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView salary;
        public TextView expLevel;
        public TextView desc;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.jobtitle);
            salary = (TextView) itemView.findViewById(R.id.salary);
            expLevel = (TextView) itemView.findViewById(R.id.explevel);
            desc = (TextView) itemView.findViewById(R.id.desc);
        }


//        public void setData(String titlename, String fixed, String budgets, String budget_label, String exps, String exp_label, String descs, String divi) {
//
//            title.setText(titlename);
//            fixedprice.setText(fixed);
//            budget.setText(budgets);
//            budgetlabel.setText(budget_label);
//            exp.setText(exps);
//            explabel.setText(exp_label);
//            desc.setText(descs);
//            div.setText(divi);
//        }
    }
}
