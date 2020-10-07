package com.Carrie.habitter.HabitLog_today_fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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
import com.Carrie.habitter.Splash.SplashActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Today_Fragment extends Fragment {

    ViewGroup viewGroup;
    HabitLogActivity mainActivity;
    RecyclerView recyclerView;
    Habit_Item_Adapter habit_item_adapter;
    ArrayList mArrayList;

    ArrayList<String> habits;

    TextView add_habit;
    TextView delete_habit;

    private Gson gson;

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

        // 습관 리스트 리사이클러 뷰 연결
        recyclerView = viewGroup.findViewById(R.id.today_fm_habit_name_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // sharepreference 리스트 가져가다 여기서 엮어주기.
        // habit 에 추가 하고
        mArrayList = new ArrayList<>();

        final SharedPreferences auto = getContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
        // 이미 저장되어 있는 얘들 모두 가져와서 arraylist 로 바꾸고
        String strhabitss = auto.getString("habits","");
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();

        //변환
        gson = new GsonBuilder().create();
        mArrayList = gson.fromJson(strhabitss,listType);

        habit_item_adapter = new Habit_Item_Adapter(mArrayList);
        habit_item_adapter.notifyDataSetChanged();
        recyclerView.setAdapter(habit_item_adapter);

        habit_item_adapter.setOnItemClickListener(new Habit_Item_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                // 세부 화면으로 넘어가기.
                Toast.makeText(getContext(),"클릭!",Toast.LENGTH_LONG).show();
                mainActivity.onChangeFragment(2);
            }
        });

        habit_item_adapter.setOnItemLongClickListener(new Habit_Item_Adapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, int pos) {
                // 삭제 해야 함.
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("해당 습관 삭제");
                builder.setMessage("현재 습관을 삭제 하시겠어요? 관련 정보는 모두 삭제 됩니다.");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(),"삭제 완료",Toast.LENGTH_SHORT).show();

                                // 삭제 처리
//                                mArrayList.remove(pos);
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(),"삭제 취소",Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
            }
        });


        // 습관 추가 버튼
        add_habit = viewGroup.findViewById(R.id.today_fm_tv_btn_add_habit);
        add_habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_habit_Dialog add_habit_dialog = new Add_habit_Dialog(mainActivity);
                add_habit_dialog.show();

                // 사용자가 팝업 창을 통해 입력한 습관 이름.
                final SharedPreferences auto = getContext().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
                // 위  str 값을 db 에 저장한다.
                String user_add_habit_now = auto.getString("user_add_habit","null").replace("'","''");
                Log.d("사용자 입력한 값 들어왔나",user_add_habit_now);


                // "habits"라는 키값에 넣어야 하는데.
                if((!user_add_habit_now.equals("null")) && (auto.getString("habits","").equals("")))
                {

                    Log.d("여기","여기");
                    // habit 에 추가 하고
                    habits = new ArrayList<String>();

                    Type listType = new TypeToken<ArrayList<String>>(){}.getType();
                    //변환
                    habits.add(user_add_habit_now);
                    gson = new GsonBuilder().create();
                    String json = gson.toJson(habits,listType);

                    SharedPreferences.Editor editor = auto.edit();
                    editor.remove("habits");
                    editor.commit();
                    editor.putString("habits",json);
                    editor.commit();

                    // 저 "user_add_habit"은 없애 놓기.remove
                    editor.remove("user_add_habit");
                    editor.commit();
                    mainActivity.onChangeFragment(1);


                    String strhabitss = auto.getString("habits","");
//                    Type listType = new TypeToken<ArrayList<String>>(){}.getType();

                    //변환
                    gson = new GsonBuilder().create();
                    mArrayList = gson.fromJson(strhabitss,listType);

                    habit_item_adapter = new Habit_Item_Adapter(mArrayList);
                    habit_item_adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(habit_item_adapter);
                    habit_item_adapter.setOnItemClickListener(new Habit_Item_Adapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int pos) {
                            // 세부 화면으로 넘어가기.
                            Toast.makeText(getContext(),"클릭!",Toast.LENGTH_LONG).show();
                            mainActivity.onChangeFragment(2);

                        }
                    });
                }
                else if(!user_add_habit_now.equals("null") && (!auto.getString("habits","").equals("")))
                {
                    Log.d("저기","저기");
                    // habit 에 추가 하고
                    habits = new ArrayList<String>();

                    // 이미 저장되어 있는 얘들 모두 가져와서 arraylist 로 바꾸고
                    String strhabits = auto.getString("habits","");
                    Type listType = new TypeToken<ArrayList<String>>(){}.getType();
                    //변환
                    gson = new GsonBuilder().create();
                    habits = gson.fromJson(strhabits,listType);
                    habits.add(user_add_habit_now);

                    gson = new GsonBuilder().create();
                    String json = gson.toJson(habits,listType);

                    SharedPreferences.Editor editor = auto.edit();
                    editor.remove("habits");
                    editor.commit();
                    editor.putString("habits",json);
                    editor.commit();

                    // 저 "user_add_habit"은 없애 놓기.remove
                    editor.remove("user_add_habit");
                    editor.commit();

                    mainActivity.onChangeFragment(1);



                    String strhabitss = auto.getString("habits","");
//                    Type listType = new TypeToken<ArrayList<String>>(){}.getType();
                    //변환
                    gson = new GsonBuilder().create();
                    mArrayList = gson.fromJson(strhabitss,listType);

                    habit_item_adapter = new Habit_Item_Adapter(mArrayList);
                    habit_item_adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(habit_item_adapter);
                    habit_item_adapter.setOnItemClickListener(new Habit_Item_Adapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int pos) {
                            // 세부 화면으로 넘어가기.
                            Toast.makeText(getContext(),"클릭!",Toast.LENGTH_LONG).show();
                            mainActivity.onChangeFragment(2);

                        }
                    });

                }
            }
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



        return viewGroup;
    }



}
