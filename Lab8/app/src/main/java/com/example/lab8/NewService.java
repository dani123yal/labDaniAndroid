package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NewService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
