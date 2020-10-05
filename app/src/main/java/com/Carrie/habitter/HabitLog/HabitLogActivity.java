package com.Carrie.habitter.HabitLog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.Carrie.habitter.HabitLog_calendar_fragment.Calendar_Fragment;
import com.Carrie.habitter.HabitLog_setting_fragment.Setting_Fragment;
import com.Carrie.habitter.HabitLog_today_fragment.Today_Fragment;
import com.Carrie.habitter.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HabitLogActivity extends AppCompatActivity {

    TextView nick_name;
    TextView date;

    BottomNavigationView bottomNavigationView;

    Setting_Fragment setting_fragment;
    Calendar_Fragment calendar_fragment;
    Today_Fragment today_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_log);

        nick_name = findViewById(R.id.habit_log_tv_nickname_title);
        date = findViewById(R.id.habit_log_tv_date);
        bottomNavigationView  = findViewById(R.id.habit_log_activity_bnv);
//        fl = findViewById(R.id.habit_log_activity_fl);
        bottomNavigationView.setItemIconTintList(null);

        setting_fragment = new Setting_Fragment();
        calendar_fragment = new Calendar_Fragment();
        today_fragment = new Today_Fragment();


        // nick_name 을 가져온 후 "의 하루"를 붙여 준다.
        SharedPreferences auto = getSharedPreferences("nickStr", Activity.MODE_PRIVATE);

        String nick = auto.getString("inputNickname",null);
        nick_name.setText(nick+"의 오늘,");



        // time 텍스트 날짜 정보 가져와서 세팅
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
        String getTime = simpleDate.format(mDate);
        date.setText(getTime);


        // 제일 처음 띄어줄 뷰 세팅
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.habit_log_activity_fl,today_fragment).commitAllowingStateLoss();

        //bottom icon 선택시 프레그 먼트 띄우기 / 리스너 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_clock_item: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.habit_log_activity_fl, today_fragment).commitAllowingStateLoss();
                        int dark_gray_color = getResources().getColor(R.color.colorDarkGray);
                        nick_name.setTextColor(dark_gray_color);
                        date.setTextColor(dark_gray_color);
                        return true;
                    }
                    case R.id.menu_calendar_item: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.habit_log_activity_fl, calendar_fragment).commitAllowingStateLoss();
                        int white_color = getResources().getColor(R.color.colorWhite);
                        nick_name.setTextColor(white_color);
                        date.setTextColor(white_color);
                        return true;
                    }
                    case R.id.menu_setting_item: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.habit_log_activity_fl, setting_fragment).commitAllowingStateLoss();
                        int white_color = getResources().getColor(R.color.colorWhite);
                        nick_name.setTextColor(white_color);
                        date.setTextColor(white_color);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });


    }
}
