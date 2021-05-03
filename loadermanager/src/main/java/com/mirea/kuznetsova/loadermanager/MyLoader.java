package com.mirea.kuznetsova.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if(args != null){
            firstName = args.getString(ARG_WORD);
        }
    }

    @Nullable
    @Override
    public String loadInBackground() {
        ArrayList<String> ArrayMain = new ArrayList<>(Arrays.asList(firstName.split("(?<=\\G.)")));
        Collections.shuffle(ArrayMain);
        StringBuilder sb = new StringBuilder();
        for (String ch : ArrayMain)
            sb.append(ch);
        firstName = sb.toString();
        SystemClock.sleep(5000);
        return firstName;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
