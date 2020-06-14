package com.codewithnayan.trafficsinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithnayan.trafficsinfo.Models.RuleModel;
import com.codewithnayan.trafficsinfo.R;

import java.util.ArrayList;

public class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.viewHolder1>{
    ArrayList<RuleModel> list1;
    Context context1;

    public RuleAdapter(ArrayList<RuleModel> list1, Context context1) {
        this.list1 = list1;
        this.context1 = context1;
    }

    @NonNull
    @Override
    public viewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item_list_trules, parent, false);
        return new viewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder1 holder, int position) {

        RuleModel model1 = list1.get(position);
        holder.textView1.setText(model1.getTxt());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class viewHolder1 extends RecyclerView.ViewHolder {

        TextView textView1;
        public viewHolder1(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.txt_list_trules);

        }
    }
}
