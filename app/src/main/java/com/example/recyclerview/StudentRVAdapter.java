package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRVAdapter extends RecyclerView.Adapter<VH> {
    List<Student> mList;

    public StudentRVAdapter(List<Student> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentrow,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Student student = mList.get(position);
        holder.tvName.setText(student.getStName());
        holder.tvPhone.setText(student.getStPhone());
        holder.tvEmail.setText(student.getStEmail());
        holder.tvFaculty.setText(student.getStFaculty());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
