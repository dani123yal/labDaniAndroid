package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
    }

    public void yes(View view)
    {
        MyClass obj=new MyClass();
        Intent i = getIntent();
        EditText name=findViewById(R.id.name);
        obj.message=name.getText().toString();
        i.putExtra("message",obj);
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}
