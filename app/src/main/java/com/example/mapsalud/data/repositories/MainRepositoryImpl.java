package com.example.mapsalud.data.repositories;

import android.util.Log;

import com.example.mapsalud.data.datasource.DataStoreEnum;
import com.example.mapsalud.data.datasource.datastore.MainDataStore;
import com.example.mapsalud.data.datasource.factory.MainDataStoreFactory;
import com.example.mapsalud.data.exception.MainException;
import com.example.mapsalud.data.exception.TokenException;
import com.example.mapsalud.data.model.maper.UserPageDataMapper;
import com.example.mapsalud.domain.model.GetUsersPage;
import com.example.mapsalud.domain.repositories.MainRepository;

import java.io.IOException;

public class MainRepositoryImpl  implements MainRepository {

    private final MainDataStoreFactory mMainDataStoreFactory;
    private final UserPageDataMapper mUserPageDataMapper;


    public MainRepositoryImpl() {
        this.mMainDataStoreFactory = new MainDataStoreFactory();
        this.mUserPageDataMapper = new UserPageDataMapper();

    }

    @Override
    public GetUsersPage getUsers(String pagina) throws MainException, IOException, TokenException {
        Log.d("MainRepositoryImpl","MainRepositoryImpl ");

        MainDataStore mainDataStore = mMainDataStoreFactory.create(DataStoreEnum.REST);
       return mUserPageDataMapper.convertGetUsersPageResponseToGetUsersPage(mainDataStore.getUsers(pagina));

    }
}
