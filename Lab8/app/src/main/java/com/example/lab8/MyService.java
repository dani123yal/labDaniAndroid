package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mytag","onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d("mytag","onStartCommand()");
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("onbind","onBind()");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("mytag","onDestroy");
    }
}
