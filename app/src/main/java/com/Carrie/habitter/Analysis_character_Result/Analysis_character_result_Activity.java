package com.Carrie.habitter.Analysis_character_Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Carrie.habitter.Analysis_habit.Analysis_habit_Activity;
import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.R;

public class Analysis_character_result_Activity extends AppCompatActivity {

    ImageView character_img;
    TextView character_title;
    TextView character_detail_1;
    TextView character_detail_2;

    Button go_to_habit_analysis;
    Button go_to_daily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_character_result_);

        // [아직 안 한 부분] sharedpreference 체크

        int joonsoo = getIntent().getIntExtra("준수",0);
        int euimoon = getIntent().getIntExtra("의문",0);
        int gangjae = getIntent().getIntExtra("강제",0);
        int jeohang = getIntent().getIntExtra("저항",0);

        character_img = findViewById(R.id.character_result_iv);
        character_title = findViewById(R.id.character_result_tv_title);
        character_detail_1 = findViewById(R.id.character_result_tv_detail1);
        character_detail_2 = findViewById(R.id.character_result_tv_detail2);

        go_to_habit_analysis = findViewById(R.id.character_result_btn_go_to_habit_analysis);
        go_to_habit_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis_character_result_Activity.this, Analysis_habit_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        go_to_daily = findViewById(R.id.character_result_btn_go_to_daily);
        go_to_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis_character_result_Activity.this, HabitLogActivity.class);
                startActivity(intent);
                finish();
            }
        });



       if(joonsoo >= euimoon && joonsoo >= gangjae && joonsoo >=jeohang)
       {
           // 준수형일 때
           character_img.setImageResource(R.drawable.joonsoo);
           Animation anim = AnimationUtils.loadAnimation
                   (getApplicationContext(),R.anim.scale);
           character_img.startAnimation(anim);

           character_title.setText(R.string.joonsoo_title);
           character_detail_1.setText(R.string.joonsoo_detail1);
           character_detail_2.setText(R.string.joonsoo_detail2);
       }
       else if(euimoon >= joonsoo && euimoon >= gangjae && euimoon >= jeohang)
       {
           // 의문형일 때
           character_img.setImageResource(R.drawable.euimoon);
           Animation anim = AnimationUtils.loadAnimation
                   (getApplicationContext(),R.anim.scale);
           character_img.startAnimation(anim);

           character_title.setText(R.string.euimoon_title);
           character_detail_1.setText(R.string.euimoon_detail1);
           character_detail_2.setText(R.string.euimoon_detail2);

       }
       else if(gangjae >= joonsoo && gangjae >= euimoon && gangjae >= jeohang)
       {
           // 강제형일 때
           character_img.setImageResource(R.drawable.gangjae);
           Animation anim = AnimationUtils.loadAnimation
                   (getApplicationContext(),R.anim.scale);
           character_img.startAnimation(anim);

           character_title.setText(R.string.gangjae_title);
           character_detail_1.setText(R.string.gangjae_detail1);
           character_detail_2.setText(R.string.gangjae_detail2);

       }
       else
       {
           //저항형
           character_img.setImageResource(R.drawable.jeohang);
           Animation anim = AnimationUtils.loadAnimation
                   (getApplicationContext(),R.anim.scale);
           character_img.startAnimation(anim);

           character_title.setText(R.string.jeohang_title);
           character_detail_1.setText(R.string.jeohang_detail1);
           character_detail_2.setText(R.string.jeohang_detail2);

       }

    }
}
