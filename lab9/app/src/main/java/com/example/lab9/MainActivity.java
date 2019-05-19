package com.example.lab9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService myservice;
    boolean bound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Intent i=new Intent(getApplicationContext(),MyService.class);
        bindService(i,connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if(bound)
        {
            unbindService(connection);
            bound=false;
        }
    }

    private ServiceConnection connection=new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder binder=(MyService.LocalBinder) service;
            myservice=binder.getService();
            bound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound=false;
        }
    };

    public void calculate(View view)
    {
        if(bound)
        {
            EditText a=findViewById(R.id.a);
            EditText b=findViewById(R.id.b);
            TextView ans=findViewById(R.id.answer);
            int aa=Integer.parseInt(a.getText().toString());
            int bb=Integer.parseInt(b.getText().toString());
            int num=myservice.calculate(aa,bb);
            ans.setText(num);
            Toast.makeText(this,num,Toast.LENGTH_LONG).show();
        }
    }
}
