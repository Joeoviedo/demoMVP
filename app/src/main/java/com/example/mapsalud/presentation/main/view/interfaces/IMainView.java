package com.example.mapsalud.presentation.main.view.interfaces;

import com.example.mapsalud.presentation.BaseView;
import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;

public interface IMainView extends BaseView {
    void onValidateFields(String page);
    void onGetUsersPage(GetUsersPageVM getUsersPageVM);
}
