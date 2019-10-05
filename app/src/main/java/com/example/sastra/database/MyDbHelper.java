package com.example.sastra.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sastra.onlyjavaclasses.Company;
import com.example.sastra.onlyjavaclasses.Departments;
import com.example.sastra.onlyjavaclasses.Employees;
import com.example.sastra.onlyjavaclasses.Locations;
import com.example.sastra.onlyjavaclasses.Visitors;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "hjkl";
    ///////////////////////////////////////////////////////////
    private	static final String TABLE_DEPARTMENTS = "departments";
    private static final String COLUMN_DEPARTMENTNAME = "DEPARTMENTNAME";
    private static final String COLUMN_MANAGER = "MANAGER";
    private static final String COLUMN_DEPTID = "departid";
    private static final String COLUMN_CONTACTPERSON = "CONTACTPESON";

///////////////////////////////////////////////////////////////////////



    private	static final String TABLE_LOCATIONS = "LOCATIONS";
    private static final String COLUMN_LOCATIONNAME = "LOCATIONNAME";
    private static final String COLUMN_LOCATION_DESCRIPTION = "LOCATIONDESCRIPTION";
    private static final String COLUMN_LOCATIONID = "LOCATIONID";






    ///////////////////////////////////////////////////////////////////
    private	static final String TABLE_COMPANY = "companyd";
    private static final String COLUMN_COMPANY_ID = "_companyid";
    private static final String COLUMN_COMPANY_PHONE = "companyphone";
    private static final String COLUMN_COMPANY_MOBILE = "companymobile";

    private static final String COLUMN_COMPANY_NAME = "companyname";
    private static final String COLUMN_COMPANY_EMAIL = "companyemail";

    private static final String COLUMN_COMPANY_CONTACT_PERSON = "companycontactperson";
    private static final String COLUMN_COMPANY_ADRESS = "companyadress";
    private static final String COLUMN_COMPANY_DESCRIPTION = "companydesctiption";


    //////////////////////////////////////////////////////////////////
    private	static final String TABLE_VISITOR = "VISITOR";
    private static final String COLUMN_VISITOR_ID = "VISITORID";
    private static final String COLUMN_VISITOR_MOBILE = "VISITORMOBILE";


    private static final String COLUMN_VISITOR_NAME = "VISITORNAME";
    private static final String COLUMN_VISITOR_EMAIL = "VISITOREMAIL";

    private static final String COLUMN_VISITOR_COMPANY = "VISITORCOMPANY";
    private static final String COLUMN_VISITOR_ROLE = "VISITORROLE";
    private static final String COLUMN_VISITOR_PROOF= "VISITORPROOF";
    private static final String COLUMN_VISITOR_PROOFNUMBER= "VISITORPROOFNO";
    private static final String COLUMN_VISITOR_ADRESS= "VISITORADRESS";




    //////////////////////////////////////////////////////////////////
    private	static final String TABLE_EMPLOYEE = "employee";

    private static final String COLUMN_EMPID = "empid";
    private static final String COLUMN_NAME = "contactname";

    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NO = "phno";

    private static final String COLUMN_DEPART = "department";
    private static final String COLUMN_ROLE = "role";
    private static final String COLUMN_Joiningdate = "joingdate";
    private static final String COLUMN_ADRESS = "ADRESS";
////////////////////////////////////////////////////////////////////////
    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_EMPLOYEE_TABLE = "CREATE	TABLE " + TABLE_EMPLOYEE + "" +
                "(" + COLUMN_EMPID + " INTEGER PRIMARY KEY,"  +
                COLUMN_NAME + " text," +COLUMN_EMAIL+" text, "+COLUMN_NO+" text, "
                +COLUMN_DEPART+" text ,"+COLUMN_ROLE+" text, "+COLUMN_ADRESS+" TEXT, "+COLUMN_Joiningdate+" text "+ ")";

/////////////////////////////////////////////////////////////////////////
        String	CREATE_DEPARTMENT_TABLE = "CREATE	TABLE " + TABLE_DEPARTMENTS + "" +
                "(" + COLUMN_DEPTID + " INTEGER PRIMARY KEY," + COLUMN_DEPARTMENTNAME + " TEXT," +
                COLUMN_MANAGER + " text," +COLUMN_CONTACTPERSON+" text "+")";
