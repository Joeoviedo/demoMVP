package com.example.mapsalud.data.datasource.factory;

import com.example.mapsalud.data.datasource.DataStoreEnum;
import com.example.mapsalud.data.datasource.account.MainAccountDataStore;
import com.example.mapsalud.data.datasource.datastore.MainDataStore;
import com.example.mapsalud.data.datasource.preferences.MainPreferencesDataStore;
import com.example.mapsalud.data.datasource.rest.MainRestDataStore;

public class MainDataStoreFactory {

    public MainDataStore create(DataStoreEnum dataStoreEnum) {
        MainDataStore maintDataStore = null;
        switch (dataStoreEnum) {
            case REST:
                maintDataStore = new MainRestDataStore();
                break;
            case DB:
                break;
            case PREFERENCES:
               // maintDataStore = new MainPreferencesDataStore();
                break;
            case ACCOUNT:
               // maintDataStore = new MainAccountDataStore();
                break;
        }
        return maintDataStore;
    }
}
