package com.mirea.kuznetsova.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyLooper myLooper;
    EditText age, prof;
    String msg1, msg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
        age = (EditText) findViewById(R.id.age);
        prof = (EditText) findViewById(R.id.prof);
    }
    public void onClick(View view){
        Message msg = new Message();
        Bundle bundle = new Bundle();
        msg1 = String.valueOf(age.getText());
        msg2 = String.valueOf(prof.getText());
        bundle.putString("AGE", msg1);
        bundle.putString("KEY", msg2);
        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}