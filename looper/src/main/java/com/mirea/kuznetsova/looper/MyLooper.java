package com.mirea.kuznetsova.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread{
    private int number = 0;
    int time = 0;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();

        Log.i("ThreadProject", "Выполнен поток No ");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(number == 0){
                    time = Integer.parseInt(String.valueOf(msg.getData().getString("AGE")));
                }
                long endTime = System.currentTimeMillis() + 20 * time;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this)
                    {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        }
                        catch (Exception ignored) {
                        }
                    }
                }
                Log.d("Work: ", msg.getData().getString("KEY"));
                Log.d("Age: ", msg.getData().getString("AGE"));
                number++;
            }
        };
        Looper.loop();
    }
}
