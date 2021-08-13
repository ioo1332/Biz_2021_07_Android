package com.callor.word;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;

import com.callor.word.databinding.ActivityMainBinding;
import com.callor.word.databinding.ActivityWordInsertBinding;

public class WordInsertActivity extends AppCompatActivity {

    // Binding 을 적용하기 위한 선언
    ActivityWordInsertBinding wordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding 을 적용하기 위한 생성(초기화)
        wordBinding = ActivityWordInsertBinding.inflate(getLayoutInflater());

        // Binding 을 적용하여 Activity 화면 그리기
        // setContentView(R.layout.activity_word_insert);
        setContentView(wordBinding.getRoot());

        // open 한 Activity 에게 return 하기 위한 intent 정보 추출
        // open 한 Activity 에서 데이터를 보내면 그 데이터를 받는 용도로로 사용된다
        Intent returnIntent = new Intent();
        // 저장버튼을 클릭했을때
        wordBinding.btnSave.setOnClickListener(view->{

            // 두개의 입력박스에 입력한 값을 변수에 담기
            String word = wordBinding.inputWord.getText().toString();
            String korea = wordBinding.inputKorea.getText().toString();

            // WORD, KOREA 라는 변수를 각각 선언하고
            // word, korea 에 담긴 값을 보내기 위하여 setting(putting)하기
            returnIntent.putExtra("WORD",word);
            returnIntent.putExtra("KOREA",korea);

            // open 한 Activity 데이터가 준비되었으니 (RESULT_OK)
            // 데이터를 받아라
            setResult(RESULT_OK,returnIntent);

            // 새롭게 열린 Activity 에서 자신을 닫는(끝내기) method
            finish();
        });

    }
}