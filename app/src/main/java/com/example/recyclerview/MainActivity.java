package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<String> mList = new ArrayList<>();
    MyRecAdapter myRecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecycler=findViewById(R.id.myRecycler);
        myRecAdapter=new MyRecAdapter(this,mList);

        mList.add("Samsung");
        mList.add("iPhone");
        mList.add("Nokia");
        mList.add("Tecno");
        mList.add("Infinix");
        layoutManager= new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setAdapter(myRecAdapter);
    }
}