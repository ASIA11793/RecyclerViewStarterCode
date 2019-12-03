package com.example.recyclerviewstudentversion;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Todo Implement methods required
//onCreateViewHolder()
//onBindViewHolder
//getItemCount
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private View view;
    private List<Player> listofPlayers;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age, worth,sport;
        public ImageView img;
        public MyViewHolder(View view) {
            super(view);
            name=view.findViewById(R.id.name);
            age=view.findViewById(R.id.age);
            worth=view.findViewById(R.id.money);
            sport=view.findViewById(R.id.sport);
            img=view.findViewById(R.id.ima);
        }
    }

    public MyRecyclerAdapter(List<Player> Players1) {
        this.listofPlayers = Players1;
    }


    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.single_item, parent, false);

        // Return a new holder instance
        MyViewHolder viewHolder = new MyViewHolder(contactView);
        return viewHolder;
}

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText("name "+listofPlayers.get(position).getName());
        holder.age.setText("age"+listofPlayers.get(position).getage());
        holder.worth.setText("worth"+listofPlayers.get(position).getWorth());
        holder.sport.setText("sport"+listofPlayers.get(position).getMainsport());
        holder.img.setImageResource(listofPlayers.get(position).getImage());


    }




    @Override
    public int getItemCount() {
        return listofPlayers.size();
    }


}

