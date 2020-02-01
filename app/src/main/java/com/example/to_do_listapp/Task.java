package com.example.to_do_listapp;

public class Task {

    String name;

    public void setName(String name){ //public damit ich das von außerhalb der Klasse aufrufen kann.
        this.name = name; //hier wird nichts zurückgegeben
    }

    public String getName(){
        return name; //hier will ich etwas zurückgeben, deshalb oben String, sonst Fehlermeldung
    }

}
