package com.example.mapsalud.presentation.main.presenter;

import com.example.mapsalud.presentation.BasePresenter;
import com.example.mapsalud.presentation.main.view.interfaces.IMainView;

public interface MainPresenter  extends BasePresenter<IMainView> {
    void validateFields(String page);

    void onGetUserPage(String page);
}
