package com.Carrie.habitter.HabitLog_today_fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

    TextView add_habit;
    TextView delete_habit;

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

        // 습관 추가 버튼
        add_habit = viewGroup.findViewById(R.id.today_fm_tv_btn_add_habit);
        add_habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_habit_Dialog add_habit_dialog = new Add_habit_Dialog(mainActivity);
                add_habit_dialog.show();
            }

            // 사용자가 팝업 창을 통해 입력한 습관 이름.
            final SharedPreferences auto = getContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
            String user_add_habit_now = auto.getString("user_add_habit","null");
            // 위  str 값을 db 에 저장한다.

        });





        // 습관 삭제 버튼
        delete_habit = viewGroup.findViewById(R.id.today_fm_tv_btn_remove_habit);
        delete_habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_habit_Dialog delete_habit_dialog = new Delete_habit_Dialog(mainActivity);
                delete_habit_dialog.show();
            }
        });


        // 습관 리스트 리사이클러 뷰 연결
        recyclerView = viewGroup.findViewById(R.id.today_fm_habit_name_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mArrayList = new ArrayList<>();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // dummy 넣어서 보이게 해보기.
        Habit_Item habit_item = new Habit_Item("독서하기");
        Habit_Item habit_item2 = new Habit_Item("운동장 10바퀴!");
        Habit_Item habit_item3 = new Habit_Item("8:30 기상!");

        mArrayList.add(habit_item);
        mArrayList.add(habit_item2);
        mArrayList.add(habit_item3);

        habit_item_adapter = new Habit_Item_Adapter(mArrayList);
        recyclerView.setAdapter(habit_item_adapter);
        habit_item_adapter.setOnItemClickListener(new Habit_Item_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                // 세부 화면으로 넘어가기.
                Toast.makeText(getContext(),"클릭!",Toast.LENGTH_LONG).show();
            }
        });

        habit_item_adapter.notifyDataSetChanged();
        return viewGroup;
    }



}
