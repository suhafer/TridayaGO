package com.tridaya.tridayago;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Splash_Activity extends AppCompatActivity {

    private static int SA_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(Splash_Activity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SA_TIME_OUT);

    }

}
