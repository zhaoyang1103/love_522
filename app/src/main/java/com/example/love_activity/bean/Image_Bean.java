package com.example.love_activity.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by 昭阳 on 2019/5/23.
 */
public class Image_Bean {
    private ImageView Imageview;
    private int image_drawable;

    public Image_Bean(Context context,ImageView imageview, int image_drawable) {
        Imageview = imageview;
        this.image_drawable = image_drawable;
        this.Imageview.setImageBitmap(readBitMap(context,image_drawable));
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
    public ImageView getImageview() {
        return Imageview;
    }

    public void setImageview(ImageView imageview) {
        Imageview = imageview;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }
}
