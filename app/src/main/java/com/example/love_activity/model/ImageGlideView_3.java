package com.example.love_activity.model;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.love_activity.R;
import com.example.love_activity.bean.FinAll;
import com.example.love_activity.bean.Image_Bean;
import com.example.love_activity.bean.K_RotationBean;
import com.example.love_activity.st_test.OnAction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 昭阳 on 2019/5/22.
 */
public class ImageGlideView_3 extends LinearLayout implements OnAction {

    private ArrayList<ArrayList<Image_Bean>> imageViews_list = new ArrayList<>();
    private int a_time = 0;
    private List<K_RotationBean> k_rotationBeans_list = new ArrayList<>();
    private ArrayList<List<ImageView>> image_list = new ArrayList<>();

    public List<K_RotationBean> getK_rotationBeans_list() {
        return k_rotationBeans_list;
    }

    public void setK_rotationBeans_list(List<K_RotationBean> k_rotationBeans_list) {
        this.k_rotationBeans_list = k_rotationBeans_list;
    }

    public ImageGlideView_3(Context context) {
        super(context);

        addBean();
        showImage(FinAll.all, FinAll.image_all);

    }

    private MediaPlayer mediaPlayer;

    public ImageGlideView_3(Context context, AttributeSet attrs) {
        super(context, attrs);
        addBean();
        showImage(FinAll.all, FinAll.image_all);

    }

    public ArrayList<List<ImageView>> getImage_list() {
        return image_list;
    }

    public void setImage_list(ArrayList<List<ImageView>> image_list) {
        this.image_list = image_list;
    }

    private void showImage(int all, int single) {
        for (int i = 0; i < all; i++) {
            ArrayList<ImageView> sin_image = new ArrayList<>();
            for (int j = 0; j < single; j++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
                sin_image.add(imageView);
            }
            image_list.add(sin_image);
        }


        setOrientation(VERTICAL);
        removeAllViews();
        final ArrayList<ArrayList<Integer>> image_array = new ArrayList<>();
        for (int i = 0; i < all; i++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(HORIZONTAL);
            addView(linearLayout);
            ArrayList<Integer> image_single = new ArrayList<>();
            for (int j = 0; j < single; j++) {
                image_single.add(R.drawable.taoxin);
                final ImageView imageView = new ImageView(getContext());
                final int finalI = i;
                final int finalJ = j;
                linearLayout.addView(image_list.get(finalI).get(finalJ));
                image_list.get(finalI).get(finalJ).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
                image_list.get(finalI).get(finalJ).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (image_array.get(finalI).get(finalJ) != R.drawable.taoxin) {
                            Toast.makeText(getContext(), "此处以下,请点准点", Toast.LENGTH_SHORT).show();
                        } else {
                            if (a_time % 2 == 0) {
                                image_array.get(finalI).set(finalJ, FinAll.black_heart);
                                image_list.get(finalI).get(finalJ).setImageBitmap(readBitMap(getContext(), FinAll.black_heart));
                                k_rotationBeans_list.add(new K_RotationBean(finalI, finalJ));
                                a_time++;

                            } else {
                                image_array.get(finalI).set(finalJ, FinAll.white_heart);
                                image_list.get(finalI).get(finalJ).setImageBitmap(readBitMap(getContext(), FinAll.white_heart));
                                k_rotationBeans_list.add(new K_RotationBean(finalI, finalJ));
                                a_time++;
                            }
                        }


                    }
                });


            }
            image_array.add(image_single);

        }


    }


    private void addBean() {


    }


    private void normol(ImageView imageView) {
        ObjectAnimator objectAnimator_rotationY = ObjectAnimator.ofFloat(imageView, "rotationX", 0, 360f);
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

    public void show(int x, int y) {
        Log.i("历史储存", "show: "+k_rotationBeans_list.size());
        if (k_rotationBeans_list.size() > 0) {

            image_list.get(10).get(10).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
            image_list.get(9).get(9).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
            image_list.get(8).get(8).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
            image_list.get(7).get(7).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
            image_list.get(7).get(7).setImageBitmap(readBitMap(getContext(), R.drawable.taoxin));
        }
    }
}
