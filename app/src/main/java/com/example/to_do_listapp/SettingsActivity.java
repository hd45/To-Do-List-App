package com.example.to_do_listapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    SwitchCompat switch1;
    DarkModeManager darkModeManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("Settings");
        switch1 = findViewById(R.id.switch1);

        SharedPreferences preferences = getSharedPreferences("save", MODE_PRIVATE);


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);



                }else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }


        });
    }

}
