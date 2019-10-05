package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sastra.MainActivity;
import com.example.sastra.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OurDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_details);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabourdetails);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OurDetailsActivity.this,AddOurDetauksActivity.class));

                //addTaskDialog(); same methode
                // i wrote in adduserActivity : whenever user click add floating button it will take y to AddUserActivity

            }
        });

    }
}
