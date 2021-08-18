package com.callor.movie;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.callor.movie.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // menu_main.xml 에 item 으로 설정된 항목중에
        // searchView 클래스가 지정된 item 을 가져와서
        // searchView 객체로 생성하기
        SearchView searchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화명 검색");

        // 검색창에 검색어를 입력하고
        // 키보드의 검색을 클릭했을때
        // 반응하는 event 핸들러
        // 검색창에 문자열을 입력할때, 검색을 클릭했을때 반응하는 event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("입력한검색어",query);
                // !query.isEmpty()
                if(query.isEmpty()==false){
                    /**
                     * actionFirstFragment to secondFragment() method 에 값 주입하여
                     * secondFragment 로 값 전달하기
                     * nav_Graph.xml 에 설정된 argument 에 변수에 값을
                     * 셋팅하는 것으로 defaultValue 값을 없애고 매개변수로 값을 주입하여 전달 한다
                     */
                    NavDirections action=FirstFragmentDirections.actionFirstFragmentToSecondFragment(query);
                    NavController controller
                            = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);

                    // 열려있는 Search 창을 닫는 method
                    menu.findItem(R.id.app_bar_search).collapseActionView();

                    // 만약 first Fragment 화면이 아닌경우
                    // second Fragment 화면이 열려있는 상태이면
                    // 위로가기를 한번 실행하고
                    // 그리고 navigation 을 이동하라
                    controller.navigateUp();
                    controller.navigate(action);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}