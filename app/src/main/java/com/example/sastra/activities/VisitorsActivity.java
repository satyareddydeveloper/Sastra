package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sastra.MainActivity;
import com.example.sastra.R;
import com.example.sastra.adapters.CompanyAdapter;
import com.example.sastra.adapters.VisitorAdapter;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Company;
import com.example.sastra.onlyjavaclasses.Visitors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class VisitorsActivity extends AppCompatActivity {
    private ArrayList<Visitors> allContacts=new ArrayList<>();
    private VisitorAdapter mAdapter;
    MyDbHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitors);
        mDatabase= new MyDbHelper(this);
        shoodata();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.visitorfloatingaction);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitorsActivity.this,AddVisitorActivity.class));

                //addTaskDialog(); same methode
                // i wrote in adduserActivity : whenever user click add floating button it will take y to AddUserActivity

            }
        });

    }
    public void shoodata(){
        FrameLayout fLayout = (FrameLayout) findViewById(R.id.visitorframlayout);

        RecyclerView contactView = (RecyclerView)findViewById(R.id.visitorrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new MyDbHelper(this);
        allContacts = mDatabase.listVisitor();

        if(allContacts.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new VisitorAdapter(this, allContacts);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }

}
