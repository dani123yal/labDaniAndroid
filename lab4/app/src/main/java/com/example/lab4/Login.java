package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View v){
        TextView user = (TextView) findViewById(R.id.euser);
        TextView pass = (TextView) findViewById(R.id.epass);
        String u = user.getText().toString();
        String p = pass.getText().toString();
        if(u.equalsIgnoreCase("Aishah")&&p.equalsIgnoreCase("Daniyal")){
            Toast.makeText(getApplicationContext(),"Wow",Toast.LENGTH_SHORT).show();
        }}
}
