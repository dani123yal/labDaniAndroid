package com.example.lab8task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=new Intent(getApplicationContext(),MusicService.class);
    }

    public void startMusic(View view)
    {
        startService(i);
    }

    public void stopMusic(View view)
    {
        stopService(i);
    }
}
