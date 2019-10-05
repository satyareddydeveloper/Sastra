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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sastra.R;
import com.example.sastra.database.MyDbHelper;
import com.example.sastra.onlyjavaclasses.Company;
import com.example.sastra.onlyjavaclasses.Departments;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private Context context;
    private ArrayList<Company> listContacts;
    private ArrayList<Company> mArrayList;

    private MyDbHelper mDatabase;
    public CompanyAdapter(Context context, ArrayList<Company> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new MyDbHelper(context);
    }



    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displayusercard, parent, false);
        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        final Company contacts = listContacts.get(position);
        holder.companyphone.setText(contacts.getCompanyPhone());
        holder.companymobile.setText(contacts.getCompanyMobile());
        holder.companyname.setText(contacts.getCompanyName());
        holder.companyemail.setText(contacts.getCompanyEmail());
        holder.companycontactperson.setText(contacts.getCompanyContactPerson());
        holder.companyadress.setText(contacts.getCompanyAdress());
        holder.companydescription.setText(contacts.getCompanyDescription());
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
                companyemail, companycontactperson, companyadress, companydescription;
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
            companydescription=itemView.findViewById(R.id.tv_joiningdate);
            deleteContact = (ImageView)itemView.findViewById(R.id.delete_contact);
            editContact = (ImageView)itemView.findViewById(R.id.edit_contact);
        }
    }
    private void editTaskDialog(final Company contacts){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_company_layout, null);
      final EditText  phone=subView.findViewById(R.id.edt_company_phoneno);
        final EditText  mobile=subView.findViewById(R.id.edt_company_mobile);
        final EditText   name=subView.findViewById(R.id.edt_company_name);
        final EditText   email=subView.findViewById(R.id.edt_company_email);
        final EditText   contactperson= subView.findViewById(R.id.edt_company_contactperson);
        final EditText   adress=subView.findViewById(R.id.edt_company_adress);
        final EditText   description=subView.findViewById(R.id.edt_company_description);
        if(contacts != null){
            phone.setText(contacts.getCompanyPhone());
            mobile.setText(contacts.getCompanyMobile());
            name.setText(contacts.getCompanyName());
            email.setText(contacts.getCompanyEmail());
            contactperson.setText(contacts.getCompanyContactPerson());
            adress.setText(contacts.getCompanyAdress());
            description.setText(contacts.getCompanyDescription());




        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Edit Details</font>"));

        builder.setView(subView);
        builder.create();

        builder.setPositiveButton("EDIT EMPLOYEE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String compone = phone.getText().toString();
                final String commob = mobile.getText().toString();

                final String comname = name.getText().toString();
                final String comemail = email.getText().toString();
                final String comcontactper = contactperson.getText().toString();

                final String comadress = adress.getText().toString();
                final String comdescript = description.getText().toString();





                Date date = new Date();
                String mStringDate = DateFormat.getDateTimeInstance().format(date);

                if(TextUtils.isEmpty(compone)||TextUtils.isEmpty(commob)||TextUtils.isEmpty(comadress)){
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{
                    mDatabase.updatecompany(new Company(contacts.getCompanyId(),compone,commob,comname,comemail,comcontactper,comadress,comdescript));

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
    private void deletedialog(final Company contacts){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Are You Sure Want To Delete</font>"));


        builder.create();
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if(contacts != null){
                    mDatabase.deleteCompany(contacts.getCompanyId());
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
