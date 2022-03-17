package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VH extends RecyclerView.ViewHolder {
    TextView tvName,tvPhone,tvFaculty,tvEmail;
    public VH(@NonNull View itemView) {
        super(itemView);
       tvName=itemView.findViewById(R.id.tvNames);
       tvPhone=itemView.findViewById(R.id.tvPhone);
       tvFaculty=itemView.findViewById(R.id.tvFaculty);
       tvEmail=itemView.findViewById(R.id.tvEmail);
    }
}
