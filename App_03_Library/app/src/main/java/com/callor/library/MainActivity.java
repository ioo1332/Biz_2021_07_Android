package com.callor.library;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.callor.library.service.NaverBookService;
import com.callor.library.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    /**
     * life cycle
     * 폰에서 아이콘을 터치하여 app 을 실행
     * app 사용하고
     * app 종료하고
     *
     * app 을 실행했을때
     * 안드로이드가 폰에서 어플을 읽어서
     * 메모리에 로드하고
     * 화면 구성요소를 읽어서 화면을 그리고
     *      onCreate**() method 안의 관련된 코드 실행
     * 각 기능을 사용하기 위한 여러가지 event 핸들러를 등록
     *
     */
    @Override
    // life cycle 에서 start up method, start point method
    // app 이 실행될때 가장 먼저 호출되어 코드가 실행되는 method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar main_toolbar=findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);


        recyclerView = findViewById(R.id.book_list_view);
        NaverBookService naverBookService= new NaverBookServiceImplV1(recyclerView);
        naverBookService.getBooks("자바");
    }

    /**
     * res/menu/menu.xml 파일을 읽어서 화면의
     * ActionBar 에 메뉴등을 표현할때 사용하는 method
     * 이 method 는 안드로이드가 app 을 화면에 띄울때 자동으로 호출하여 사용하는 method
     * activity.xml 파일에 toolbar 관련된 항목이 있으면
     * Android 는 MainActivity 에 onCreateOptionsMenu 가 있는지 확인하고
     * 있으면 해당 method 호출하여 실행한다
     *
     * ActionBar에 보여줄 여러가지 항목이나, 기능들을 설정(선언)을
     * 여기에서 수행하면 된다
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 매개변수로 받은 menu 는
        // toolbar 에 기본으로 포함된 아무것도 없는 상태의 menu 객체
        // 현재 toolbar 에 기본으로 포함된 blank menu 객체에
        // main_toolbar_xml 파일에 작성되어있는 item 요소를 추가하여
        // toolbar 에 menu 가 나타나도록 하여라
        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);

        /**
         * ActionBar (AppBar)에 설정된 search 기능 구현하기
         * 1. SearchView 객체 생성하기
         */
        SearchView searchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        /**
         * Inteager.MAX_VALUE
         * java 에서 표현할수있는 정수의 최대값
         */
        // SearchBar width를 최대값으로 설정하여 화면에 가득차도록
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("도서명 검색");
        /**
         * 검색창에 값이 입력되고, 키보드의 돋보기를 클릭했을때 반응할 event 설정
         */
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 검색창에 문자열을 입력하고 키보드에 검색 버튼을 클릭했을때 반응
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("검색 버튼 클릭",query);
                NaverBookService naverBookService=new NaverBookServiceImplV1(recyclerView);
                naverBookService.getBooks(query.trim());
                return false;
            }
            // 검색창에 문자열을 입력할때 반응하는 method
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("현재 입력하는 문자열",newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}