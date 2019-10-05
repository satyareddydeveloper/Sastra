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
import com.example.sastra.adapters.DepartmentAdapter;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Departments;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity {
    private ArrayList<Departments> allContacts=new ArrayList<>();
    private DepartmentAdapter mAdapter;
    MyDbHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        mDatabase= new MyDbHelper(this);

        //////////////////////////
        shoodata();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabdepartment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentsActivity.this,AddDepartmentdetailsActivity.class));

                //addTaskDialog(); same methode
                // i wrote in adduserActivity : whenever user click add floating button it will take y to AddUserActivity

            }
        });

    }
    public void shoodata(){
        FrameLayout fLayout = (FrameLayout) findViewById(R.id.departact);

        RecyclerView contactView = (RecyclerView)findViewById(R.id.depart_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new MyDbHelper(this);
        allContacts = mDatabase.listDepartment();

        if(allContacts.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new DepartmentAdapter(this, allContacts);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }

}
