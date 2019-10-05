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
import com.example.sastra.adapters.EmployeeAdapter;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Employees;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EmployeesActivity extends AppCompatActivity {
    MyDbHelper mDatabase;
    private ArrayList<Employees> allContacts=new ArrayList<>();
    private EmployeeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        mDatabase = new MyDbHelper(this);
        shoodata();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.employee_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeesActivity.this,AddEmployeesActivity.class));

            }
        });
    }
    public void shoodata(){
        FrameLayout fLayout = (FrameLayout) findViewById(R.id.emp_frame_layout);

        RecyclerView contactView = (RecyclerView)findViewById(R.id.employee_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new MyDbHelper(this);
        allContacts = mDatabase.listEmployee();

        if(allContacts.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new EmployeeAdapter(this, allContacts);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }

}
