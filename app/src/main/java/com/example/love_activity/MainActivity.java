package com.example.love_activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageGlideView show;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        show = (ImageGlideView) findViewById(R.id.show);
//        show.showImage(10);
    }

    @Override
    public void onBackPressed() {

//        Intent intent = new Intent(this, Main2Activity.class);
//        startActivity(intent);

        showDailog();
//        super.onBackPressed();
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

    private void showDailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.dialogn_zp, null);
        final ImageView imageView = view.findViewById(R.id.iamge_show);
        imageView.setImageBitmap(readBitMap(this, R.drawable.zhaopian));
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.fanshu);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        ObjectAnimator objectAnimator_scaleY = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180f);
        ObjectAnimator pingyi = ObjectAnimator.ofFloat(imageView, "translationX", 0, 50, 0);

        pingyi.setDuration(500);
        pingyi.start();
        objectAnimator_scaleY.setDuration(500);
        objectAnimator_scaleY.start();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator objectAnimator_scaleY = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180f);
                ObjectAnimator pingyi = ObjectAnimator.ofFloat(imageView, "translationY", 0, -50, 0);

                pingyi.setDuration(500);
                pingyi.start();
                objectAnimator_scaleY.setDuration(500);

                objectAnimator_scaleY.start();


                mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.fanshu);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

            }
        });
        builder.setView(view);


        builder.setPositiveButton("进入新游戏", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Toast.makeText(MainActivity.this, "进入到第二种游戏模式", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });
        builder.setNegativeButton("退出程序", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();


    }


}
