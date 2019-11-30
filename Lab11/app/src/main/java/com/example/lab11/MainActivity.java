package com.example.lab11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void broadcastIntent(View view)
    {
        Intent i= new Intent();
        i.setAction("lab10");
        //i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        i.putExtra("message","hello");
        //sendOrderedBroadcast(i,null);
        sendOrderedBroadcast(i, null);
    }
}
