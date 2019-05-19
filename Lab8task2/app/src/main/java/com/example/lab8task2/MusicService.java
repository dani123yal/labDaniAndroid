package com.example.lab8task2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MusicService extends Service {
MediaPlayer media;
Ringtone r;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mytag","on create");
        Uri ringtone= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        media=MediaPlayer.create(this, ringtone);
//        r = RingtoneManager.getRingtone(getApplicationContext(), ringtone);
//        r.play();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("mytag","onStartCommand()");
        if(!r.isPlaying())
        {
            media.start();
        }
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(r.isPlaying())
        {
            media.stop();
        }
//        r.release();
    }
}
