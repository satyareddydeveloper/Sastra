package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sastra.MainActivity;
import com.example.sastra.R;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Employees;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEmployeesActivity extends AppCompatActivity implements View.OnClickListener {
    MyDbHelper mDatabase;
    Button add;
    Spinner edtdepart,edtrole;
    EditText edtname,editemail,edtmobile,edtadress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employees);
        add=findViewById(R.id.buttonAddEmployee);
        add.setOnClickListener(this);
        mDatabase=new MyDbHelper(this);
        edtadress=findViewById(R.id.edt_employee_adress);
        editemail=findViewById(R.id.edtemail);
        edtname = findViewById(R.id.edtusername);
        edtmobile=findViewById(R.id.edtmobile);
        edtdepart = findViewById(R.id.spinnerDepartment);
        edtrole = findViewById(R.id.spinnerRole);
    }

    @Override
    public void onClick(View view) {
        addTask();
    }
    public void addTask(){
       // String empid = edtid.getText().toString().trim();
        String name = edtname.getText().toString().trim();
        String email = editemail.getText().toString().trim();
        String mobile = edtmobile.getText().toString().trim();
        String depart = edtdepart.getSelectedItem().toString();
        String role = edtrole.getSelectedItem().toString();
        String adresss = edtadress.getText().toString();
        //getting the current time for joining date
        Date date = new Date();
        String mStringDate = DateFormat.getDateTimeInstance().format(date);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:a");
        String joiningDate = sdf.format(cal.getTime());
        Employees employees= new Employees(name,email,mobile,
                depart,role,adresss,mStringDate);
         mDatabase.addEmployee(employees);
        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
        //  Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        // finish();
        //startActivity(getIntent());
        startActivity(new Intent(AddEmployeesActivity.this, EmployeesActivity.class));
        finish();


    }

}
