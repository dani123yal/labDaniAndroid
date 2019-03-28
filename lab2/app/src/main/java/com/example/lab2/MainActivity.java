package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void DisplayToast(View v){
        EditText txt = (EditText) findViewById(R.id.txt);
       // v = (TextView) findViewById(R.id.txt);
        int number = Integer.valueOf(txt.getText().toString());
        //int num = Integer.valueOf(((TextView) v).getText().toString());
        int ans = number * 3;
        //Log.i("myTag", Integer.toString(num));
        Toast t = Toast.makeText(getApplicationContext(), "answer is : " + ans,Toast.LENGTH_LONG);
        t.show();

        try{
            int result = number / 0;
            Log.i("run", "answer is " + result);
        }catch (Exception e){
            Log.e("error", "ERROR" );
        }

    }
    public void toast(View v){
        Toast T = Toast.makeText(getApplicationContext(),"hell",Toast.LENGTH_LONG);
        T.show();
        T.setGravity(-300 ,50,-100);


    }
}
