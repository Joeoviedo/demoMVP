package com.example.mapsalud.domain.interactor.implementations;

import android.util.Log;

import com.example.mapsalud.data.exception.MainException;
import com.example.mapsalud.data.exception.TokenException;
import com.example.mapsalud.data.repositories.MainRepositoryImpl;
import com.example.mapsalud.domain.interactor.AbstractInteractor;
import com.example.mapsalud.domain.interactor.MainInteractor;
import com.example.mapsalud.domain.model.mapper.UserPageMapper;
import com.example.mapsalud.domain.repositories.MainRepository;
import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;

import java.io.IOException;

public class MainInteractorImpl extends AbstractInteractor implements MainInteractor {

    private Callback mCallback;
    private String mPagina;
    private MainRepository mMainRepository;
    private UserPageMapper mUserPageMapper;


    public MainInteractorImpl() {
        this.mMainRepository = new MainRepositoryImpl();
        this.mUserPageMapper = new UserPageMapper();
    }


    @Override
    public void execute(Callback callback, String pagina) {
        mCallback = callback;
        mPagina=pagina;
        getInteractorExecutor().run(MainInteractorImpl.this);

    }

    @Override
    public void run() {
        try {
            Log.d("MainInteractorImpl","run ");

            final GetUsersPageVM getUsersPageVM = mUserPageMapper.convertGetUsersPageToGetUsersPageVM(mMainRepository.getUsers(mPagina));
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    mCallback.onGetUsers(getUsersPageVM);
                }
            });
        } catch (final MainException ex) {
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    mCallback.onError(ex.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    mCallback.onNetworkError();
                }
            });
        } catch (TokenException e) {
            e.printStackTrace();
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    mCallback.onTokenExpires();
                }
            });
        }
    }
}