////////////////////////////////////////////////////////////////////////////////
        String	CREATE_LOCATION_TABLE = "CREATE	TABLE " + TABLE_LOCATIONS + "" +
                "(" + COLUMN_LOCATIONID + " INTEGER PRIMARY KEY," + COLUMN_LOCATIONNAME + " TEXT," +
                COLUMN_LOCATION_DESCRIPTION + " text" +")";
/////////////////////////////////////////////////////////////////////////
        String	CREATE_COMPANY_TABLE = "CREATE	TABLE " + TABLE_COMPANY + "" +
                "(" + COLUMN_COMPANY_ID + " INTEGER PRIMARY KEY," + COLUMN_COMPANY_PHONE + " TEXT," +
                COLUMN_COMPANY_MOBILE + " text," +COLUMN_COMPANY_NAME+" text, "+COLUMN_COMPANY_EMAIL+" text, "
                +COLUMN_COMPANY_CONTACT_PERSON+" text ,"+COLUMN_COMPANY_ADRESS+
                " text, "+COLUMN_COMPANY_DESCRIPTION+" text "+ ")";
///////////////////////////////////////////////////////
        String	CREATE_VISITOR_TABLE = "CREATE	TABLE " + TABLE_VISITOR + "" +
                "(" + COLUMN_VISITOR_ID + " INTEGER PRIMARY KEY," + COLUMN_VISITOR_MOBILE + " TEXT," +
                COLUMN_VISITOR_NAME+ " text," +COLUMN_VISITOR_EMAIL+" text, "+COLUMN_VISITOR_COMPANY+" text, "
                +COLUMN_VISITOR_ROLE+" text ,"+COLUMN_VISITOR_PROOF+
                " text, "+COLUMN_VISITOR_PROOFNUMBER+" text, "+COLUMN_VISITOR_ADRESS+" TEXT "+ ")";

        db.execSQL(CREATE_EMPLOYEE_TABLE);
        db.execSQL(CREATE_DEPARTMENT_TABLE);
        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_COMPANY_TABLE);
        db.execSQL(CREATE_VISITOR_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITOR);
        onCreate(db);
    }
    ///////////////////////////////////////////////////
        public void addEmployee(Employees employees){

            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, employees.getEmpName());
            values.put(COLUMN_EMAIL, employees.getEmpEmail());
            values.put(COLUMN_NO, employees.getEmpMobile());

            values.put(COLUMN_DEPART, employees.getEmpDepartment());
            values.put(COLUMN_ROLE, employees.getRole());
            values.put(COLUMN_ADRESS, employees.getAdress());
            values.put(COLUMN_Joiningdate, employees.getJoiningDate());

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_EMPLOYEE, null, values);
        }
    public void updateEmployees(Employees employees){
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, employees.getEmpName());
        values.put(COLUMN_EMAIL, employees.getEmpEmail());
        values.put(COLUMN_NO, employees.getEmpMobile());

        values.put(COLUMN_DEPART, employees.getEmpDepartment());
        values.put(COLUMN_ROLE, employees.getRole());
        values.put(COLUMN_ADRESS, employees.getAdress());
        values.put(COLUMN_Joiningdate, employees.getJoiningDate());




        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EMPLOYEE, values, COLUMN_EMPID
                + "	= ?", new String[] { String.valueOf(employees.
                getEmpId())});
    }

    ///////////////////////////////////////////////////////////////
        public ArrayList<Employees> listEmployee(){
            String sql = "select * from " + TABLE_EMPLOYEE;
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<Employees> storeContacts = new ArrayList<>();
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor.moveToFirst()){
                do{
                    int id = Integer.parseInt(cursor.getString(0));
                    String name = cursor.getString(1);
                    String email = cursor.getString(2);
                    String phno = cursor.getString(3);
                    String depart = cursor.getString(4);
                    String role = cursor.getString(5);
                    String adress = cursor.getString(6);
                    String date = cursor.getString(7);
                    storeContacts.add(new Employees( id,name, email,phno,depart,role,adress,date));
                }while (cursor.moveToNext());
            }
            cursor.close();
            return storeContacts;
        }



        //////////////////////////////////////////////////////////
        public void deleteEmployee(int id) {
            try {

                SQLiteDatabase db = this.getWritableDatabase();
                db.delete(TABLE_EMPLOYEE, COLUMN_EMPID+ "	= ?", new String[]{String.valueOf(id)});


            } catch (Exception e) {
                e.getMessage();
            }
        }


    //////////////////////////////////////////////////////////////////
        public void addDepartment(Departments departments){
             ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_DEPARTMENTNAME,departments.getDepartname());
            contentValues.put(COLUMN_MANAGER,departments.getManager());
            contentValues.put(COLUMN_CONTACTPERSON,departments.getContactperson());
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.insert(TABLE_DEPARTMENTS, null, contentValues);

        }
        public ArrayList<Departments> listDepartment(){
            String sql = "select * from " + TABLE_DEPARTMENTS;
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<Departments> storeContacts = new ArrayList<>();
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor.moveToFirst()){
                do{
                    int id = Integer.parseInt(cursor.getString(0));
                    String empid = cursor.getString(1);
                    String name = cursor.getString(2);
                    String email = cursor.getString(3);

                    storeContacts.add(new Departments(id,empid, name, email));
                }while (cursor.moveToNext());
            }
            cursor.close();
            return storeContacts;
        }
    public void updateContacts(Departments contacts){
        ContentValues values = new ContentValues();

       values.put(COLUMN_DEPARTMENTNAME, contacts.getDepartname());
        values.put(COLUMN_MANAGER,contacts.getManager());
        values.put(COLUMN_CONTACTPERSON, contacts.getContactperson());


        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_DEPARTMENTS, values, COLUMN_DEPTID
                + "	= ?", new String[] { String.valueOf(contacts.getDepartmentid())});
    }
    public void deleteContact(int id) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_DEPARTMENTS, COLUMN_DEPTID+ "	= ?", new String[]{String.valueOf(id)});


        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void addLocations(Locations locations){

        ContentValues values = new ContentValues();

        values.put(COLUMN_LOCATIONNAME, locations.getLocationname());
        values.put(COLUMN_LOCATION_DESCRIPTION, locations.getLoactionDescription());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LOCATIONS, null, values);
    }
    public ArrayList<Locations> listLocations(){
        String sql = "select * from " + TABLE_LOCATIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Locations> storeContactss = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String locationname = cursor.getString(1);
                String locationdescription = cursor.getString(2);

                storeContactss.add(new Locations(id,locationname,locationdescription));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeContactss;
    }
    public void updateLocations(Locations locations){
        ContentValues values = new ContentValues();

        values.put(COLUMN_LOCATIONNAME, locations.getLocationname());
        values.put(COLUMN_LOCATION_DESCRIPTION,locations.
                getLoactionDescription());



        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_LOCATIONS, values, COLUMN_LOCATIONID
                + "	= ?", new String[] { String.valueOf(locations.
                getLocationid())});
    }

    public void deletelist(int id) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_LOCATIONS, COLUMN_LOCATIONID+ "	" +
                    "= ?", new String[]{String.valueOf(id)});


        } catch (Exception e) {
            e.getMessage();
        }




    }
    public void addCopanydetails(Company company){

        ContentValues values = new ContentValues();
       // values.put(COLUMN_COMPANY_ID, contacts.getName());
        values.put(COLUMN_COMPANY_PHONE, company.getCompanyPhone());
        values.put(COLUMN_COMPANY_MOBILE, company.getCompanyMobile());
        values.put(COLUMN_COMPANY_NAME, company.getCompanyName());
        values.put(COLUMN_COMPANY_EMAIL, company.getCompanyEmail());
        values.put(COLUMN_COMPANY_CONTACT_PERSON, company.getCompanyContactPerson());
        values.put(COLUMN_COMPANY_ADRESS, company.getCompanyAdress());
        values.put(COLUMN_COMPANY_DESCRIPTION,company.getCompanyDescription());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_COMPANY, null, values);
    }

