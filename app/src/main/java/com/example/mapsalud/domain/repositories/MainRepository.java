package com.example.mapsalud.domain.repositories;

import com.example.mapsalud.data.exception.MainException;
import com.example.mapsalud.data.exception.TokenException;
import com.example.mapsalud.domain.model.GetUsersPage;

import java.io.IOException;

public interface MainRepository {
    GetUsersPage getUsers(String mPagina)throws MainException, IOException, TokenException;
}
