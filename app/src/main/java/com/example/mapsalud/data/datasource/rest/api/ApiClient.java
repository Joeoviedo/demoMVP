package com.example.mapsalud.data.datasource.rest.api;

import com.example.mapsalud.BuildConfig;
import com.example.mapsalud.data.datasource.rest.api.interfaces.IApiClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.*;



public class ApiClient {

    private static IApiClient apiClient;

    private static String SERVER="https://reqres.in/";


    public static IApiClient getApiClient() {
        if (apiClient == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER)
                    .client(ApiClient.okClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiClient = retrofit.create(IApiClient.class);
        }
        return apiClient;
    }



    private static OkHttpClient okClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel((BuildConfig.DEBUG) ? BODY : NONE);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
    }
}
