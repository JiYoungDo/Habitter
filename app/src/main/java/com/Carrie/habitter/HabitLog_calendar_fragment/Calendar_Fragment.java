package com.Carrie.habitter.HabitLog_calendar_fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendar_Fragment extends Fragment {

    ViewGroup viewGroup;
    HabitLogActivity mainActivity;
    ImageView quote_img;

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
        viewGroup = (ViewGroup) inflater.inflate(R.layout.calendar_fragment,container,false);
        quote_img = viewGroup.findViewById(R.id.habit_log_calendar_fm_iv);

        GregorianCalendar today = new GregorianCalendar();
        int yoil = today.get(Calendar.DATE);

        int result = yoil % 30;

        switch (result)
        {
            case 0:
                quote_img.setImageResource(R.drawable.quote1);
                break;
            case 1:
                quote_img.setImageResource(R.drawable.quote2);
                break;
            case 2:
                quote_img.setImageResource(R.drawable.quote3);
                break;
            case 3:
                quote_img.setImageResource(R.drawable.quote4);
                break;
            case 4:
                quote_img.setImageResource(R.drawable.quote5);
                break;
            case 5:
                quote_img.setImageResource(R.drawable.quote6);
                break;
            case 6:
                quote_img.setImageResource(R.drawable.quote7);
                break;
            case 7:
                quote_img.setImageResource(R.drawable.quote8);
                break;
            case 8:
                quote_img.setImageResource(R.drawable.quote9);
                break;
            case 9:
                quote_img.setImageResource(R.drawable.quote10);
                break;
            case 10:
                quote_img.setImageResource(R.drawable.quote11);
                break;
            case 11:
                quote_img.setImageResource(R.drawable.quote12);
                break;
            case 12:
                quote_img.setImageResource(R.drawable.quote13);
                break;
            case 13:
                quote_img.setImageResource(R.drawable.quote14);
                break;
            case 14:
                quote_img.setImageResource(R.drawable.quote15);
                break;
            case 15:
                quote_img.setImageResource(R.drawable.quote16);
                break;
            case 16:
                quote_img.setImageResource(R.drawable.quote17);
                break;
            case 17:
                quote_img.setImageResource(R.drawable.quote18);
                break;
            case 18:
                quote_img.setImageResource(R.drawable.quote19);
                break;
            case 19:
                quote_img.setImageResource(R.drawable.quote20);
                break;
            case 20:
                quote_img.setImageResource(R.drawable.quote21);
                break;
            case 21:
                quote_img.setImageResource(R.drawable.quote22);
                break;
            case 22:
                quote_img.setImageResource(R.drawable.quote23);
                break;
            case 23:
                quote_img.setImageResource(R.drawable.quote24);
                break;
            case 24:
                quote_img.setImageResource(R.drawable.quote25);
                break;
            case 25:
                quote_img.setImageResource(R.drawable.quote26);
                break;
            case 26:
                quote_img.setImageResource(R.drawable.quote27);
                break;
            case 27:
                quote_img.setImageResource(R.drawable.quote28);
                break;
            case 28:
                quote_img.setImageResource(R.drawable.quote29);
                break;
            case 29:
                quote_img.setImageResource(R.drawable.quote30);
                break;
            default:
                quote_img.setImageResource(R.drawable.quote15);
                break;
        }



        return viewGroup;
    }
}
