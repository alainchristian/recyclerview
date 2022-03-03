package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDeatails extends AppCompatActivity {
    ImageView imageView;
    TextView name,price,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_deatails);
        imageView=findViewById(R.id.itemImageD);
        name=findViewById(R.id.itemNameD);
        price=findViewById(R.id.itemPriceD);
        description=findViewById(R.id.itemDescrD);

        Intent intent =getIntent();
        imageView.setImageResource(intent.getIntExtra("image",0));
        name.setText(intent.getStringExtra("itemName"));
        price.setText(""+intent.getFloatExtra("itemPrice",0));
        description.setText(intent.getStringExtra("itemDescr"));



    }
}