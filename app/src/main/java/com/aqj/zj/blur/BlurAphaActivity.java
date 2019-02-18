package com.aqj.zj.blur;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.aqj.zj.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * @description
 * @date: 2019/2/13 10:03
 * @author: zj
 */
public class BlurAphaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_apha);
        ImageView iv_blur_apha=findViewById(R.id.iv_blur_apha);
        LoadBlurAphaImage(iv_blur_apha);

    }

    String url="http://img.zcool.cn/community/01a63d573c82c26ac7253f9abc9688.jpg";


    private void LoadBlurAphaImage(ImageView imageView){
        Glide.with(BlurAphaActivity.this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .bitmapTransform(new PixBlurTransformation(this, 25, 1))
                .into(imageView);
    }
}