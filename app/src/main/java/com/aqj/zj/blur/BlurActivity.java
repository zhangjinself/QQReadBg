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
 * @date: 2019/2/12 17:00
 * @author: zj
 */
public class BlurActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        ImageView iv_blur=findViewById(R.id.iv_blur);
        ImageView iv_normal=findViewById(R.id.iv_normal);

        LoadNormalImage(iv_normal);

        LoadBlurImage(iv_blur);

    }

    String url="http://img.zcool.cn/community/01a63d573c82c26ac7253f9abc9688.jpg";
    private void LoadNormalImage(ImageView imageView){

        Glide.with(BlurActivity.this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    private void LoadBlurImage(ImageView imageView){
        Glide.with(BlurActivity.this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .bitmapTransform(new BlurTransformation(this, 25, 1))
                .into(imageView);
    }

}
