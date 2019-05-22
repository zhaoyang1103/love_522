package com.example.love_activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;

/**
 * Created by 昭阳 on 2019/5/22.
 */
public class ImageGlideView extends LinearLayout {
    public ImageGlideView(Context context) {
        super(context);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.pp);
        showImage(37);

    }

    private int[] image = new int[]{R.drawable.itaoxin, R.drawable.ltaoxin, R.drawable.otaoxin, R.drawable.vtaoxin, R.drawable.etaoxin, R.drawable.youtaoxin};
    private MediaPlayer mediaPlayer;

    public ImageGlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        showImage(37);

    }

    public void showImage(int count) {
        setOrientation(VERTICAL);
        for (int i = 0; i < count; i++) {
            final LinearLayout linearLayout = new LinearLayout(getContext());
            addView(linearLayout);
            for (int j = 0; j < 22; j++) {
                final ImageView imageView = new ImageView(getContext());
                imageView.setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));

                linearLayout.addView(imageView);
//                scal(imageView);
                final int finalJ = j;
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setImageBitmap(readBitMap(getContext(), image[finalJ % 6]));
                        if (finalJ == 7 || finalJ == 19) {
                            ObjectAnimator line_xuanzhuan_line = ObjectAnimator.ofFloat(linearLayout, "rotationY", 0, 360f);
                            line_xuanzhuan_line.setDuration(2000);
//                            line_xuanzhuan_line.setRepeatCount(1);
                            line_xuanzhuan_line.start();
                            mediaPlayer = new MediaPlayer();
                            mediaPlayer = MediaPlayer.create(getContext(), R.raw.fanshu);
                            mediaPlayer.start();
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp.release();
                                }
                            });
                        }
                        if (finalJ == 6 || finalJ == 12 || finalJ == 18) {
                            ObjectAnimator line_xuanzhuan_line = ObjectAnimator.ofFloat(linearLayout, "rotationX", 0, 360f);
                            line_xuanzhuan_line.setDuration(200);
                            line_xuanzhuan_line.setRepeatCount(10);
                            line_xuanzhuan_line.start();
                            mediaPlayer = new MediaPlayer();
                            mediaPlayer = MediaPlayer.create(getContext(), R.raw.fanshu);
                            mediaPlayer.start();
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp.release();
                                }
                            });
                        } else {
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
        ObjectAnimator doudong = ObjectAnimator.ofFloat(imageView, "scaleX", 1,2, 1);
        doudong.setRepeatCount(1000000000);
        doudong.setDuration(10);
        doudong.start();
        ObjectAnimator doudongY = ObjectAnimator.ofFloat(imageView, "scaleY", 1, 2, 1);
        doudongY.setRepeatCount(1000000000);
        doudongY.setDuration(10);
        doudongY.start();
    }
}
