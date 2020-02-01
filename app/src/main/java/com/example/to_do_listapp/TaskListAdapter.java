package com.example.to_do_listapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    TaskManager taskManager;


    public TaskListAdapter(TaskManager taskManager){ //übergeben von außen
        this.taskManager = taskManager; //initializieren, wie immer
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row, parent, false));
        //parent: so groß wie das Elternelement(parent)
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskManager.getTaskList().get(position); //Aufgabe anhand der Position holen
        holder.checkBox.setText(task.getName());
        holder.checkBox.setChecked(false); //die recycleten Zellen sollen nicht abgehackt sein
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChange(isChecked, task,
                holder.getLayoutPosition())); //remove Task if checked...
    }

    protected void onCheckedChange(boolean isChecked, Task task, int position){
        if(isChecked){
            taskManager.removeTask(task);
            notifyItemRemoved(position);
        }

    }

    @Override
    public int getItemCount() {
        return taskManager.getTaskCount(); //wie viele Aufgaben es insgesamt gibt
    }
}
