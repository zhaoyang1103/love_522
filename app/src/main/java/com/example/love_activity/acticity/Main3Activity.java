package com.example.love_activity.acticity;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.love_activity.R;
import com.example.love_activity.bean.K_RotationBean;
import com.example.love_activity.model.ImageGlideView;
import com.example.love_activity.model.ImageGlideView_3;

import java.io.InputStream;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageGlideView show;
    private MediaPlayer mediaPlayer;
    private Button bt_return_black;
    private TextView tx_heishow;
    private ImageGlideView_3 show_2;
    private Button bt_return_white;
    private TextView tx_blackshow;
    private List<K_RotationBean> k_rotationBeans_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        show = (ImageGlideView) findViewById(R.id.show);
//        show.showImage(10);
        bt_return_black = (Button) findViewById(R.id.bt_return_black);
        bt_return_black.setOnClickListener(this);
        tx_heishow = (TextView) findViewById(R.id.tx_heishow);
        tx_heishow.setOnClickListener(this);
        show_2 = (ImageGlideView_3) findViewById(R.id.show_2);
        show_2.setOnClickListener(this);
        bt_return_white = (Button) findViewById(R.id.bt_return_white);
        bt_return_white.setOnClickListener(this);
        tx_blackshow = (TextView) findViewById(R.id.tx_blackshow);
        tx_blackshow.setOnClickListener(this);
        k_rotationBeans_list = show_2.getK_rotationBeans_list();
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
        mediaPlayer = MediaPlayer.create(Main3Activity.this, R.raw.fanshu);
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
                mediaPlayer = MediaPlayer.create(Main3Activity.this, R.raw.fanshu);
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

                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                Toast.makeText(Main3Activity.this, "进入到第二种游戏模式", Toast.LENGTH_SHORT).show();
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_return_black:
                return_Test();
                Toast.makeText(this, "呦吼", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_return_white:
                return_Test();
                Toast.makeText(this, "呦吼", Toast.LENGTH_SHORT).show();

                break;
        }
    }


    private void return_Test() {
//        k_rotationBeans_list = show_2.getK_rotationBeans_list();
        show_2.show(1,1);


    }
}
