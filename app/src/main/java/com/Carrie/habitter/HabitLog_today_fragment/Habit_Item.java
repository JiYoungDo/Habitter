package com.Carrie.habitter.HabitLog_today_fragment;

import android.graphics.drawable.Drawable;

public class Habit_Item {
    private String habit_title;
    private int habit_color;

    public Habit_Item(String habit_title, int habit_color) {
        this.habit_title = habit_title;
        this.habit_color = habit_color;
    }

    public String getHabit_title() {
        return habit_title;
    }

    public void setHabit_title(String habit_title) {
        this.habit_title = habit_title;
    }

    public int getHabit_color() {
        return habit_color;
    }

    public void setHabit_color(int habit_color) {
        this.habit_color = habit_color;
    }
}
