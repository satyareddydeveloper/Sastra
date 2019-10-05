package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sastra.R;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Company;

public class AddCompanyActivity extends AppCompatActivity {
    EditText phone,mobile,name,email,contactperson,adress,description;
    MyDbHelper myDbHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);
        myDbHelper=new MyDbHelper(this);
        phone=findViewById(R.id.edt_company_phoneno);
        mobile=findViewById(R.id.edt_company_mobile);
        name=findViewById(R.id.edt_company_name);
        email=findViewById(R.id.edt_company_email);
        contactperson= findViewById(R.id.edt_company_contactperson);
        adress=findViewById(R.id.edt_company_adress);
        description=findViewById(R.id.edt_company_description);
        button=findViewById(R.id.btn_companysave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyphone=phone.getText().toString().trim();
                String companymobile=mobile.getText().toString().trim();
                String companyname=name.getText().toString().trim();
                String companyemail=email.getText().toString().trim();
                String companycontactperson=contactperson.getText().toString().trim();
                String companyadress=adress.getText().toString().trim();
                String companydescription=description.getText().toString().trim();
                Company company = new Company(companyphone,companymobile,companyname,companyemail,companycontactperson,companyadress,companydescription);

                myDbHelper.addCopanydetails(company);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();


                startActivity(new Intent(AddCompanyActivity.this, CompanyActivity.class));
                finish();
            }
        });


    }
}
