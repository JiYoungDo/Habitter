package com.Carrie.habitter.Analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.Carrie.habitter.Analysis_character.Analysis_character_Activity;
import com.Carrie.habitter.Analysis_habit.Analysis_habit_Activity;
import com.Carrie.habitter.R;
import com.Carrie.habitter.Register.RegisterActivity;

public class AnalysisActivity extends AppCompatActivity {

    ImageView back_btn;
    Button btn_habit_analysis;
    Button btn_character_analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        back_btn = findViewById(R.id.analysis_btn_back);
        btn_habit_analysis = findViewById(R.id.analysis_btn_finger_one);
        btn_character_analysis = findViewById(R.id.analysis_btn_finger_two);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_habit_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, Analysis_habit_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_character_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, Analysis_character_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
