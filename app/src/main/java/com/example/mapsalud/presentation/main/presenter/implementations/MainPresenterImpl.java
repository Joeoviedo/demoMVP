package com.example.mapsalud.presentation.main.presenter.implementations;

import android.content.Context;

import com.example.mapsalud.R;
import com.example.mapsalud.domain.interactor.MainInteractor;
import com.example.mapsalud.domain.interactor.implementations.MainInteractorImpl;
import com.example.mapsalud.presentation.main.presenter.MainPresenter;
import com.example.mapsalud.presentation.main.view.interfaces.IMainView;
import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;

public class MainPresenterImpl implements MainPresenter {
    private Context mContext;
    private IMainView mIMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(Context context) {
        mContext = context;
        mMainInteractor = new MainInteractorImpl();
    }

    @Override
    public void validateFields(String page) {
        mIMainView.onLoader(true);
        if (page == null || page.trim().isEmpty()) {
            mIMainView.onLoader(false);
            mIMainView.onError(mContext.getString(R.string.error_main_nombre_empty_text));
            return;
        }

        mIMainView.onValidateFields(page);
    }

    @Override
    public void onGetUserPage(String page) {
        mMainInteractor.execute(new MainInteractor.Callback() {
            @Override
            public void onGetUsers(GetUsersPageVM getUsersPageVM) {
                if (mIMainView == null)
                    return;
                mIMainView.onLoader(false);
                mIMainView.onGetUsersPage(getUsersPageVM);
            }

            @Override
            public void onError(String error) {
                if (mIMainView == null)
                    return;
                mIMainView.onLoader(false);
                mIMainView.onError(error);
            }

            @Override
            public void onNetworkError() {
                if (mIMainView == null)
                    return;
                mIMainView.onLoader(false);
                mIMainView.onNetworkError();
            }

            @Override
            public void onTokenExpires() {
                if (mIMainView == null)
                    return;
            }
        },page);
    }

    @Override
    public void onAttach(IMainView view) {
        this.mIMainView = view;

    }

    @Override
    public void onDetach() {
        this.mIMainView = null;
    }
}
