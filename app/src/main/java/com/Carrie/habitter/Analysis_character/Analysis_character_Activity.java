package com.Carrie.habitter.Analysis_character;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.R;

public class Analysis_character_Activity extends AppCompatActivity {

    ImageView back_btn;
    TextView submit_btn;

    boolean All_check;

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

        submit_btn = findViewById(R.id.analysis_charcter_btn_submit);


        // 하나라도 체크가 되어있지 않으면 제출하기 버튼 안보이게
        // 모두 체크되면 버튼 생기고 애니메이션까지
    }
}