//////////////////////////////////////////////////////////////
 public ArrayList<Company> listCompany(){
    String sql = "select * from " + TABLE_COMPANY;
    SQLiteDatabase db = this.getReadableDatabase();
    ArrayList<Company> storeContactss = new ArrayList<>();
    Cursor cursor = db.rawQuery(sql, null);
    if(cursor.moveToFirst()){
        do{
            int id = Integer.parseInt(cursor.getString(0));
            String companyphone = cursor.getString(1);
            String companymobile = cursor.getString(2);
            String companyname = cursor.getString(3);
            String companyemail = cursor.getString(4);
            String companycontactperson = cursor.getString(5);
            String companyadress = cursor.getString(6);
            String companydesctiption = cursor.getString(7);


            storeContactss.add(new Company(id,companyphone,companymobile,companyname,companyemail,companycontactperson,companyadress,companydesctiption));
        }while (cursor.moveToNext());
    }
    cursor.close();
    return storeContactss;
}
    public void updatecompany(Company company){
        ContentValues values = new ContentValues();

        values.put(COLUMN_COMPANY_PHONE, company.getCompanyPhone());
        values.put(COLUMN_COMPANY_MOBILE, company.getCompanyMobile());
        values.put(COLUMN_COMPANY_NAME, company.getCompanyName());
        values.put(COLUMN_COMPANY_EMAIL, company.getCompanyEmail());
        values.put(COLUMN_COMPANY_CONTACT_PERSON, company.getCompanyContactPerson());
        values.put(COLUMN_COMPANY_ADRESS, company.getCompanyAdress());
        values.put(COLUMN_COMPANY_DESCRIPTION,company.getCompanyDescription());
        SQLiteDatabase db = this.getWritableDatabase();


        db.update(TABLE_COMPANY, values, COLUMN_COMPANY_ID
                + "	= ?", new String[] { String.valueOf(company.
                getCompanyId())});
    }
