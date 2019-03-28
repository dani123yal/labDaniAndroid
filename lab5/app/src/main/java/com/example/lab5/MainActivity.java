package com.example.lab5;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
    }

    public void applyToast(View v){
        Toast t = Toast.makeText(this,"this is text",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        t.show();
    }

    public void buttonClear(View v){
        TextView text = (TextView)findViewById(R.id.result_text_view);

        text.setText("0");
    }

    public void addValueInView(View v){
        Button btn = (Button) v;
        String text = btn.getText().toString();

        TextView view = (TextView)findViewById(R.id.result_text_view);
        if(view.getText().toString().equals("0")){
            view.setText("");
            view.append(text);
        }
        else{
            view.append(text);
        }
    }

    public void buttonDivide(View v){
        v = (TextView)findViewById(R.id.result_text_view);

        ((TextView)v).append("/");



    }

    public void buttonMultiply(View v){
        v = (TextView)findViewById(R.id.result_text_view);

        ((TextView)v).append("*");
    }

    public void buttonSubtract(View v){
        v = (TextView)findViewById(R.id.result_text_view);

        ((TextView)v).append("-");
    }

    public void buttonAdd(View v){
        v = (TextView)findViewById(R.id.result_text_view);

        ((TextView)v).append("+");
    }

    public void buttonEqual(View v){
        v = (TextView)findViewById(R.id.result_text_view);
        try {
            if (((TextView) v).getText().toString().contains("/")) {
                int index = ((TextView) v).getText().toString().indexOf('/');

                String stringNum1 = ((TextView) v).getText().toString().substring(0, index);
                String stringNum2 = ((TextView) v).getText().toString().substring(index+1);

                double num1 = Double.valueOf(stringNum1);
                double num2 = Double.valueOf(stringNum2);

                double ans = num1 / num2;

                ((TextView) v).setText(String.valueOf(ans));
            }
            else if (((TextView) v).getText().toString().contains("+")) {
                int index = ((TextView) v).getText().toString().indexOf('+');

                String stringNum1 = ((TextView) v).getText().toString().substring(0, index);
                String stringNum2 = ((TextView) v).getText().toString().substring(index+1);

                double num1 = Double.valueOf(stringNum1);
                double num2 = Double.valueOf(stringNum2);

                double ans = num1 + num2;

                ((TextView) v).setText(String.valueOf(ans));
            }
            else if (((TextView) v).getText().toString().contains("*")) {
                int index = ((TextView) v).getText().toString().indexOf('*');

                String stringNum1 = ((TextView) v).getText().toString().substring(0, index);
                String stringNum2 = ((TextView) v).getText().toString().substring(index+1);

                double num1 = Double.valueOf(stringNum1);
                double num2 = Double.valueOf(stringNum2);

                double ans = num1*num2;

                ((TextView) v).setText(String.valueOf(ans));
            }
            else if (((TextView) v).getText().toString().contains("-")) {
                int index = ((TextView) v).getText().toString().indexOf('-');

                String stringNum1 = ((TextView) v).getText().toString().substring(0, index);
                String stringNum2 = ((TextView) v).getText().toString().substring(index+1);

                double num1 = Double.valueOf(stringNum1);
                double num2 = Double.valueOf(stringNum2);

                double ans = num1-num2;

                ((TextView) v).setText(String.valueOf(ans));
            }
        }catch (Exception e){
            Log.e("error","Exception: "+e);
        }

        Toast t = Toast.makeText(this,"this is text",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        t.show();
    }

}
