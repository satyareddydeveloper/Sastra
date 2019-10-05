
package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sastra.MainActivity;
import com.example.sastra.R;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Locations;

public class AddLocationsActivity extends AppCompatActivity {
    EditText locationname,description;
    Button save;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_locations);
        locationname = findViewById(R.id.edtlocationname);
        description=findViewById(R.id.edtlocationdescription);
        myDbHelper=new MyDbHelper(this);
        save = findViewById(R.id.btnlocationsave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = locationname.getText().toString().trim();
                String des = description.getText().toString().trim();
                Locations locations = new Locations(name,des);

                 myDbHelper.addLocations(locations);

                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                //  Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                // finish();
                //startActivity(getIntent());
                startActivity(new Intent(AddLocationsActivity.this, LocationsActivity.class));
                finish();

            }
        });
    }
}
