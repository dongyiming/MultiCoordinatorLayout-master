package com.example.pver.coordinatorlayout_master;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/8/11 3:11
 */
public class ImageUtils {

    public static void changeLight(ImageView imageView, int brightness) {
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{1, 0, 0, 0, brightness, 0, 1, 0, 0, brightness, // 改变亮度
                0, 0, 1, 0, brightness, 0, 0, 0, 1, 0});
        imageView.setColorFilter(new ColorMatrixColorFilter(cMatrix));
    }

    public static void setFilter(ImageView imageView, int filterColor) {
        //先获取设置的src图片
        Drawable drawable = imageView.getDrawable();
        //当src图片为Null，获取背景图片
        if (drawable == null) {
            drawable = imageView.getBackground();
        }
        if (drawable != null) {
            //设置滤镜
            drawable.setColorFilter(filterColor, PorterDuff.Mode.DARKEN);
        }
    }

    /**
     * 清除滤镜
     */
    public static void removeFilter(ImageView imageView) {
        //先获取设置的src图片
        Drawable drawable = imageView.getDrawable();
        //当src图片为Null，获取背景图片
        if (drawable == null) {
            drawable = imageView.getBackground();
        }
        if (drawable != null) {
            //清除滤镜
            drawable.clearColorFilter();
        }
    }
}
