package com.example.love_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private ImageGlideViewSt show_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }


    private void initView() {
        show_2 = (ImageGlideViewSt) findViewById(R.id.show_2);
    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
}
