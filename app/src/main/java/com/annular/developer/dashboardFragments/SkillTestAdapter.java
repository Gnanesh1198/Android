package com.annular.developer.dashboardFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.annular.developer.R;

import java.util.List;

public class SkillTestAdapter extends RecyclerView.Adapter<SkillTestAdapter.ViewHolder> {

    public Context context;
    public List<SkillTestModel> skillTestModels;

    public SkillTestAdapter(Context context, List<SkillTestModel> skillTestModels) {
        this.context = context;
        this.skillTestModels = skillTestModels;
    }

    public SkillTestAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.skill_test_recycler_content,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillTestAdapter.ViewHolder holder, int position) {

        holder.lang.setText(skillTestModels.get(position).getLanguages());

    }

    @Override
    public int getItemCount() {
        return skillTestModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView lang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lang = (TextView) itemView.findViewById(R.id.skill_language);
        }
    }
}
