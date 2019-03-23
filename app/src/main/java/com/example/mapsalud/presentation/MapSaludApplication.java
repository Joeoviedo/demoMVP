package com.example.mapsalud.presentation;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.example.mapsalud.domain.executor.MainThreadExecutor;
import com.example.mapsalud.domain.executor.ThreadExecutor;
import com.example.mapsalud.domain.executor.implementations.MainThreadExecutorImp;

public class MapSaludApplication extends Application {

    public static ThreadExecutor threadExecutor;
    public static MainThreadExecutor mainThreadExecutor;
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        threadExecutor = new ThreadExecutor();
        mainThreadExecutor = new MainThreadExecutorImp();

        }

}
