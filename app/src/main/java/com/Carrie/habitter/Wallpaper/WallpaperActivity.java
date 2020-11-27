package com.Carrie.habitter.Wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.Carrie.habitter.R;

public class WallpaperActivity extends AppCompatActivity {

    TextView go_analysis_or_main_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        go_analysis_or_main_btn = findViewById(R.id.wallpaper_tv_go_to_analysis);

    }
}
