package com.ioo168400.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.ioo168400.chatt.adpter.ChattAdapter;
import com.ioo168400.chatt.model.Chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // chatt 메시지를 전달하는 view
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // chatt 메시지를 표현할 view
    private RecyclerView chat_list_view;
    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * setContentView(R.layout.activity_main);
         * *layout.xml 파일을 읽어서 화면을 만드는 method
         * setContentView 는 한개의 파일을 읽어서 한개의 전체화면을 만드는것
         */
        setContentView(R.layout.activity_main);

        txt_msg=findViewById(R.id.txt_msg);
        btn_send=findViewById(R.id.btn_send);

        chat_list_view=findViewById(R.id.chatt_list_view);
        // 0. 보여줄 데이터 객체 생성
        chattList=new ArrayList<Chatt>();
        // 테스트를 위한 가상의 데이터 생성
        Chatt chatt=new Chatt();
        chatt.setName("홍길동");
        chatt.setMsg("반갑습니다");
        chattList.add(chatt);

        chatt=new Chatt();
        chatt.setName("성춘향");
        chatt.setMsg("반갑소");
        chattList.add(chatt);

        chatt=new Chatt();
        chatt.setName("이몽룡");
        chatt.setMsg("오늘은 더운날");
        chattList.add(chatt);

        // 1. Adapter 객체 생성
        // Adapter 객체를 생성할때 보여줄 데이터 객체를
        // 생성자 매개 변수로 주입해 주어야 한다
        chattAdapter=new ChattAdapter(chattList);

        // 2. RecyclerView.Adapter 와 RecyclerView 를 서로 연결
        chat_list_view.setAdapter(chattAdapter);

        // 3. RecyclerView 의 데이터를 표현하는데 사용할 Layout 매니저를 설정
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);


    }
}