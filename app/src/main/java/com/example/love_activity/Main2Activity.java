package com.example.love_activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogn_zp);
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.iamge_show);
        imageView.setImageBitmap(readBitMap(this, R.drawable.zhaopian));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    private void show() {
        ObjectAnimator objectAnimator_scaleX = ObjectAnimator.ofFloat(imageView, "rotationX", 0, 180);
        ObjectAnimator objectAnimator_scaleY = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180);
//        ObjectAnimator touming = ObjectAnimator.ofFloat(imageView, "alpha", 1, 0, 1);
        objectAnimator_scaleX.setDuration(2000);
        objectAnimator_scaleY.setDuration(2000);
//        touming.setDuration(5000);
        objectAnimator_scaleX.setRepeatCount(1);
        objectAnimator_scaleY.setRepeatCount(1);
//        touming.setRepeatCount(1);
        objectAnimator_scaleX.start();
        objectAnimator_scaleY.start();
    }

    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
