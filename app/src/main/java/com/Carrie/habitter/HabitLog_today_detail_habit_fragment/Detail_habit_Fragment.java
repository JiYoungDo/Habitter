package com.Carrie.habitter.HabitLog_today_detail_habit_fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.HabitLog_setting_fragment.Question_Adapter;
import com.Carrie.habitter.HabitLog_setting_fragment.Question_Item;
import com.Carrie.habitter.R;
import com.Carrie.habitter.Splash.SplashActivity;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;

public class Detail_habit_Fragment extends Fragment{

    ViewGroup viewGroup;
    HabitLogActivity mainActivity;
    MaterialCalendarView calendarView;
    ImageView close_btn;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (HabitLogActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity =null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.detail_habit_fragment,container,false);
        calendarView =viewGroup.findViewById(R.id.detail_habit_fm_calendar);

        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);

        // 안 먹히는 중
        calendarView.setDateSelected(CalendarDay.from(2020,10,5),true);
        calendarView.setDateSelected(CalendarDay.from(2020,10,6),true);


        close_btn = viewGroup.findViewById(R.id.detail_habit_fm_btn_close);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onChangeFragment(1);
            }
        });

        return viewGroup;
    }




}
