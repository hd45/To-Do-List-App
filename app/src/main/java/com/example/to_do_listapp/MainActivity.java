package com.example.to_do_listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText newTaskEditText;
    ImageView sendButton;
    TaskManager taskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskManager = new TaskManager();
        initViews(); //views anbinden
        initClickListeners();
    }


    private void initViews() {
        newTaskEditText = findViewById(R.id.new_task);
        sendButton = findViewById(R.id.send_button);

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
            newTaskEditText.getText().clear(); //Text löschen nach dem Klciken auf senden
        }//else {
           // Toast.makeText("leere Aufgabe!"); todo hier ein Toast leere Aufgabe
       // }
    }

}
