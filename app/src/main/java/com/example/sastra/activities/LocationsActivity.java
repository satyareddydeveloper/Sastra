package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sastra.MainActivity;
import com.example.sastra.R;
import com.example.sastra.adapters.DepartmentAdapter;
import com.example.sastra.adapters.LocationAdapter;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Departments;
import com.example.sastra.onlyjavaclasses.Locations;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LocationsActivity extends AppCompatActivity {
    private ArrayList<Locations> allContacts=new ArrayList<>();
    private LocationAdapter mAdapter;
    MyDbHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        mDatabase= new MyDbHelper(this);

        //////////////////////////
        shoodata();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fablocations);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LocationsActivity.this,AddLocationsActivity.class));

                //addTaskDialog(); same methode
                // i wrote in adduserActivity : whenever user click add floating button it will take y to AddUserActivity

            }
        });

    }
    public void shoodata(){
        FrameLayout fLayout = (FrameLayout) findViewById(R.id.locaionframe);

        RecyclerView contactView = (RecyclerView)findViewById(R.id.loctionlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new MyDbHelper(this);
        allContacts = mDatabase.listLocations();

        if(allContacts.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new LocationAdapter(this, allContacts);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }


}
