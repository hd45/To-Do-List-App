package com.example.to_do_listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //extends: erbt Methoden von einer bereits vorhandenen Activity

    EditText newTaskEditText;
    ImageView sendButton;
    TaskManager taskManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskManager = new TaskManager(this); //this context
        initViews(); //views anbinden
        initClickListeners();
    }


    private void initViews() {
        newTaskEditText = findViewById(R.id.new_task);
        sendButton = findViewById(R.id.send_button);
        recyclerView = findViewById(R.id.task_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //default vom Context ist vertikal
        recyclerView.setAdapter(new TaskListAdapter(taskManager));
    }

    private void initClickListeners() {
        sendButton.setOnClickListener(view -> onSendButtonClick());
    }

    private void onSendButtonClick() {
        String newTaskName = newTaskEditText.getText().toString(); //Eingabefeld als String speichern
        if(newTaskName.length() > 0) {
            Task task = new Task();
            task.setName(newTaskName);
            taskManager.addTask(task);
            recyclerView.getAdapter().notifyItemInserted(taskManager.getTaskCount() -1);
            //Adapter muss auch wissen, dass neue Aufgabe kommt. Sie soll an der letzten Stelle hinzugefügt werden.
            newTaskEditText.getText().clear(); //Text löschen nach dem Klciken auf senden
        }//else {
           // Toast.makeText("leere Aufgabe!"); todo hier ein Toast leere Aufgabe
       // }
    }

}
