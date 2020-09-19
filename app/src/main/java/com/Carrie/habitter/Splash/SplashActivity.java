package com.Carrie.habitter.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.Carrie.habitter.R;
import com.Carrie.habitter.Register.RegisterActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 만약 shared preference 에 로그인 정보가 있다면, 개인 페이지로 넘어가고
        // 로그인 정보가 없다면, 회원가입 화면으로

        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
