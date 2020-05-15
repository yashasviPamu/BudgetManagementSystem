package com.example.budgetmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class myDbAdapter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="mydbadapter";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="AMOUNT";

    public myDbAdapter(Context ct)
    {
        super(ct,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Budget_table(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AMOUNT INTEGER)");
    }
    public boolean insertValues(String s1, String l)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,s1);
        cv.put(COL_3,l);
        Long result = db.insert("Budget_table",null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS Budget_table");
       onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "Select * from Budget_table";
        Cursor res = db.rawQuery(query, null);
        return res;
    }
    public int getAdditionOfBudget(){
        int sum=0;
        SQLiteDatabase db = getReadableDatabase();
        String query1= "Select SUM(AMOUNT) as Total from Budget_table where NAME like 'B%'";
        Cursor res1 = db.rawQuery(query1,null);
        if(res1.moveToFirst())
            sum= res1.getInt(res1.getColumnIndex("Total"));
        return sum;
    }
    public int getAdditionOfExpense(){
        int sum=0;
        SQLiteDatabase db = getReadableDatabase();
        String query1= "Select SUM(AMOUNT) as Total from Budget_table where NAME like 'E%'";
        Cursor res1 = db.rawQuery(query1,null);
        if(res1.moveToFirst())
            sum= res1.getInt(res1.getColumnIndex("Total"));
        return sum;
    }
}
