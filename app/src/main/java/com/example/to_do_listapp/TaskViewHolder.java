package com.example.to_do_listapp;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;

    public TaskViewHolder(@NonNull View itemView) { //die recyclte View bekommt man übergeben,
        super(itemView);                            //damit man die wieder verwenden kann.
        checkBox = itemView.findViewById(R.id.checkbox);
    }
}
