package com.example.labworkone;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bo.User;

public final class MyItem
        extends RecyclerView.ViewHolder
{
    private final TextView textView;
    public MyItem(@NonNull View itemView)
    {
        super(itemView);
        textView = itemView.findViewById(R.id.myTextView);
    }
    public void updateViewHolder(User user)
    {
        textView.setText(user.name);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }
        });
    }
}