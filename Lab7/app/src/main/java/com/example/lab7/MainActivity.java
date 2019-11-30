package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void askQuestion(View view)
    {
        Intent i =new Intent(getApplicationContext(),AskActivity.class);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode== Activity.RESULT_OK)
        {
            MyClass obj=(MyClass)data.getSerializableExtra("message");
            TextView message=findViewById(R.id.message);
            Log.d("mytag",obj.message);
            message.setText(obj.message);
        }
    }


}
