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
import com.example.sastra.onlyjavaclasses.Company;
import com.example.sastra.onlyjavaclasses.Visitors;

public class AddVisitorActivity extends AppCompatActivity {
    MyDbHelper mDatabase;
    Button add;
    Spinner selectrole,selectproof,selectcompany;
    EditText editmobile,edtname,editemail,prooofno,adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visitor);
        mDatabase= new MyDbHelper(this);
        editmobile=findViewById(R.id.edt_visitor_mobile);
        edtname = findViewById(R.id.edt_visitor_username);
        editemail=findViewById(R.id.edt_visitor_email);
        selectcompany=findViewById(R.id.edt_visitor_company);
        prooofno=findViewById(R.id.edt_visitor_proofno);
        adress=findViewById(R.id.edt_visitor_adress);
        selectrole=findViewById(R.id.visitor_role_spinner);
        selectproof=findViewById(R.id.visitor_prrof_spinner);
        add=findViewById(R.id.visitorsave);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visitormobile = editmobile.getText().toString();
                String visitorname = edtname.getText().toString();
                String visitoremail = editemail.getText().toString();

                String visitorcompany = selectcompany.getSelectedItem().toString();
                String visitorrole = selectrole.getSelectedItem().toString();
                String visitorproof = selectproof.getSelectedItem().toString();


                String visitorproofno = prooofno.getText().toString();
                String visitoradress = adress.getText().toString();
                Visitors company= new Visitors(visitormobile,visitorname,visitoremail,
                       visitorcompany,visitorrole,visitorproof, visitorproofno,visitoradress);
                mDatabase.addVisitors(company);
                Toast.makeText(getApplicationContext(),"cuccss",Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddVisitorActivity.this, VisitorsActivity.class));
                finish();

            }
        });

    }
}
