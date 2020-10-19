package com.example.labworkone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bo.User;

public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.layout_cell);
        final List<User> users = new ArrayList<>() ;
        final RecyclerView recyclerView = findViewById(R.id.recylerView);
        final MyAdapter adapter = new MyAdapter(users) ;
        recyclerView.setAdapter(adapter) ;

        //We configure the click on the save button
        findViewById(R.id.floatingButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openLogInPage();
    }

    private void openLogInPage() {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }
}

