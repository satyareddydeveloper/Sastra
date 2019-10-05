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
import com.example.sastra.onlyjavaclasses.Departments;

public class AddDepartmentdetailsActivity extends AppCompatActivity {
    EditText deptname,manager,contactperson;
    Button save;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_departmentdetails);
        save = findViewById(R.id.btndept);

        myDbHelper = new MyDbHelper(this);
        deptname = findViewById(R.id.edtdepartname);
        manager = findViewById(R.id.edtmanagername);
        contactperson = findViewById(R.id.edtcontactperson);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empid = deptname.getText().toString().trim();
                String name = manager.getText().toString().trim();
                String email = contactperson.getText().toString().trim();
                Departments departments = new Departments(empid,name,email);
                myDbHelper.addDepartment(departments);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddDepartmentdetailsActivity.this, DepartmentsActivity.class));
                finish();
            }
        });
    }
}
