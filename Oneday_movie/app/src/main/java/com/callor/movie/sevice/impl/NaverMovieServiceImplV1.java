package com.callor.movie.sevice.impl;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.adapter.MovieViewAdapter;
import com.callor.movie.config.NaverAPI;
import com.callor.movie.model.NaverMovieDTO;
import com.callor.movie.model.NaverParent;
import com.callor.movie.sevice.NaverMovieService;
import com.callor.movie.sevice.RetrofitAIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NaverMovieServiceImplV1 implements NaverMovieService {

    protected RecyclerView recyclerView;

    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public NaverMovieDTO getMovie(String search) {

        Call<NaverParent> retrofitReturn = RetrofitAIClient.getApiClient().getMovie(
                NaverAPI.CLIENT_ID, NaverAPI.CLIENT_SECRET, search, 1, 10
        );

        retrofitReturn.enqueue(new Callback<NaverParent>() {

            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                int resCode=response.code();
                if (resCode<300){
                    NaverParent naverParent=response.body();
                    List<NaverMovieDTO> movieList=naverParent.items;
                    MovieViewAdapter movieViewAdapter=new MovieViewAdapter(movieList);
                    recyclerView.setAdapter(movieViewAdapter);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                }else {

                }

            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });
        return null;
    }
}
