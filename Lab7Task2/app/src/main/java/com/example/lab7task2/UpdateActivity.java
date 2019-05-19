package com.example.lab7task2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText updated_value;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updated_value=findViewById(R.id.updated_value);
        i=getIntent();
    }

    public void update(View view) {

        Update obj=new Update();
//        String request=i.getStringExtra("request_code_1");
//        Toast.makeText(getApplicationContext(),request,Toast.LENGTH_LONG).show();
//        Log.i("mytag",i.getStringExtra("request_code_1"));
        if(i.getStringExtra("request").equals("1"))
        {
            obj.hours=updated_value.getText().toString();
            i.putExtra("hours",obj);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
        else if(i.getStringExtra("request").equals("2"))
        {
            obj.minutes=updated_value.getText().toString();
            i.putExtra("minutes",obj);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
        else if(i.getStringExtra("request").equals("3"))
        {
            obj.seconds=updated_value.getText().toString();
            i.putExtra("seconds",obj);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
    }
}
