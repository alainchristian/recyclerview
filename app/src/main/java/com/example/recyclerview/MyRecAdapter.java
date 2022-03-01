package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.MyViewHolder> {
    Context context;
    List<String> mList;
    LayoutInflater layoutInflater;

    public MyRecAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
        this.layoutInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        String a= mList.get(i);
        holder.tvPhone.setText(a);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPhone=itemView.findViewById(R.id.tvPhone);
        }
    }
}

