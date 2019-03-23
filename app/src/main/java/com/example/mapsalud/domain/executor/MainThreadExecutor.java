package com.example.mapsalud.domain.executor;

public interface MainThreadExecutor {
    void execute(Runnable runnable);

}
