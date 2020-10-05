package com.Carrie.habitter.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Carrie.habitter.Analysis.AnalysisActivity;
import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.HowtoUse.HowtoUseActivity;
import com.Carrie.habitter.R;

public class RegisterActivity extends AppCompatActivity {

    Button how_use;
    Button start_with_analysis;
    Button start_not_analysis;

    EditText user_nick_name;
    String shared_nick_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        how_use = findViewById(R.id.register_tv_btn_how_to_use);
        start_with_analysis = findViewById(R.id.register_tv_btn_start_with_analysis);
        start_not_analysis = findViewById(R.id.register_tv_btn_start_without_analysis);
        user_nick_name = findViewById(R.id.register_et_nick_name);

        // 팝업 창 띄우기
        PopupInfo popupInfo = new PopupInfo(this);
        popupInfo.callFunction();

        final SharedPreferences auto = getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
        shared_nick_name = auto.getString("inputNickname",null);

        // auto 라는 sharedPreference 에 inputNickname 이라는 키값의 value 에 저장된 값이 있으면, 자동로그인 처리!
        // 화면은 일단, HabitLogActivity로 넘긴다. ( 분석 없이 시작 화면 )
        if(shared_nick_name != null)
        {
            Toast.makeText(RegisterActivity.this, shared_nick_name+"님 자동로그인 입니다.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, HabitLogActivity.class );
            startActivity(intent);
            finish();
        }

        // 사용 방법 버튼
        how_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, HowtoUseActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 분석 후 사용 버튼
        start_with_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_nick_name.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "닉네임을 입력해 주세요.",Toast.LENGTH_LONG).show();
                } else
                {
                    // 닉네임 정보 저장 + intent 로 보내기
                    Intent intent = new Intent(RegisterActivity.this, AnalysisActivity.class);
                    startActivity(intent);
                    SharedPreferences.Editor editor = auto.edit();
                    editor.putString("inputNickname",user_nick_name.getText().toString());
                    editor.commit();
                    finish();
                }

            }
        });

        // 분석 없이 사용 버튼
        start_not_analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_nick_name.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "닉네임을 입력해 주세요.",Toast.LENGTH_LONG).show();
                }else {
                    // 닉네임 정보 저장 + intent 로 보내기
                    Intent intent = new Intent(RegisterActivity.this, HabitLogActivity.class);
                    startActivity(intent);
                    SharedPreferences.Editor editor = auto.edit();
                    editor.putString("inputNickname",user_nick_name.getText().toString());
                    editor.commit();
                    finish();
                }

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
