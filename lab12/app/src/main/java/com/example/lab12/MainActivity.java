package com.example.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    TextView textView;

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.result_text_view);

        loadData();
        updateViews();
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
        finally {
            saveData();
        }

        Toast t = Toast.makeText(this,"this is text",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        t.show();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews() {
        textView.setText(text);
    }
}
