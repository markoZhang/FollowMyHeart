package com.example.marko.followmyheart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class MyApp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 由于是单Activity架构
         * 当前Activity退出后，整个应用就退出了，所以做垃圾回收的操作
         */
        System.gc();
        System.runFinalization();
    }
}
