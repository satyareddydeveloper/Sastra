package com.example.sastra.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sastra.R;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Departments;
import com.example.sastra.onlyjavaclasses.Visitors;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.
        CompanyViewHolder>{


    private Context context;
    private ArrayList<Visitors> listContacts;
    private ArrayList<Visitors> mArrayList;

    private MyDbHelper mDatabase;
    public VisitorAdapter(Context context, ArrayList<Visitors> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new MyDbHelper(context);
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.displayusercard, parent, false);
        return new VisitorAdapter.CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        final Visitors contacts = listContacts.get(position);

        holder.companyphone.setText(contacts.getVisitorMobile());
        holder.companymobile.setText(contacts.getVisitorName());
        holder.companyname.setText(contacts.getVisitorEmail());
        holder.companyemail.setText(contacts.getVisitorCompany());
        holder.companycontactperson.setText(contacts.getVisitorRole());
        holder.companyadress.setText(contacts.getVisitorProof());
        holder.companydescription.setText(contacts.getVisitorProofNumber());
        holder.adress.setText(contacts.getVisitorAdress());
        holder.editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTaskDialog(contacts);
            }
        });
        holder.deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletedialog(contacts);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }


    public class CompanyViewHolder extends RecyclerView.ViewHolder{
        public TextView companyphone, companymobile, companyname,
                companyemail, companycontactperson, companyadress,
                companydescription,adress;
        public ImageView deleteContact;
        public ImageView editContact;
        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyphone = (TextView) itemView.findViewById(R.id.tv_employee_id);
            companymobile = (TextView) itemView.findViewById(R.id.tv_username);
            companyname = (TextView) itemView.findViewById(R.id.tv_Email);
            companyemail = (TextView) itemView.findViewById(R.id.tv_mobileno);
            companycontactperson=itemView.findViewById(R.id.tv_department);
            companyadress=itemView.findViewById(R.id.tv_role);
            adress=itemView.findViewById(R.id.tv_adress);
            companydescription=itemView.findViewById(R.id.tv_joiningdate);
            deleteContact = (ImageView)itemView.findViewById(R.id.delete_contact);
            editContact = (ImageView)itemView.findViewById(R.id.edit_contact);
        }
    }
    private void editTaskDialog(final Visitors visitors){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_visitor_layout, null);
        final Spinner company= subView.findViewById(R.id.edt_visitor_company);
        final Spinner role= subView.findViewById(R.id.visitor_role_spinner);
        final Spinner proof = subView.findViewById(R.id.visitor_prrof_spinner);


        final EditText usermobile = (EditText)subView.findViewById(R.id.edt_visitor_mobile);
        final EditText username = (EditText)subView.findViewById(R.id.edt_visitor_username);
        final EditText useremail = (EditText)subView.findViewById(R.id.edt_visitor_email);
        final EditText proofno = (EditText)subView.findViewById(R.id.edt_visitor_proofno);
        final EditText adreess = (EditText)subView.findViewById(R.id.edt_visitor_adress);

        if(visitors != null){
            usermobile.setText(visitors.getVisitorMobile());
            username.setText(visitors.getVisitorName());
            useremail.setText(visitors.getVisitorEmail());
            proofno.setText(visitors.getVisitorProofNumber());
/////////////////////////////////////////////////////////////////////

            String compareValue = visitors.getVisitorCompany();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.company, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            company.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                company.setSelection(spinnerPosition);
            }
       /////     /////////////////////////////////////////////////////////////////
            String compareValue2 = visitors.getVisitorRole();
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context, R.array.role, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            role.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition2 = adapter2.getPosition(compareValue2);
                role.setSelection(spinnerPosition2);
            }
////////////////////////////////////////////////////////////////////////
            String compareValue3= visitors.getVisitorProof();
            ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context, R.array.departments, android.R.layout.simple_spinner_item);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            role.setAdapter(adapter3);
            if (compareValue != null) {
                int spinnerPosition3 = adapter3.getPosition(compareValue3);
                proof.setSelection(spinnerPosition3);
            }

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Edit Details</font>"));

        builder.setView(subView);
        builder.create();

        builder.setPositiveButton("EDIT EMPLOYEE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String umobile = usermobile.getText().toString();
                final String uname = username.getText().toString();

                final String uemail = useremail.getText().toString();
                final String proofndo=proofno.getText().toString();
                final String addd = adreess.getText().toString();




                String comp = company.getSelectedItem().toString();
                String rol = role.getSelectedItem().toString();
                String proo = proof.getSelectedItem().toString();



                if(TextUtils.isEmpty(umobile)||TextUtils.isEmpty(uname)||TextUtils.isEmpty(uemail)){
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{
                    mDatabase.updateVisitors(new Visitors(visitors.getVISITORID(),umobile,
                                    uname,uemail,comp,rol,proo,proofndo,addd));



                    //refresh the activity
                    ((Activity)context).finish();
                    context.startActivity(((Activity)context).getIntent());
                }
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Task cancelled", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
    private void deletedialog(final Visitors contacts){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Are You Sure Want To Delete</font>"));
        builder.create();
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if(contacts != null){
                    mDatabase.deleteVisitors(contacts.getVISITORID());
                    ((Activity)context).finish();
                    context.startActivity(((Activity) context).getIntent());
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Task cancelled", Toast.LENGTH_LONG).show();

            }

        });
        builder.show();







    }


}
