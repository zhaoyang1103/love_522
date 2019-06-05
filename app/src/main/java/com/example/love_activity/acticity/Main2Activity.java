package com.example.love_activity.acticity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.love_activity.R;
import com.example.love_activity.model.ImageGlideView2;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private ImageGlideView2 show_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }


    private void initView() {
        show_2 = (ImageGlideView2) findViewById(R.id.show_2);
    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
}
