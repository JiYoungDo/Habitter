package com.Carrie.habitter.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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
        PopupInfo popupInfo = new PopupInfo(this);
        popupInfo.callFunction();

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

    public class PopupInfo {
        private Context context;

        public PopupInfo(Context context) {
            this.context = context;
        }

        //호출할 다이얼로그 함수
        public void callFunction()
        {
            final Dialog dig = new Dialog(context);
            dig.requestWindowFeature(Window.FEATURE_NO_TITLE);

            dig.setContentView(R.layout.popup_info);
            dig.show();

            Button go_info_btn = dig.findViewById(R.id.pop_up_info_btn_go_to_info);
            go_info_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dig.dismiss();
                }
            });

        }

    }
}
