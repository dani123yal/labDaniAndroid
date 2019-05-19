package com.example.lab9;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {

    private final IBinder binder=new LocalBinder();
    private final Random random=new Random();

    public class LocalBinder extends Binder
    {
        MyService getService()
        {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int calculate(int a,int b)
    {
        return a+b;
    }
}
