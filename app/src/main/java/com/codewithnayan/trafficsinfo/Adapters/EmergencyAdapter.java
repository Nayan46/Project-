package com.codewithnayan.trafficsinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithnayan.trafficsinfo.Models.EmergencyModel;
import com.codewithnayan.trafficsinfo.R;

import java.util.ArrayList;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.viewHolder>{

    ArrayList<EmergencyModel> list;
    Context context;

    public EmergencyAdapter(ArrayList<EmergencyModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.emergency_recycler_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        EmergencyModel model = list.get(position);
        holder.textView.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_emergency);
        }
    }
}
