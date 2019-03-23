package com.example.mapsalud.domain.interactor;

import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;

public interface MainInteractor {
    void execute(Callback callback, String pagina);

    interface Callback extends BaseCallback {
        void onGetUsers(GetUsersPageVM getUsersPageVM);
    }
}
