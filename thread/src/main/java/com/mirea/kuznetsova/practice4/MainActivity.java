package com.mirea.kuznetsova.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText days, lessons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        days = (EditText) findViewById(R.id.days);
        lessons = (EditText) findViewById(R.id.lessons);
    }
    public void onClick(View view) {
        Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                long endTime = System.currentTimeMillis() + 20 * 500;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        }
                        catch (Exception ignored) {
                        }
                    }
                }
                if (Integer.parseInt(String.valueOf(days.getText())) > 0 & Integer.parseInt(String.valueOf(days.getText())) != 0){
                    int less_in_day = (Integer.parseInt(String.valueOf(lessons.getText())))/Integer.parseInt(String.valueOf(days.getText()));
                    textView.setText(Integer.toString(less_in_day));
                }else{
                    textView.setText("Ошибка");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}