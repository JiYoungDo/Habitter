package com.Carrie.habitter.HabitLog_today_fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.Carrie.habitter.R;

public class Delete_habit_Dialog extends Dialog implements View.OnClickListener {

    private Context context;
    private TextView confirm_btn;

    public Delete_habit_Dialog(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.delete_habit_dialog);

        confirm_btn = findViewById(R.id.delete_habit_dialog_tv_confirm);
        confirm_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v == confirm_btn)
        {
            dismiss();
        }
    }
}
