package com.callor.movie.sevice;

import com.callor.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAIClient {

    public static NaverRetrofit getApiClient(){
        NaverRetrofit naverRetrofit=getConnection().create(NaverRetrofit.class);
        return naverRetrofit;
    }
    private static Retrofit getConnection(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(NaverAPI.CLIENT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
