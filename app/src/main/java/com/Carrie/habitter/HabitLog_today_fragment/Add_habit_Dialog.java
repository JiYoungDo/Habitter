package com.Carrie.habitter.HabitLog_today_fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.R;

public class Add_habit_Dialog extends Dialog implements View.OnClickListener {

    private Context context;
    private TextView confirm_btn;
    private TextView cancel_btn;
    private EditText user_input;

    public Add_habit_Dialog(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_habit_dialog);

        user_input = findViewById(R.id.add_habit_dialog_et_user_input);
        confirm_btn = findViewById(R.id.add_habit_dialog_tv_confirm);
        cancel_btn = findViewById(R.id.add_habit_dialog_tv_cancel);

        confirm_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == confirm_btn)
        {
            if(user_input.getText().toString().equals(""))
            {
                Toast.makeText(getContext(),"습관 이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
            }
            else
            {
                final SharedPreferences auto = getContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
                Log.d("add_habit_log",auto.getString("user_add_habit","null"));
                SharedPreferences.Editor editor = auto.edit();
                editor.remove("user_add_habit");
                editor.commit();
                Log.d("add_habit_log",auto.getString("user_add_habit","null"));
                editor.putString("user_add_habit",user_input.getText().toString());
                editor.commit();
                Log.d("add_habit_log",auto.getString("user_add_habit","null"));
                // DB 추가

                dismiss();
            }

        }
        if(v == cancel_btn)
        {
            dismiss();
        }
    }
}
