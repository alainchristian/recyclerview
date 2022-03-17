package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<String> mList = new ArrayList<>();
    MyRecAdapter myRecAdapter;
    DbHelper dbHelper;
    TextInputEditText stName,stPhone,stFaculty,stStEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecycler=findViewById(R.id.myRecycler);
        myRecAdapter=new MyRecAdapter(this,mList);
        dbHelper=new DbHelper(this);

        mList.add("Samsung");
        mList.add("iPhone");
        mList.add("Nokia");
        mList.add("Tecno");
        mList.add("Infinix");
        layoutManager= new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setAdapter(myRecAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAdd:
                //
                break;
            case R.id.mnuShow:
                //call activity containing custom recycler view
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
                break;
            case R.id.mnuAddStudent:
                saveStudent();
                break;
            case R.id.mnuViewStudent:
                displayStudent();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void displayStudent() {
        startActivity(new Intent(MainActivity.this,ShowStudent.class));
    }

    private void saveStudent() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Data Entry");
        builder.setMessage("Record properly student info");
        View view = LayoutInflater.from(this).inflate(R.layout.studentform,null);
        stName=view.findViewById(R.id.stName);
        stPhone=view.findViewById(R.id.stPhone);
        stFaculty=view.findViewById(R.id.stFacultyh);
        stStEmail=view.findViewById(R.id.stEmail);

        builder.setView(view);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //send data to the databse
                String name=stName.getText().toString();
                String phone=stPhone.getText().toString();
                String faculty = stFaculty.getText().toString();
                String email =stStEmail.getText().toString();
                if (name.isEmpty()||phone.isEmpty()||faculty.isEmpty()||email.isEmpty()){
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    stName.setError("Name is required");
                    stFaculty.setError("Faculty is required");
                    stPhone.setError("Phone is required");
                    stStEmail.setError("Email is required");
                    stName.requestFocus();
                }
                else{
                    dbHelper.addData(new Student(name,phone,faculty,email));
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //hide the dialog
            }
        });
        builder.setCancelable(false);
        builder.show();



    }
}