/////////////////////////////////////////////////////////////////////
  public void deleteCompany(int id) {
    try {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMPANY, COLUMN_COMPANY_ID+ "	" +
                "= ?", new String[]{String.valueOf(id)});


    } catch (Exception e) {
        e.getMessage();
    }
}
//////////////////////////////////////////////////////////
public void addVisitors(Visitors visitors){

    ContentValues values = new ContentValues();
    values.put(COLUMN_VISITOR_MOBILE, visitors.getVisitorMobile());
    values.put(COLUMN_VISITOR_NAME, visitors.getVisitorName());
    values.put(COLUMN_VISITOR_EMAIL, visitors.getVisitorEmail());
    values.put(COLUMN_VISITOR_COMPANY, visitors.getVisitorCompany());
    values.put(COLUMN_VISITOR_ROLE, visitors.getVisitorRole());
    values.put(COLUMN_VISITOR_PROOF, visitors.getVisitorProof());
    values.put(COLUMN_VISITOR_PROOFNUMBER, visitors.getVisitorProofNumber());
    values.put(COLUMN_VISITOR_ADRESS,visitors.getVisitorAdress());
    SQLiteDatabase db = this.getWritableDatabase();
    db.insert(TABLE_VISITOR, null, values);
}

    public ArrayList<Visitors> listVisitor(){
        String sql = "select * from " + TABLE_VISITOR;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Visitors> storeContactss = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String visitorphone = cursor.getString(1);
                String visitorname = cursor.getString(2);
                String visitoremail = cursor.getString(3);
                String visitorcompany = cursor.getString(4);
                String visitorrole = cursor.getString(5);
                String visitorproof = cursor.getString(6);
                String visitorproofno = cursor.getString(7);
                String visitoradress = cursor.getString(8);


                storeContactss.add(new Visitors(id,visitorphone,visitorname
                        ,visitoremail,visitorcompany,visitorrole,
                        visitorproof,visitorproofno,visitoradress));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeContactss;
    }

    public void updateVisitors(Visitors visitors){
        ContentValues values = new ContentValues();

        values.put(COLUMN_VISITOR_MOBILE, visitors.getVisitorMobile());
        values.put(COLUMN_VISITOR_NAME, visitors.getVisitorName());
        values.put(COLUMN_VISITOR_EMAIL, visitors.getVisitorEmail());
        values.put(COLUMN_VISITOR_COMPANY, visitors.getVisitorCompany());
        values.put(COLUMN_VISITOR_ROLE, visitors.getVisitorRole());
        values.put(COLUMN_VISITOR_PROOF, visitors.getVisitorProof());
        values.put(COLUMN_VISITOR_PROOFNUMBER, visitors.getVisitorProofNumber());
        values.put(COLUMN_VISITOR_ADRESS,visitors.getVisitorAdress());
        SQLiteDatabase db = this.getWritableDatabase();

        db.update(TABLE_VISITOR, values, COLUMN_VISITOR_ID
                + "	= ?", new String[] { String.valueOf(visitors.getVISITORID())});
    }
    public void deleteVisitors(int id) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_VISITOR, COLUMN_VISITOR_ID+ "	" +
                    "= ?", new String[]{String.valueOf(id)});


        } catch (Exception e) {
            e.getMessage();
        }




    }



}
