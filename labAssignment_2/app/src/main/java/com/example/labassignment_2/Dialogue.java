package com.example.labassignment_2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Dialogue extends AppCompatActivity {

    myThread t1;
    myThread t2;
    Handler handler;

    TextView loadTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);

        loadTxt = findViewById(R.id.loadTxt);

    }

    @Override
    public void onResume(){
        super.onResume();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                try{
                    if(msg.what == myThread.THREAD1){
                        t1 = new myThread(myThread.THREAD1,handler);
                        new Thread(t1).start();
                    }
                    else if(msg.what == myThread.UPDATE){
                        if(msg.arg1 == myThread.THREAD1){
                            loadTxt.setText(String.valueOf(msg.arg2));
                        }
                    }
                }
                catch (Exception e){
                    Log.d("myTag",e.toString());
                }

            }
        };

        startThread();

    }

    public void startThread(){
        Message msg = new Message();
        msg.what = myThread.THREAD1;
        handler.sendMessage(msg);
    }


    @Override
    public void onDestroy(){
        String Text = MainActivity.log.getText().toString();
        MainActivity.log.setText(Text + "Loading Stopped at: " +loadTxt.getText().toString() + "\n");
        super.onDestroy();


    }
}
