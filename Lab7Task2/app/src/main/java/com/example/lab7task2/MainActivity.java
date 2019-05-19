package com.example.lab7task2;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton hours_radio;
    RadioButton minutes_radio;
    RadioButton seconds_radio;
    TextView H;
    TextView M;
    TextView S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hours_radio=findViewById(R.id.hours_radio);
        minutes_radio=findViewById(R.id.minutes_radio);
        seconds_radio=findViewById(R.id.seconds_radio);
        H=findViewById(R.id.hours);
        M=findViewById(R.id.minutes);
        S=findViewById(R.id.seconds);
    }

    public void updateTime(View view)
    {
        Intent i=new Intent(getApplicationContext(),UpdateActivity.class);
        if(hours_radio.isChecked()) {
            i.putExtra("request", "1");
            startActivityForResult(i, 1);
        }
        else if(minutes_radio.isChecked())
        {
            i.putExtra("request","2");
            startActivityForResult(i, 2);
        }
        else if(seconds_radio.isChecked())
        {
            i.putExtra("request","3");
            startActivityForResult(i,3);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                Update hours=(Update)data.getSerializableExtra("hours");
                H.setText(hours.hours);
            }
        }

        else if(requestCode==2)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                Update minutes=(Update)data.getSerializableExtra("minutes");
                M.setText(minutes.minutes);
            }
        }

        else if(requestCode==3)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                Update seconds=(Update)data.getSerializableExtra("seconds");
                S.setText(seconds.seconds);
            }
        }
    }
}
