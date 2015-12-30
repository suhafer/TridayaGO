package com.tridaya.tridayago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText maUserName, maPassword;
    TextView maForget;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        maUserName = (EditText) findViewById(R.id.ma_username);
        maPassword = (EditText) findViewById(R.id.ma_password);
        login = (Button) findViewById(R.id.ma_login);
        maForget = (TextView) findViewById(R.id.ma_forget);

        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Checkin_Activity.class);
                startActivity(i);
                finish();
            }
        });

        /*
        maForget.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });*/

    }
}
