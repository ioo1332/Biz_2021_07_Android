package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.callor.hello.model.UserDTO;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText input_userid = null;
    TextInputEditText input_password = null;
    TextInputEditText input_tel = null;
    TextInputEditText input_addr = null;

    Button btn_save = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_userid = findViewById(R.id.input_userid);
        input_password = findViewById(R.id.input_password);
        input_addr = findViewById(R.id.input_address);
        input_tel = findViewById(R.id.input_tel);

        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(view->{

            String user_id = input_userid.getText().toString();
            String password = input_password.getText().toString();
            String addr = input_addr.getText().toString();
            String tel = input_tel.getText().toString();

            UserDTO user = new UserDTO();
            user.user_id = user_id;
            user.password = password;
            user.tel = tel;
            user.addr = addr;

            Intent join_intent
                    = new Intent(MainActivity.this,
                    JoinActivity.class);

            join_intent.putExtra("USER", user);
            startActivity(join_intent);

        });



    }
}