package com.example.to_do_listapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class DarkModeManager {

    final static int DAY = AppCompatDelegate.MODE_NIGHT_NO; //vorhandene Konstante. 1 geht acuh.
    final static int NIGHT = AppCompatDelegate.MODE_NIGHT_YES;

    public SharedPreferences sharedPreferences;

    public DarkModeManager(Context context){
        sharedPreferences = context.getSharedPreferences("Dark Mode", Context.MODE_PRIVATE); //nur die App kann es lesen und ändern
        int lastMode = getMode();
        setMode(lastMode); //Zum Wiederherstellen des letztgewählten Modus
        //setMode(getMode()); tut genau das Selbe, ist nur kürzer statt die obigen 2 Zeilen.
    }

    public void setMode(int mode){
        AppCompatDelegate.setDefaultNightMode(mode); //manuell an bzw. aus
        sharedPreferences.edit().putInt("mode", mode).apply();
    }

    public int getMode(){
        return sharedPreferences.getInt("mode", DAY); //standard ist DAY beim ersten Start
    }

    public void toggle(){
        setMode(getMode()== DAY ? NIGHT : DAY); //wenn Tagmodus: wähle Night. Wenn nicht: wähle Tag
    }


}
