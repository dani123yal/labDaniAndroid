package com.example.labassignment_2;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class myThread implements Runnable {

    public static final int THREAD1= 100;
    public static final int UPDATE = 103;

    public static int argument = 0;

    private static  final String TAG = "myThread";
    Handler myHandler;
    public int count = 0;

    public myThread(int arg, Handler handler){
        this.argument = arg;
        myHandler = handler;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            count++;
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
            Log.d(TAG,argument + ": " +String.valueOf(i));
            Message message = new Message();
            message.arg1 = argument;
            message.what = UPDATE;
            message.arg2 = i;
            myHandler.sendMessage(message);
        }
    }
}
