package com.Carrie.habitter.HabitLog_today_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Carrie.habitter.R;

import java.util.ArrayList;

public class Habit_Item_Adapter extends  RecyclerView.Adapter<Habit_Item_Adapter.Habit_Item_ViewHolder>{

    private ArrayList<String> mList;
    Context context;

    // 리스너 인터페이스 정의하기
    public interface OnItemClickListener
    { void onItemClick(View v,int pos);}

    public interface OnItemLongClickListener
    {void onItemLongClick(View v,int pos);}

    // 전달된 객체 저장할 변수
    private Habit_Item_Adapter.OnItemClickListener mListener = null;
    private Habit_Item_Adapter.OnItemLongClickListener mListener2 = null;



    // 리스너 객체 전달 메서드
    public void setOnItemClickListener(OnItemClickListener listener)
    { this.mListener = listener; }

    public void setOnItemLongClickListener(OnItemLongClickListener listener)
    {this.mListener2 = listener;}



    public class Habit_Item_ViewHolder extends  RecyclerView.ViewHolder
    {
        protected TextView habit_title;

        public Habit_Item_ViewHolder(View view)
        {
            super(view);
            this.habit_title = view.findViewById(R.id.today_fm_habit_item);

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

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        mListener2.onItemLongClick(v,pos);
                    }
                    return false;
                }
            });
        }
    }

    public Habit_Item_Adapter(ArrayList<String> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public Habit_Item_Adapter.Habit_Item_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.today_fm_habit_item,parent,false);
        Habit_Item_Adapter.Habit_Item_ViewHolder viewHolder = new  Habit_Item_Adapter.Habit_Item_ViewHolder(view);
        this.context =parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Habit_Item_Adapter.Habit_Item_ViewHolder holder, int position) {

        Drawable drawable = context.getResources().getDrawable(R.drawable.round_background);

        holder.habit_title.setText(mList.get(position));

//        holder.habit_title.setBackgroundColor(mList.get(position).getHabit_color());
//        holder.habit_title.setBackgroundDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0); }
}
