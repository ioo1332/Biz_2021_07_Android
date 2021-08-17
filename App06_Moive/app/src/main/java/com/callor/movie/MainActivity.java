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

        /**
         * Content_view.xml 에 설정된 fragment view 를
         * NavController 로 등록하여
         * fragment 간의 이동을 쉽게 하겠다
         */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        // 뒤로가기 버튼등이 있을때 처리를 쉽게 하기 위한 설정
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
    /*
    ActionBar 메뉴등을 표현하기 위해서 작성되는 코드
    res/menu/menu_main.xml 파일을 읽어서
    action bar 에 menu 를 그리는 코드가 작성된다
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /**
         * Action bar 에 구현된 검색창을 활성화하기 위한 코드
         * android.wedget.SearchView를 사용하여 객체 생성
         */
        SearchView searchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화명검색");

        // 검색창이 활성화되었을때 실행되는 event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 키보드의 검색 버튼을 클릭했을때
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("검색어",query);
                /**
                 * 검색창에 입력한 검색어를 secondFragment 에게 보내고
                 * secondFragment 에서는 전달받은 검색어를 사용하여
                 * Naver Open API 영화 검색을 수행하여
                 * RecyclerView 에 표시하기
                 */
                if(!query.isEmpty()){
                    /**
                     * safe-args plugin 을 프로젝트의 gradle 에 설정하면 nav_Graph.xml 에 선언된
                     * fragment ID 를 참조하기 위한 클래스가 자동 생성 된다
                     *
                     * 여기서 생성된 action 객체에 fragment 에 전달할 데이터를 실어서 보낸다
                     *
                     * fragment 에 전달할 데이터는
                     * NavDirections 객체를 생성할때
                     * 매개 변수로 전달 한다
                     */
                   NavDirections action
                    =FirstFragmentDirections.actionFirstFragmentToSecondFragment(query);
                    // 생성된 action 에 따라 화면에
                    // sectionFragment 를 띄운다
                    NavController controller
                            =Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_content_main);
                    controller.navigate(action);

                }

                return false;
            }
            // 검색창에 문자열을 입력할때
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
            /**
             * MainActivity 에 firstFragment 가 열린상태에서
             * ActionBar 의 settings 메뉴를 클릭하면
             * firstFragment 가 있던 공간에
             * settings Fragment 를 보여주기
             *
             * 1.content_main.xml 의 fragment View 를
             * NavController로 설정하고
             * 2.navController 에 navigate 를 실행하는데
             * navGraph.xml 에 설정된 action 을 사용하여
             *
             */
           NavController controller
                   =Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_content_main);
           controller.navigate(R.id.action_FirstFragment_to_SettingsFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 안드로이드의 물리적 버튼
     * 위로가기,뒤로가기,어플종료,어플리스트 보기 등의 기능을
     * 수행하는 이벤트 핸들러
     *
     * 안드로이드 up 버튼을 눌렀을때 navigation 에 설정된 대로 뒤로가기를 수행하다
     * 가장 먼저 열린 화면에 도달했을때 up 버튼을 누르면 어플을 종료하는 코드가 자동 실행됨
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}