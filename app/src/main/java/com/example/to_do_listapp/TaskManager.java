package com.example.to_do_listapp;

import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> taskList;

    public void addTask(Task task){ //Task wird an den Manager übergeben
        taskList.add(task);
    }

    public void removeTask(Task task){ //zum Löschen von Aufgaben
        taskList.remove(task);
    }

    public ArrayList<Task> getTaskList(){ //Liste von Aufgaben
        return taskList;
    }

    public int getTaskCount(){ //Anzahl der Aufgaben
        return taskList.size(); //Anzahl der Elemnte in der Liste zurückgeben
    }

}
