package com.Carrie.habitter.HabitLog_today_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Carrie.habitter.HabitLog.HabitLogActivity;
import com.Carrie.habitter.R;

import java.util.ArrayList;

public class Today_Fragment extends Fragment {

    ViewGroup viewGroup;
    HabitLogActivity mainActivity;
    RecyclerView recyclerView;
    Habit_Item_Adapter habit_item_adapter;
    ArrayList mArrayList;

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
        viewGroup = (ViewGroup) inflater.inflate(R.layout.today_fragment,container,false);

        recyclerView = viewGroup.findViewById(R.id.today_fm_habit_name_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mArrayList = new ArrayList<>();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // dummy 넣어서 보이게 해보기.
        int color_1 = getResources().getColor(R.color.colorAccent);
        int color_2 = getResources().getColor(R.color.colorPrimaryDark);
        int color_3 = getResources().getColor(R.color.colorHotCoral);
        Habit_Item habit_item = new Habit_Item("독서하기",color_1);
        Habit_Item habit_item2 = new Habit_Item("운동장 10바퀴!",color_2);
        Habit_Item habit_item3 = new Habit_Item("8:30 기상!",color_3);

        mArrayList.add(habit_item);
        mArrayList.add(habit_item2);
        mArrayList.add(habit_item3);

        habit_item_adapter = new Habit_Item_Adapter(mArrayList);
        recyclerView.setAdapter(habit_item_adapter);
        habit_item_adapter.setOnItemClickListener(new Habit_Item_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(getContext(),"클릭!",Toast.LENGTH_LONG).show();
            }
        });

        habit_item_adapter.notifyDataSetChanged();
        return viewGroup;
    }



}
