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
import com.example.sastra.onlyjavaclasses.Employees;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ContactViewHolder> {
    private Context context;
    private ArrayList<Employees> listContacts;
    private ArrayList<Employees> mArrayList;

    private MyDbHelper mDatabase;

    public EmployeeAdapter(Context context, ArrayList<Employees>
            listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new MyDbHelper(context);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_employee, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final Employees contacts = listContacts.get(position);

        holder.name.setText(contacts.getEmpName());
        holder.email.setText(contacts.getEmpEmail());
        holder.mobile.setText(contacts.getEmpMobile());
        holder.depart.setText(contacts.getEmpDepartment());
        holder.role.setText(contacts.getRole());
        holder.empid.setText(contacts.getAdress());
        holder.joing.setText(contacts.getJoiningDate());
        holder.deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletedialog(contacts);
            }
        });
        holder.editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTaskDialog(contacts);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        public TextView empid,name,email,mobile,depart,role,joing;
        public ImageView deleteContact;
        public  ImageView editContact;

        public ContactViewHolder(View itemView) {
            super(itemView);
            empid = (TextView)itemView.findViewById(R.id.tv_adress2);
            name = (TextView)itemView.findViewById(R.id.tv_username);
            email = (TextView)itemView.findViewById(R.id.tv_Email);
            mobile = (TextView)itemView.findViewById(R.id.tv_mobileno);
            depart = (TextView)itemView.findViewById(R.id.tv_department);
            role = (TextView)itemView.findViewById(R.id.tv_role);
            joing = (TextView)itemView.findViewById(R.id.tv_joiningdate);
            deleteContact = (ImageView)itemView.findViewById(R.id.delete_contact);
            editContact = (ImageView)itemView.findViewById(R.id.edit_contact);
        }
    }
    private void deletedialog(final Employees contacts){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Are You Sure Want To Delete</font>"));
        builder.create();
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if(contacts != null){
                    mDatabase.deleteEmployee(contacts.getEmpId());
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
    private void editTaskDialog(final Employees contacts){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_employee, null);


        final EditText username = (EditText)subView.findViewById(R.id.edtusername);
        final EditText useremail = (EditText)subView.findViewById(R.id.edtemail);
        final EditText usermobile = (EditText)subView.findViewById(R.id.edtmobile);
        final EditText adress = (EditText)subView.findViewById(R.id.edt_employee_adress);
        final Spinner department = subView.findViewById(R.id.spinnerDepartment);
        final Spinner role = subView.findViewById(R.id.spinnerRole);
        if(contacts != null){
            username.setText(contacts.getEmpName());
            useremail.setText(contacts.getEmpEmail());
            usermobile.setText(contacts.getEmpMobile());
            adress.setText(contacts.getAdress());
            String compareValue = contacts.getEmpDepartment();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.departments, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            department.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                department.setSelection(spinnerPosition);
            }
////////////////////////////
            String rolecompare = contacts.getRole();
            ArrayAdapter<CharSequence> roleadapter = ArrayAdapter.createFromResource(context, R.array.role, android.R.layout.simple_spinner_item);
            roleadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            role.setAdapter(roleadapter);
            if (rolecompare != null) {
                int spinnerPosition = roleadapter.getPosition(rolecompare);
                role.setSelection(spinnerPosition);
            }






        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Edit Details</font>"));

        builder.setView(subView);
        builder.create();

        builder.setPositiveButton("EDIT EMPLOYEE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final String uname = username.getText().toString();


                final String uemail = username.getText().toString();

                final String adresss = adress.getText().toString();
                final String umobile = usermobile.getText().toString();
                String dept = department.getSelectedItem().toString();
                String roles = role.getSelectedItem().toString();


                Date date = new Date();
                String mStringDate = DateFormat.getDateTimeInstance().format(date);

                if(TextUtils.isEmpty(adresss)||TextUtils.isEmpty(uname)||TextUtils.isEmpty(uemail)){
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{
                    mDatabase.updateEmployees(new Employees(contacts.getEmpId(),
                                    uname,uemail,umobile,dept,roles,adresss,mStringDate));



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



}
