package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.callor.hello.model.UserDTO;

public class JoinActivity extends AppCompatActivity {

    TextView user_id;
    TextView password;
    TextView address;
    TextView tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        user_id = findViewById(R.id.txt_userid);
        password = findViewById(R.id.txt_password);
        address = findViewById(R.id.txt_addr);
        tel = findViewById(R.id.txt_tel);

        Intent intent = getIntent();

        /**
         * Serializable 된 DTO 데이터를 받기
         */
        UserDTO user = (UserDTO) intent.getSerializableExtra("USER");

        user_id.setText(user.user_id);
        password.setText(user.password);
        address.setText(user.addr);
        tel.setText(user.tel);

    }
}