package com.Carrie.habitter.Analysis_character;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.Analysis_character_Result.Analysis_character_result_Activity;
import com.Carrie.habitter.R;

import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;

public class Analysis_character_Activity extends AppCompatActivity {

    ImageView back_btn;
    TextView submit_btn;

    int joonsoo = 0;
    int euimoon = 0;
    int gangjae = 0;
    int jeohang = 0;

    int count = 0;

    SegmentedGroup q1;
    SegmentedGroup q2;
    SegmentedGroup q3;
    SegmentedGroup q4;
    SegmentedGroup q5;
    SegmentedGroup q6;
    SegmentedGroup q7;
    SegmentedGroup q8;
    SegmentedGroup q9;
    SegmentedGroup q10;
    SegmentedGroup q11;
    SegmentedGroup q12;
    SegmentedGroup q13;
    SegmentedGroup q14;
    SegmentedGroup q15;
    SegmentedGroup q16;
    SegmentedGroup q17;
    SegmentedGroup q18;
    SegmentedGroup q19;
    SegmentedGroup q20;
    SegmentedGroup q21;
    SegmentedGroup q22;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_character_);

        back_btn = findViewById(R.id.analysis_charcter_btn_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis_character_Activity.this, AnalysisActivity.class);
                startActivity(intent);
                finish();
            }
        });

        submit_btn= findViewById(R.id.analysis_charcter_btn_submit);



        q1 = findViewById(R.id.segmented1);
        q2 = findViewById(R.id.segmented2);
        q3 = findViewById(R.id.segmented3);
        q4 = findViewById(R.id.segmented4);
        q5 = findViewById(R.id.segmented5);
        q6 = findViewById(R.id.segmented6);
        q7 = findViewById(R.id.segmented7);

        q8 = findViewById(R.id.segmented8);
        q9 = findViewById(R.id.segmented9);
        q10 = findViewById(R.id.segmented10);
        q11 = findViewById(R.id.segmented11);
        q12 = findViewById(R.id.segmented12);
        q13 = findViewById(R.id.segmented13);
        q14 = findViewById(R.id.segmented14);

        q15 = findViewById(R.id.segmented15);
        q16 = findViewById(R.id.segmented16);
        q17 = findViewById(R.id.segmented17);
        q18 = findViewById(R.id.segmented18);
        q19 = findViewById(R.id.segmented19);
        q20 = findViewById(R.id.segmented20);
        q21 = findViewById(R.id.segmented21);
        q22 = findViewById(R.id.segmented22);

    }

    @Override
    protected void onResume() {
        super.onResume();

        submit_btn.setVisibility(View.GONE);

        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button11 || checkedId == R.id.button12) {
                        if(checkedId == R.id.button11)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button12)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button11 || checkedId == R.id.button12) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button11)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button12)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button21 || checkedId == R.id.button22) {
                        if(checkedId == R.id.button21)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button22)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button21 || checkedId == R.id.button22) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button21)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button22)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button31 || checkedId == R.id.button32) {
                        if(checkedId == R.id.button31)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button32)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button31 || checkedId == R.id.button32) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button31)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button32)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button41 || checkedId == R.id.button42) {
                        if(checkedId == R.id.button41)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button42)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button41 || checkedId == R.id.button42) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button41)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button42)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button51 || checkedId == R.id.button52) {

                        if(checkedId == R.id.button51)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button52)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button51 || checkedId == R.id.button52) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button51)
                        {
                            joonsoo+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button52)
                        {
                            if(type_count >0)
                            {
                                joonsoo -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        q6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button61 || checkedId == R.id.button62) {

                        if(checkedId == R.id.button61)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button62)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button61 || checkedId == R.id.button62) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button61)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button62)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button71 || checkedId == R.id.button72) {
                        if(checkedId == R.id.button71)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button72)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button71 || checkedId == R.id.button72) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button71)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button72)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button81 || checkedId == R.id.button82) {

                        if(checkedId == R.id.button81)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button82)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button81 || checkedId == R.id.button82) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button81)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button82)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button91 || checkedId == R.id.button92) {

                        if(checkedId == R.id.button91)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button92)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button91 || checkedId == R.id.button92) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button91)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button92)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button101 || checkedId == R.id.button102) {

                        if(checkedId == R.id.button101)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button102)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button101 || checkedId == R.id.button102) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button101)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button102)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        q11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button111 || checkedId == R.id.button112) {

                        if(checkedId == R.id.button111)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button112)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button111 || checkedId == R.id.button112) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button111)
                        {
                            euimoon+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button112)
                        {
                            if(type_count >0)
                            {
                                euimoon -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button121 || checkedId == R.id.button122) {

                        if(checkedId == R.id.button121)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button122)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button121 || checkedId == R.id.button122) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button121)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button122)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button131 || checkedId == R.id.button132) {

                        if(checkedId == R.id.button131)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button132)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button131 || checkedId == R.id.button132) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button131)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button132)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button141 || checkedId == R.id.button142) {

                        if(checkedId == R.id.button141)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button142)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button141 || checkedId == R.id.button142) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button141)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button142)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button151 || checkedId == R.id.button152) {
                        if(checkedId == R.id.button151)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button152)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button151 || checkedId == R.id.button152) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button151)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button152)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        q16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button161 || checkedId == R.id.button162) {

                        if(checkedId == R.id.button161)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button162)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button161 || checkedId == R.id.button162) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button161)
                        {
                            gangjae+=6;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button162)
                        {
                            if(type_count >0)
                            {
                                gangjae -=6;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button171 || checkedId == R.id.button172) {
                        if(checkedId == R.id.button171)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button172)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button171 || checkedId == R.id.button172) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button171)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button172)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button181 || checkedId == R.id.button182) {

                        if(checkedId == R.id.button181)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button182)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button181 || checkedId == R.id.button182) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button181)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button182)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button191 || checkedId == R.id.button192) {

                        if(checkedId == R.id.button191)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button192)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button191 || checkedId == R.id.button192) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button191)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button192)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button201 || checkedId == R.id.button202) {

                        if(checkedId == R.id.button201)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button202)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button201 || checkedId == R.id.button202) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button201)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button202)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button211 || checkedId == R.id.button212) {

                        if(checkedId == R.id.button211)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button212)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button211 || checkedId == R.id.button212) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button211)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button212)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        q22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int this_count = 0;
            int type_count = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(this_count > 0) {
                    if(checkedId == R.id.button221 || checkedId == R.id.button222) {

                        if(checkedId == R.id.button221)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button222)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                else
                {
                    if(checkedId == R.id.button221 || checkedId == R.id.button222) {
                        count+=1;
                        this_count +=1;
                        if(checkedId == R.id.button221)
                        {
                            jeohang+=5;
                            type_count+=1;
                        }
                        if(checkedId == R.id.button222)
                        {
                            if(type_count >0)
                            {
                                jeohang -=5;
                                type_count = 0;
                            }
                        }
                    }
                }
                Log.d("count : ",String.valueOf(count));
                if(count >= 22)
                {
                    submit_btn.setVisibility(View.VISIBLE);
                    Animation anim = AnimationUtils.loadAnimation
                            (getApplicationContext(),R.anim.scale);
                    submit_btn.startAnimation(anim);
                    submit_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Analysis_character_Activity.this, Analysis_character_result_Activity.class);
                            intent.putExtra("준수", joonsoo);
                            intent.putExtra("의문", euimoon);
                            intent.putExtra("강제", gangjae);
                            intent.putExtra("저항", jeohang);

                            // intent 로 분석 결과도 보내기.
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });





    }
}
