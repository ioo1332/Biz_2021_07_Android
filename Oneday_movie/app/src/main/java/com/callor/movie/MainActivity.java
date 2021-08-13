package com.callor.movie;




import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.sevice.NaverMovieService;
import com.callor.movie.sevice.impl.NaverMovieServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar main_toolbar=findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);

        recyclerView = findViewById(R.id.movie_list_view);
        NaverMovieService naverMovieService= new NaverMovieServiceImplV1(recyclerView);

        // 초기 화면
        //naverMovieService.getMovie("아무영화검색");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화 검색");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
                NaverMovieService naverMovieService=new NaverMovieServiceImplV1(recyclerView);
                naverMovieService.getMovie(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}