package com.example.mapsalud.domain.interactor;

import com.example.mapsalud.domain.executor.Interactor;
import com.example.mapsalud.domain.executor.InteractorExecutor;
import com.example.mapsalud.domain.executor.MainThreadExecutor;
import com.example.mapsalud.presentation.MapSaludApplication;

public abstract class AbstractInteractor implements Interactor {

    private InteractorExecutor interactorExecutor;
    private MainThreadExecutor mainThreadExecutor;

    public AbstractInteractor() {
        interactorExecutor = MapSaludApplication.threadExecutor;
        mainThreadExecutor = MapSaludApplication.mainThreadExecutor;
    }

    public InteractorExecutor getInteractorExecutor() {
        return interactorExecutor;
    }

    public void setInteractorExecutor(InteractorExecutor interactorExecutor) {
        this.interactorExecutor = interactorExecutor;
    }

    public MainThreadExecutor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    public void setMainThreadExecutor(MainThreadExecutor mainThreadExecutor) {
        this.mainThreadExecutor = mainThreadExecutor;
    }

}
