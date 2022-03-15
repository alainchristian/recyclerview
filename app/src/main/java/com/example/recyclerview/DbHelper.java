package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    Context context;
    public DbHelper(@Nullable Context context) {
        super(context, "studentDB.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table stTable(stId INTEGER PRIMARY KEY AUTOINCREMENT ,stName TEXT,stPhone TEXT,stFaculty TEXT,stEmail TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists stTable");
    }
    public void addData(Student student){
        SQLiteDatabase myDB= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stName",student.getStName());
        values.put("stPhone",student.getStPhone());
        values.put("stFaculty",student.getStFaculty());
        values.put("stEmail",student.getStEmail());
        long l= myDB.insert("stTable",null,values);
        if (l==-1){
            Toast.makeText(context, "Data entry failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Data entry successful", Toast.LENGTH_SHORT).show();
        }
    }
}
