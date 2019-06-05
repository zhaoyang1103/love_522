package com.example.love_activity.model;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.love_activity.bean.FinAll;
import com.example.love_activity.R;
import com.example.love_activity.st_test.OnAction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 昭阳 on 2019/5/22.
 */
public class ImageGlideView2 extends LinearLayout implements OnAction {

    private ArrayList<ImageView> imageViews_list = new ArrayList<>();

    public ImageGlideView2(Context context) {
        super(context);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.pp);
        showImage(FinAll.all);

    }

    private int[] image = new int[]{R.drawable.taoxin, R.drawable.zong, R.drawable.lv, R.drawable.lan, R.drawable.qianzi, R.drawable.huang,
            R.drawable.shenlan,
            R.drawable.cheng,
            R.drawable.hui,
            R.drawable.zi,
            R.drawable.zhonglv,
            R.drawable.yingguang,
            R.drawable.yin,};
    private MediaPlayer mediaPlayer;

    public ImageGlideView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        showImage(FinAll.all);

    }


    public void showImage(int count) {
        final Random random = new Random();
        setOrientation(VERTICAL);
        for (int i = 0; i < count; i++) {
            final LinearLayout linearLayout = new LinearLayout(getContext());
            addView(linearLayout);
            for (int j = 0; j < FinAll.image_all; j++) {
                final ImageView imageView = new ImageView(getContext());
                imageView.setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
                imageViews_list.add(imageView);
                linearLayout.addView(imageView);
//                scal(imageView);
                final int finalJ = j;
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        imageView.setImageBitmap(readBitMap(getContext(), image[random.nextInt(image.length)]));
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.pp);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });
//                        mediaPlayer.setListener
//                        SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_SYSTEM, 5);
//                        int load = soundPool.load(getContext(), R.raw.pp, 1);
//                        soundPool.play(load, 1, 1, 0, 0, 1);

                        normol(imageView);

                    }
                });
                imageView.setOnLongClickListener(new OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        for (int k = 0; k < FinAll.show_all; k++) {
                            int i1 = random.nextInt(imageViews_list.size());
                         ;
                            imageViews_list.get(i1).setImageBitmap(readBitMap(getContext(), image[random.nextInt(image.length)]));
                            normol( imageViews_list.get(i1));
                        }


                        return false;
                    }
                });


            }

        }


    }

    private void normol(ImageView imageView) {
        ObjectAnimator objectAnimator_rotationY = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 360f);
        ObjectAnimator objectAnimator_transY = ObjectAnimator.ofFloat(imageView, "translationY", 0, -10, 0);
        ObjectAnimator objectAnimator_scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0, 2, 1);
        ObjectAnimator objectAnimator_scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 2, 1);
        objectAnimator_scaleX.setDuration(1000);
//                        objectAnimator_scaleX.setRepeatCount(1);
        objectAnimator_scaleX.start();
        objectAnimator_scaleY.setDuration(1000);
//                        objectAnimator_scaleY.setRepeatCount(1);
        objectAnimator_scaleY.start();

        objectAnimator_rotationY.setDuration(1000);
//                        objectAnimator_rotationY.setRepeatCount(1);
        objectAnimator_rotationY.start();
        objectAnimator_transY.setDuration(1000);
//                        objectAnimator_transY.setRepeatCount(1);
        objectAnimator_transY.start();
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


    private void scal(ImageView imageView) {
        ObjectAnimator doudong = ObjectAnimator.ofFloat(imageView, "scaleX", 1, 2, 1);
        doudong.setRepeatCount(1000000000);
        doudong.setDuration(10);
        doudong.start();
        ObjectAnimator doudongY = ObjectAnimator.ofFloat(imageView, "scaleY", 1, 2, 1);
        doudongY.setRepeatCount(1000000000);
        doudongY.setDuration(10);
        doudongY.start();
    }

    @Override
    public void onClick() {

    }
}
