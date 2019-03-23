package com.example.mapsalud.data.datasource.rest.api.interfaces;

import com.example.mapsalud.data.model.response.GetUsersPageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiClient {

    @GET("/api/users")
    Call<GetUsersPageResponse> getUserPage(@Query("page") int pagina);

}
