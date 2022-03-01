package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView customRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<Item> itemList;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        customRecycler = findViewById(R.id.CustRecycler);
        layoutManager = new LinearLayoutManager(this);
        customRecycler.setLayoutManager(layoutManager);
        itemList=new ArrayList<>();
        itemList=fillTheList();
        myCustomAdapter=new MyCustomAdapter(this,itemList);
        customRecycler.setAdapter(myCustomAdapter);
    }

    private List<Item> fillTheList() {
        List<Item> itemList =new ArrayList<>();
        itemList.add(new Item(R.drawable.apple,"Apple",300,"we have red apple and green apple from South Africa and all around the world"));
        itemList.add(new Item(R.drawable.banana,"Banana",100,"This is the description for banana"));
        itemList.add(new Item(R.drawable.grape,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.strawberry,"",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.watermelon,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.mango,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.orange,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.pear,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.cherry,"Grape",200,"This is the description for Grape"));
        itemList.add(new Item(R.drawable.banana,"Grape",200,"This is the description for Grape"));


        return itemList;

    }
}