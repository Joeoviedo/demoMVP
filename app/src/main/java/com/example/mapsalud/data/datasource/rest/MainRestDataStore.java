package com.example.mapsalud.data.datasource.rest;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.mapsalud.R;
import com.example.mapsalud.data.datasource.datastore.MainDataStore;
import com.example.mapsalud.data.datasource.rest.api.ApiClient;
import com.example.mapsalud.data.exception.MainException;
import com.example.mapsalud.data.exception.TokenException;
import com.example.mapsalud.data.model.response.GetUsersPageResponse;
import com.example.mapsalud.presentation.MapSaludApplication;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit2.Response;

public class MainRestDataStore implements MainDataStore {
    @Override
    public GetUsersPageResponse getUsers(String page) throws MainException, IOException, TokenException {
        try {
            int pagina = Integer.parseInt(page);
            Response<GetUsersPageResponse> response = ApiClient.getApiClient().getUserPage(pagina).execute();
            Log.e("MainRestDataStore","getUsers "+ response.code());
            Log.e("MainRestDataStore","getUsers "+ response.message());
            Log.e("MainRestDataStore","getUsers "+ response.headers());
            Log.e("MainRestDataStore","getUsers "+ response.body());
            Log.e("MainRestDataStore","getUsers "+ response.isSuccessful());
            Log.e("MainRestDataStore","getUsers ");
            switch (response.code()) {
                case HttpURLConnection.HTTP_OK:
                    return response.body();
                case HttpURLConnection.HTTP_BAD_REQUEST:
                    throw new MainException(MapSaludApplication.context.getString(R.string.error_main_generic));
                case HttpURLConnection.HTTP_INTERNAL_ERROR:
                    throw new MainException(MapSaludApplication.context.getString(R.string.error_internalserver));
                default:
                    throw new MainException(MapSaludApplication.context.getString(R.string.error_main_generic));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
