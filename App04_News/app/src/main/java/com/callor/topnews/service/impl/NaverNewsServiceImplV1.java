package com.callor.topnews.service.impl;

import android.util.Log;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.topnews.adapter.NewsViewAdpater;
import com.callor.topnews.config.NaverAPI;
import com.callor.topnews.model.NaverNewsDTO;
import com.callor.topnews.model.NaverParent;
import com.callor.topnews.service.NaverRetroFit;
import com.callor.topnews.service.NaverRetrofitClient;
import com.callor.topnews.service.NaverService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverNewsServiceImplV1 implements NaverService {

    protected RecyclerView newsListView;

    public NaverNewsServiceImplV1(RecyclerView newsListView) {
        this.newsListView=newsListView;
    }

    @Override
    public void getNews(String search) {

        Call<NaverParent> naverCall=NaverRetrofitClient.getApiClient()
                .getNews(NaverAPI.CLIENT_ID
                        ,NaverAPI.CLIENT_SECRET
                        ,search,1,20);

        naverCall.enqueue(new Callback<NaverParent>() {

            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                int resCode=response.code();
                if(resCode<300){
                    Log.d("네이버 뉴스 조회",response.body().toString());

                    List<NaverNewsDTO> newsList=response.body().items;
                    NewsViewAdpater viewAdpater=new NewsViewAdpater(newsList);
                    newsListView.setAdapter(viewAdpater);
                    RecyclerView.LayoutManager layoutManager
                            =new LinearLayoutManager(newsListView.getContext());
                    newsListView.setLayoutManager(layoutManager);
                }else {

                    Log.d("오류 발생",response.toString());
                }


            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

    }
}
