package com.example.to_do_listapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity { //extends: erbt Methoden von einer bereits vorhandenen Activity

    EditText newTaskEditText;
    ImageView sendButton;
    TaskManager taskManager;
    RecyclerView recyclerView;
    DarkModeManager darkModeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        darkModeManager = new DarkModeManager(this);
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
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TaskListTouchCallback(taskManager, recyclerView));
        itemTouchHelper.attachToRecyclerView(recyclerView); //mit der Liste verbinden
    }


    private void initClickListeners() {
        sendButton.setOnClickListener(view -> onSendButtonClick());
    }


    private void onSendButtonClick() {
        String newTaskName = newTaskEditText.getText().toString(); //Eingabefeld als String speichern
        if(newTaskName.length() > 3) {
            Task task = new Task();
            task.setName(newTaskName);
            taskManager.addTask(task);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemInserted(taskManager.getTaskCount() -1);
            //Adapter muss auch wissen, dass neue Aufgabe kommt. Sie soll an der letzten Stelle hinzugefügt werden.
            newTaskEditText.getText().clear(); //Text löschen nach dem Klciken auf senden
        }else {
           Toast.makeText(MainActivity.this,"Aufgabe ist kurz!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    } // xml Datei in Java Objekt umwandeln

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.dark_mode) {
            darkModeManager.toggle();
        }
        return true;
    }
}
