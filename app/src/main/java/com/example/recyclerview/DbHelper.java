package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public List<Student> getData(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from stTable",null);
        List<Student> mList=new ArrayList<>();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                String name=cursor.getString(1);
                String phone=cursor.getString(2);
                String faculty=cursor.getString(3);
                String email=cursor.getString(4);
                mList.add(new Student(name,phone,faculty,email));

            }

        }
        return mList;
    }
}
