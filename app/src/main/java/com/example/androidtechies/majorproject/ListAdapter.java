package com.example.androidtechies.majorproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TANSU on 22/03/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    ArrayList<InformationModel> informationList;
    Context context;
    ClickListener listener;


    public ListAdapter(ArrayList<InformationModel> informationList , Context context, ClickListener listener) {
        this.informationList = informationList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_project_item, parent , false);
        final MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.projectTitle.setText(informationList.get(position).getTitleOfProject());
        holder.technologyUsed.setText(informationList.get(position).getTechnologyUsed());
    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView projectTitle;
        TextView technologyUsed;
        public MyViewHolder(View itemView) {
            super(itemView);
            projectTitle = itemView.findViewById(R.id.list_item_heading);
            technologyUsed = itemView.findViewById(R.id.list_item_tech);
        }
    }

    public interface ClickListener {
        void onItemClick(View v, int position);

    }
}
