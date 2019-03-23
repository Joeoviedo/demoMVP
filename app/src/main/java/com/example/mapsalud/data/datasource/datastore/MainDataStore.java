package com.example.mapsalud.data.datasource.datastore;

import com.example.mapsalud.data.exception.MainException;
import com.example.mapsalud.data.exception.TokenException;
import com.example.mapsalud.data.model.response.GetUsersPageResponse;

import java.io.IOException;

public interface MainDataStore {
    GetUsersPageResponse getUsers(String pagina) throws MainException, IOException, TokenException;
}
