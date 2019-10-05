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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ContactViewHolder>  {


    private Context context;
    private ArrayList<Departments> listContacts;
    private ArrayList<Departments> mArrayList;

    private MyDbHelper mDatabase;
    public DepartmentAdapter(Context context, ArrayList<Departments> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new MyDbHelper(context);
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displayusercard, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final Departments contacts = listContacts.get(position);
        holder.empid.setText(contacts.getDepartname());
        holder.name.setText(contacts.getManager());
        holder.email.setText(contacts.getContactperson());
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

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        public TextView empid, name, email, mobile, depart, role, joing;
        public ImageView deleteContact;
        public ImageView editContact;

        public ContactViewHolder(View itemView) {
            super(itemView);
            empid = (TextView) itemView.findViewById(R.id.tv_employee_id);
            name = (TextView) itemView.findViewById(R.id.tv_username);
            email = (TextView) itemView.findViewById(R.id.tv_Email);
            mobile = (TextView) itemView.findViewById(R.id.tv_mobileno);
            deleteContact = (ImageView)itemView.findViewById(R.id.delete_contact);
            editContact = (ImageView)itemView.findViewById(R.id.edit_contact);
        }
    }
    private void editTaskDialog(final Departments contacts){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_department_layout, null);
        final EditText userid = (EditText)subView.findViewById(R.id.edtdepartname);
        final EditText username = (EditText)subView.findViewById(R.id.edtmanagername);
        final EditText useremail = (EditText)subView.findViewById(R.id.edtcontactperson);

        if(contacts != null){
            userid.setText(contacts.getDepartname());
            username.setText(contacts.getManager());
            useremail.setText(contacts.getContactperson());




        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Edit Details</font>"));

        builder.setView(subView);
        builder.create();

        builder.setPositiveButton("EDIT EMPLOYEE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String uid = userid.getText().toString();
                final String uname = username.getText().toString();

                final String uemail = useremail.getText().toString();


                Date date = new Date();
                String mStringDate = DateFormat.getDateTimeInstance().format(date);

                if(TextUtils.isEmpty(uid)||TextUtils.isEmpty(uname)||TextUtils.isEmpty(uemail)){
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{
                    mDatabase.updateContacts(new Departments
                            (contacts.getDepartmentid(),uid,
                            uname,uemail));

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
    private void deletedialog(final Departments contacts){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Are You Sure Want To Delete</font>"));
        builder.create();
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if(contacts != null){
                    mDatabase.deleteContact(contacts.getDepartmentid());
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
