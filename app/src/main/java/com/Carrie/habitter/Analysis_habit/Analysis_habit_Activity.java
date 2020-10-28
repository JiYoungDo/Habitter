package com.Carrie.habitter.Analysis_habit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.R;

public class Analysis_habit_Activity extends AppCompatActivity {

    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_habit_);

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
