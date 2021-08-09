package com.callor.library;

import android.os.Bundle;

import com.callor.library.service.NaverAPIServiceV1;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.callor.library.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import lombok.SneakyThrows;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    /**
     * viewbinding이 true로 설정이 되면
     * 자동으로 내부에서 생성되는 새로은 개념의 클래스이다
     */
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * setContentView(R.id.activity_main) 형식으로 *.xml 파일을 열어서
         * 화면을 구성했던 코드가 다음과 같이 변경된다
         */
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * binding이 성립되면 *.xml에 포함된 View Component는 별도의
         * 객체 선언이 필요 없고
         * 사용할때는
         *      binding.txt_name
         *      binding.txt_message
         *  와 같은 형식으로 직접 핸들링이 가능하다
         */
        setSupportActionBar(binding.toolbar);

        // ActionBar에 설정된 햄버거 버튼과 관련 코드
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // fab = findByViewId(R.id.fab) 이런 코드가 필요했으나
        // binding이 성립된 경우는 필요 없는 코드가 된다.
        // binding.fab 객체 접근하여 event등을 선언할수 있게 된다.
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @SneakyThrows
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //NaverAPIServiceV1 naver = new NaverAPIServiceV1();
                //naver.getNaverBooks("자바");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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