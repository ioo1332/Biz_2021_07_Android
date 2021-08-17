package com.callor.movie.service;

import com.callor.movie.config.NaverAPI;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 을 사용하여 openAPI 를 조회할때
 * 필요한 연결 Session 정보를 만드는 클래스
 */
public class RetrofitClient {

    // 연결 Connection 생성
    private static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Naver API 연결 Connection을 생성하고
    // DTO Mapper를 만들어 return 하기
    public static NaverRetrofit getApiClient() {
        return getInstance().create(NaverRetrofit.class);
    }
}
