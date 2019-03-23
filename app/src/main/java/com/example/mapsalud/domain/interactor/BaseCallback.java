package com.example.mapsalud.domain.interactor;

public interface BaseCallback {
    void onError(String error);

    void onNetworkError();

    void onTokenExpires();
}
