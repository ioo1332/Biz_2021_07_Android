package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_message = findViewById(R.id.txt_login_msg);

        // 나를 호출한 Activity를 추출하기
        Intent intent = getIntent();

        String userid = intent.getExtras().getString("user_id");
        String password = intent.getExtras().getString("password");

        String msg = String.format("email : %s\npassword : %s",
                        userid,password);

        txt_message.setText(msg);

    }
}