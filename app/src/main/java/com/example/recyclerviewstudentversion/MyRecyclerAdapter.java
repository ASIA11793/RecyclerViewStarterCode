package com.example.recyclerviewstudentversion;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Todo Implement methods required
//onCreateViewHolder()
//onBindViewHolder
//getItemCount
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private View view;
    private List<Player> listofPlayers;

    public MyAdapter(List<Player> Players1) {
        listofPlayers = Players1;
    }


    @Override
    public MyViewHolder ViewHolderonCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = parent.getContext().getSystemService();
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {

        return listofPlayers.size();
    }


    // Todo implement ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // get references to each of the views in the single_item.xml
        // Todo implement constructor
        private MyViewHolder(@NonNull View itemView) {

        }
    }
}

