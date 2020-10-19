package com.example.labworkone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bo.User;

public class MyAdapter  extends RecyclerView.Adapter<MyItem>
{
    // For Data
    private final List<User> users;

    // Constructor
    MyAdapter (List<User> users)
    {
        this.users = users ;
    }
    @NonNull
    @Override
    public MyItem onCreateViewHolder (@NonNull ViewGroup parent , int viewType)
    {
        final View view = LayoutInflater. from(parent.getContext()).inflate(R.layout.layout_cell, parent ,
                false);
        return new MyItem(view) ;
    }
    @Override
    public void onBindViewHolder (@NonNull MyItem holder , int position)
    {
        holder.updateViewHolder( users.get(position)) ;
    }
    @Override
    public int getItemCount ()
    {
        return users.size() ;
    }
}