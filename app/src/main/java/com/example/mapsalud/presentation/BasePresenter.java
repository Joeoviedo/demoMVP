package com.example.mapsalud.presentation;

public interface BasePresenter<T> {
    void onAttach(T view);
    void onDetach();
}
