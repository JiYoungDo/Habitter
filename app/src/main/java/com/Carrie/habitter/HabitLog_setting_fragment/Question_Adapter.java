package com.Carrie.habitter.HabitLog_setting_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Carrie.habitter.R;

import java.util.ArrayList;

public class Question_Adapter extends  RecyclerView.Adapter<Question_Adapter.Question_ViewHolder> {

    private ArrayList<Question_Item> mList;
    Context context;

    // 리스너 인터페이스 정의하기
    public interface OnItemClickListener
    {
        void onItemClick(View v, int pos);
    }

    // 전달된 객체 저장할 변수
    private Question_Adapter.OnItemClickListener mListener = null;

    // 리스너 객체 전달 메서드
    public void setOnItemClickListener(OnItemClickListener listener)
    { this.mListener = listener; }


    public class Question_ViewHolder extends  RecyclerView.ViewHolder
    {
        protected TextView Question_title;
        protected TextView Question_contents;

        public Question_ViewHolder(View view)
        {
            super(view);
            this.Question_title = view.findViewById(R.id.frequent_question_item_title);
            this.Question_contents = view.findViewById(R.id.frequent_question_item_detail);

            // 뷰홀더가 만들어지는 시점에 클릭 이벤트 처리
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        mListener.onItemClick(v,pos);
                    }
                }
            });
        }
    }

    public Question_Adapter(ArrayList<Question_Item> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public Question_Adapter.Question_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frequent_question_item,parent,false);
        Question_Adapter.Question_ViewHolder viewHolder = new  Question_Adapter.Question_ViewHolder(view);
        this.context =parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Question_Adapter.Question_ViewHolder holder, int position) {
        holder.Question_title.setText(mList.get(position).getTitle());
        holder.Question_contents.setText(mList.get(position).getContents());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0); }

}
