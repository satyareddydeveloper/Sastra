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
import com.example.sastra.onlyjavaclasses.Locations;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder>{

    private Context context;
    private ArrayList<Locations> listContacts;
    private ArrayList<Locations> mArrayList;

    private MyDbHelper mDatabase;
    public LocationAdapter(Context context, ArrayList<Locations>
            listContacts) {
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList=listContacts;
        mDatabase = new MyDbHelper(context);
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.displayusercard, parent, false);
        return new LocationViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        final Locations contacts = listContacts.get(position);
        holder.empid.setText(contacts.getLocationname());
        holder.name.setText(contacts.getLoactionDescription());

        holder.editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               editTaskDialog(contacts);
            }
        });
        holder.deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletelocations(contacts);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listContacts.size();

    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{
        public TextView empid, name, email, mobile, depart, role, joing;
        public ImageView deleteContact;
        public ImageView editContact;


        public LocationViewHolder(@NonNull View itemView) {

            super(itemView);

            empid = (TextView) itemView.findViewById(R.id.tv_employee_id);
            name = (TextView) itemView.findViewById(R.id.tv_username);
            email = (TextView) itemView.findViewById(R.id.tv_Email);
            mobile = (TextView) itemView.findViewById(R.id.tv_mobileno);
            deleteContact = (ImageView)itemView.findViewById(R.id.delete_contact);
            editContact = (ImageView)itemView.findViewById(R.id.edit_contact);

        }
    }
    private void editTaskDialog(final Locations locations){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.add_locations_layout,
                null);

        final EditText userid = (EditText)subView.
                findViewById(R.id.edtlocationname);
        final EditText username = (EditText)subView.
                findViewById(R.id.edtlocationdescription);

        if(locations != null){
            userid.setText(locations.getLocationname());
            username.setText(locations.getLoactionDescription());


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



                Date date = new Date();
                String mStringDate = DateFormat.getDateTimeInstance().format(date);

                if(TextUtils.isEmpty(uid)||TextUtils.isEmpty(uname)){
                    Toast.makeText(context, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                }
                else{
                    mDatabase.updateLocations(new Locations(locations.
                            getLocationid(),uid,uname));



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
    private void deletelocations(final Locations locations){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Html.fromHtml("<font color='#FF7F27'>Are You Sure Want To Delete</font>"));
        builder.create();
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if(locations != null){
                    mDatabase.deletelist(locations.getLocationid());
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
