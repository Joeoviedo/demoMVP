package com.example.mapsalud.domain.executor.implementations;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsalud.domain.executor.MainThreadExecutor;

public class MainThreadExecutorImp implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
