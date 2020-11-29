package com.Carrie.habitter.Analysis_habit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.Analysis_habit_Result.Analysis_habit_result_Activity;
import com.Carrie.habitter.R;
import com.Carrie.habitter.SevenDays.SevenDaysActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Analysis_habit_Activity extends AppCompatActivity {

    ImageView back_btn;
    Button start_analysis_btn;

    EditText repeat_act;
    EditText award_1;
    EditText award_2;
    EditText award_3;
    EditText award_4;
    EditText award_5;
    EditText award_6;
    EditText award_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_habit_);

        repeat_act  = findViewById(R.id.analysis_habit_et_1);
        award_1 = findViewById(R.id.analysis_habit_et_2_1);
        award_2 = findViewById(R.id.analysis_habit_et_2_2);
        award_3 = findViewById(R.id.analysis_habit_et_2_3);
        award_4 = findViewById(R.id.analysis_habit_et_2_4);
        award_5 = findViewById(R.id.analysis_habit_et_2_5);
        award_6 = findViewById(R.id.analysis_habit_et_2_6);
        award_7 = findViewById(R.id.analysis_habit_et_2_7);


        // 시간을 재서 만약에 7일 이상이면 관련 sharedPreferences 삭제!

        final SharedPreferences auto = getApplicationContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
        String temp = auto.getString("is_on_analysis","null");

        if(temp == "null")
        {
            // null 인 경우는 분석 중이 아니 라는 것! 시간 젤 필요 없음
        }
        else
        {
            // 이 경우 카운트 다운을 7일 동안 해야 하는 것!
            long now = System.currentTimeMillis();
            Date mDate = new Date(now);
            SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
            String getTime = simpleDate.format(mDate);

            String Share_date = auto.getString("analysis_start_date","0");

            // getTime - Share_date >= 7일 이상이면 분석 중지
            //
            //

        }



        start_analysis_btn = findViewById(R.id.analysis_habit_btn_start_analysis);
        start_analysis_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sharedPreference 로 분석 시작 중임을 알리고
                // 이거 에 해당하는 다른 애들 도 sharedPreference 로 넘기고
                final SharedPreferences auto = getApplicationContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
                Log.d("is_on_analysis",auto.getString("is_on_analysis","null"));
                Log.d("repeat_act",auto.getString("repeat_act","null"));
                Log.d("award_1",auto.getString("award_1","null"));
                Log.d("award_2",auto.getString("award_2","null"));
                Log.d("award_3",auto.getString("award_3","null"));
                Log.d("award_4",auto.getString("award_4","null"));
                Log.d("award_5",auto.getString("award_5","null"));
                Log.d("award_6",auto.getString("award_6","null"));
                Log.d("award_7",auto.getString("award_7","null"));

                SharedPreferences.Editor editor = auto.edit();
                editor.remove("is_on_analysis");
                editor.remove("repeat_act");
                editor.remove("award_1");
                editor.remove("award_2");
                editor.remove("award_3");
                editor.remove("award_4");
                editor.remove("award_5");
                editor.remove("award_6");
                editor.remove("award_7");
                editor.commit();

                Log.d("is_on_analysis",auto.getString("is_on_analysis","null"));

                editor.putString("is_on_analysis","yes");
                editor.putString("repeat_act",repeat_act.getText().toString());
                editor.putString("award_1",award_1.getText().toString());
                editor.putString("award_2",award_2.getText().toString());
                editor.putString("award_3",award_3.getText().toString());
                editor.putString("award_4",award_4.getText().toString());
                editor.putString("award_5",award_5.getText().toString());
                editor.putString("award_6",award_6.getText().toString());
                editor.putString("award_7",award_7.getText().toString());

                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
                String getTime = simpleDate.format(mDate);
                editor.putString("analysis_start_date", getTime);

                editor.commit();

                Log.d("is_on_analysis",auto.getString("is_on_analysis","null"));

                Intent intent = new Intent(Analysis_habit_Activity.this, Analysis_habit_result_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        back_btn = findViewById(R.id.analysis_habit_btn_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis_habit_Activity.this, AnalysisActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
