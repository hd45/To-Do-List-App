package com.example.to_do_listapp;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> taskList;

    public TaskManager(Context context){ //von außen ein Context rein, dann THIS in MainActivity
        Hawk.init(context).build(); //initialize
        loadTaskList();
    }

    public void addTask(Task task){ //Task wird an den Manager übergeben
        taskList.add(task);
        saveTaskList();
    }

    public void removeTask(Task task){ //zum Löschen von Aufgaben
        taskList.remove(task);
        saveTaskList();
    }

    public ArrayList<Task> getTaskList(){ //Liste von Aufgaben
        return taskList;
    }

    public int getTaskCount(){ //Anzahl der Aufgaben
        return taskList.size(); //Anzahl der Elemnte in der Liste zurückgeben
    }

    protected void saveTaskList(){
        Hawk.put("taskList", taskList); //Tasks werden mithilfe von hawk gespeichert
    }

    protected void loadTaskList(){
        taskList = Hawk.get("taskList", new ArrayList<>());
        //neue Liste erstellen. Beim ersten Start gibt es keine Aufgaben, demzufolge Nullexception Fehler (kein Objekt oder Objekt 0)
    }
}
