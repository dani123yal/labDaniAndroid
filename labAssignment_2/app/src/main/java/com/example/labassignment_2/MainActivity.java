package com.example.labassignment_2;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TextView log;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        log = findViewById(R.id.txtView);
        log.setMovementMethod(new ScrollingMovementMethod());

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(),Dialogue.class);
        startActivity(i);
    }
}
