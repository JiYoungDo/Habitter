package com.Carrie.habitter.SevenDays;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.Carrie.habitter.Analysis_habit_Result.Analysis_habit_result_Activity;
import com.Carrie.habitter.R;

public class SevenDaysActivity extends AppCompatActivity {

    TextView D_Day;
    EditText where_answer;
    Button when_time_picker;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_days);

        D_Day = findViewById(R.id.seven_days_tv_title);
        where_answer = findViewById(R.id.seven_days_et_question_1);

        back_btn = findViewById(R.id.seven_days_btn_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SevenDaysActivity.this, Analysis_habit_result_Activity.class);
                startActivity(intent);
                finish();

            }
        });

        when_time_picker = findViewById(R.id.seven_days_btn_question_2);
        when_time_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();
            }
        });
    }

    void showTime()
    {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(),hourOfDay+"시 "+minute+"분 을 선택했습니다",Toast.LENGTH_SHORT).show();
            }
        },21,12,true);
        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();
    }

}
