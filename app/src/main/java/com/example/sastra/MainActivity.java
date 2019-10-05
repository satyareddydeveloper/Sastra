package com.example.sastra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.sastra.activities.ApplicationSettingsActivity;
import com.example.sastra.activities.CompanyActivity;
import com.example.sastra.activities.DepartmentsActivity;
import com.example.sastra.activities.EmployeesActivity;
import com.example.sastra.activities.LocationsActivity;
import com.example.sastra.activities.OurDetailsActivity;
import com.example.sastra.activities.VisitorsActivity;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI==0){
                        Intent intent = new Intent(MainActivity.this, EmployeesActivity.class);
                        startActivity(intent);
                    }else if (finalI==1){
                        startActivity(new Intent(MainActivity.this, ApplicationSettingsActivity.class));


                    }else if (finalI==2){
                        startActivity(new Intent(MainActivity.this, DepartmentsActivity.class));


                    }else if (finalI==3){
                        startActivity(new Intent(MainActivity.this, LocationsActivity.class));


                    }else if (finalI==4){
                        startActivity(new Intent(MainActivity.this, CompanyActivity.class));

                    }else if (finalI==5){
                        startActivity(new Intent(MainActivity.this, VisitorsActivity.class));

                    }else if (finalI==6){
                        startActivity(new Intent(MainActivity.this, OurDetailsActivity.class));
                    }

                }
            });
        }
    }
}
