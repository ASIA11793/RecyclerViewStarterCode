package com.example.recyclerviewstudentversion;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Todo Implement methods required
//onCreateViewHolder()
//onBindViewHolder
//getItemCount
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>implements Filterable {
    private List<Player> listofPlayers;
    private List<Player> filterList;


    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if(charString.isEmpty()){
                    filterList=listofPlayers;
                }
                else{
                    List<Player> filteredList=new ArrayList<>();
                    for(Player row : listofPlayers){
                        if(row.getName().toLowerCase().contains(charString)||row.getName().contains(charString)){//need simplification
                            filteredList.add(row);

                        }

                    }
                    filterList=filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    filterList=(ArrayList<Player>)filterResults.values;
                     notifyDataSetChanged();
            }
        };
    }

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
        listofPlayers = Players1;
        filterList=Players1;
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
        holder.name.setText(filterList.get(position).getName());
        holder.age.setText("age"+filterList.get(position).getage());
        holder.worth.setText("worth"+filterList.get(position).getWorth());
        holder.sport.setText("sport"+filterList.get(position).getMainsport());
        holder.img.setImageResource(filterList.get(position).getImage());


    }




    @Override
    public int getItemCount() {
        return filterList.size();
    }


}

