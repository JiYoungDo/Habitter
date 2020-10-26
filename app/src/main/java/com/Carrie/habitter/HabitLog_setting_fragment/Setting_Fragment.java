package com.Carrie.habitter.HabitLog_setting_fragment;

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

import java.io.File;
import java.util.ArrayList;

public class Setting_Fragment extends Fragment{

    ViewGroup viewGroup;
    HabitLogActivity mainActivity;

    EditText user_change_nickname;
    Button btn_change_confirm;
    RecyclerView frequent_question;
    TextView delete_all;

    ArrayList mArrayList;
    Question_Adapter question_adapter;

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
        viewGroup = (ViewGroup) inflater.inflate(R.layout.setting_fragment,container,false);

        // 닉네임 변경
        user_change_nickname = viewGroup.findViewById(R.id.setting_fm_et_change_nickname_title);
        btn_change_confirm = viewGroup.findViewById(R.id.setting_fm_btn_change_nickname);

        btn_change_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_change_nickname.getText().toString().equals(""))
                {
                    Toast.makeText(getContext(),"닉네입을 입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("닉네임 변경");
                    builder.setMessage("닉네임을 정말 변경하시겠어요?");
                    builder.setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // sharedpreference 값 닉네임 변경
                                    SharedPreferences auto = getActivity().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = auto.edit();
                                    editor.remove("inputNickname");
                                    editor.putString("inputNickname",user_change_nickname.getText().toString());
                                    editor.commit();
                                    Intent intent = new Intent(mainActivity, HabitLogActivity.class);

                                    user_change_nickname.setText("");
                                    Toast.makeText(getContext(),"변경 완료",Toast.LENGTH_SHORT).show();

                                    startActivity(intent);
                                    mainActivity.finish();
                                }
                            });
                    builder.setNegativeButton("아니오",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getContext(),"변경 취소",Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();
                }
            }
        });

        // 데이터 모두 삭제
        delete_all = viewGroup.findViewById(R.id.setting_fm_tv_delete_all);
        delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("모든 데이터 삭제");
                builder.setMessage("모든 데이터를 삭제하시겠어요? 복구는 절대 불가능합니다.");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences auto = getActivity().getSharedPreferences("nickStr", Activity.MODE_PRIVATE);
                                SharedPreferences.Editor editor = auto.edit();
                                Intent intent = new Intent(mainActivity, SplashActivity.class);

                                editor.clear();
                                editor.commit();
                                Toast.makeText(getContext(),"모든 데이터 삭제 완료",Toast.LENGTH_SHORT).show();

                                startActivity(intent);
                                mainActivity.finish();

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

        // 자주 묻는 질문
        frequent_question = viewGroup.findViewById(R.id.setting_fm_rv_frequent_question);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        frequent_question.setLayoutManager(linearLayoutManager);

        mArrayList = new ArrayList<>();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(frequent_question.getContext(),
                linearLayoutManager.getOrientation());
        frequent_question.addItemDecoration(dividerItemDecoration);

        // dummy 넣어서 보이게 해보기.

        Question_Item question_item = new Question_Item("습관을 추가하거나 삭제는 어떻게 하나요?","오른쪽 상단의 습관더하기, 습관빼기 버튼을 사용하여 편집 할 수 있습니다.");
        Question_Item question_item2 = new Question_Item("습관별 푸시 알림을 받고 싶어요","습관을 눌러 상세 화면으로 이동해 주세요! 이동 후 알림추가 버튼을 누르고 설정하실 수 있습니다.");
        Question_Item question_item3 = new Question_Item("모든 기록을 삭제 하고 싶어요","설정 > 데이터 모두 삭제를 눌러주세요. 삭제 시 복구 할 수 없습니다.");
        Question_Item question_item4 = new Question_Item("분석 도중, 분석을 그만 하고 싶어요","분석 중이신 습관이 있으신가요? 그렇다면 분석 중 상세 화면에서 분석 끝내기 버튼을 눌러 주세요.");
        Question_Item question_item5 = new Question_Item("앱에 오류가 있는 것 같아요.","이용 중 불편을 드려 죄송합니다. carrie0129@naver.com 메일로 오류 사항 메일 보내주세요.");

        mArrayList.add(question_item);
        mArrayList.add(question_item2);
        mArrayList.add(question_item3);
        mArrayList.add(question_item4);
        mArrayList.add(question_item5);


        question_adapter = new Question_Adapter(mArrayList);
        frequent_question.setAdapter(question_adapter);

        question_adapter.setOnItemClickListener(new Question_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

            }
        });

        question_adapter.notifyDataSetChanged();


        return viewGroup;
    }




}
