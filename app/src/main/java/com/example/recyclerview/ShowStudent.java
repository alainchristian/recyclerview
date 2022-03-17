package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ShowStudent extends AppCompatActivity {
    RecyclerView studentRV;
    List<Student> mList;
    DbHelper dbHelper;
    StudentRVAdapter studentRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);
        studentRV=findViewById(R.id.studentRV);
        studentRV.setLayoutManager(new LinearLayoutManager(this));
        dbHelper=new DbHelper(this);
        mList =dbHelper.getData();
        studentRVAdapter=new StudentRVAdapter(mList);
        studentRV.setAdapter(studentRVAdapter);

    }
}