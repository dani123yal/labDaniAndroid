package com.example.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView userText;
    private TextView passText;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = findViewById(R.id.uName);
        passText = findViewById(R.id.pass);
        btn = findViewById(R.id.btnLogin);

        passText.setEnabled(true);
        btn.setEnabled(false);


        TextWatcher userTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                passText.setEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() <= 0){
                    passText.setEnabled(false);
                }
            }
        };

        TextWatcher passTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btn.setEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() <= 0){
                    btn.setEnabled(false);
                }
            }
        };

    }

    public void checkCred(View v){

    }
}
