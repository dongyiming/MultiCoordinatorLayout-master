package com.example.pver.coordinatorlayout_master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pver.coordinatorlayout_master.activity.AnimateFloadingActivity;
import com.example.pver.coordinatorlayout_master.activity.CardFlodingActivity;
import com.example.pver.coordinatorlayout_master.activity.NormalFloadingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.rlayout_normal).setOnClickListener(this);
        findViewById(R.id.rlayout_animate).setOnClickListener(this);
        findViewById(R.id.rlayout_card).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rlayout_normal:
                NormalFloadingActivity.start(MainActivity.this);
                break;
            case R.id.rlayout_animate:
                AnimateFloadingActivity.start(MainActivity.this);
                break;
            case R.id.rlayout_card:
                CardFlodingActivity.start(MainActivity.this);
                break;
        }
    }
}
