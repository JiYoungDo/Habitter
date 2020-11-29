package com.Carrie.habitter.Analysis_habit_Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.R;
import com.Carrie.habitter.SevenDays.SevenDaysActivity;

public class Analysis_habit_result_Activity extends AppCompatActivity {

    Button go_so_seven_days;
    Button go_daily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_habit_result_);

        go_so_seven_days = findViewById(R.id.analysis_result_btn_finger_one);
        go_daily = findViewById(R.id.analysis_result_btn_go_to_today);


        go_so_seven_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Analysis_habit_result_Activity.this, SevenDaysActivity.class);
                startActivity(intent);
                finish();
            }
        });

        go_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Analysis_habit_result_Activity.this, HabitLogActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
