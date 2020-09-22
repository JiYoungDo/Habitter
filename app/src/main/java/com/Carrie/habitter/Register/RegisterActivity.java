package com.Carrie.habitter.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.HowtoUse.HowtoUseActivity;
import com.Carrie.habitter.R;

public class RegisterActivity extends AppCompatActivity {

    Button how_use;
    Button start_with_analysis;
    Button start_not_analysis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        how_use = findViewById(R.id.register_tv_btn_how_to_use);
        start_with_analysis = findViewById(R.id.register_tv_btn_start_with_analysis);
        start_not_analysis = findViewById(R.id.register_tv_btn_start_without_analysis);

        // 팝업 창 띄우기

        how_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, HowtoUseActivity.class);
                startActivity(intent);
                finish();
            }
        });

        start_with_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, AnalysisActivity.class);
                startActivity(intent);
                finish();
            }
        });

        start_not_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, HabitLogActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
