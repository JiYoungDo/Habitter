package com.Carrie.habitter.HabitLog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.Carrie.habitter.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HabitLogActivity extends AppCompatActivity {

    TextView nick_name;
    TextView date;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_log);

        nick_name = findViewById(R.id.habit_log_tv_nickname_title);
        date = findViewById(R.id.habit_log_tv_date);
        bottomNavigationView  = findViewById(R.id.activity_bnv);
        bottomNavigationView.setItemIconTintList(null);

        // nick_name 을 가져온 후 "의 하루"를 붙여 준다.

        // time 보여주기
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
        String getTime = simpleDate.format(mDate);
        date.setText(getTime);



    }
}
