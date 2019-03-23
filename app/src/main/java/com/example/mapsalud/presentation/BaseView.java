package com.example.mapsalud.presentation;

public interface BaseView {
    void onError(String error);
    void onNetworkError();
    void onTokenExpires();
    void onLoader(boolean show);
}
