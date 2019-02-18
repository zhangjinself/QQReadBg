package com.aqj.zj.imagesize;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aqj.zj.R;


/**
 * @description 测试图片大小
 * @date: 2019/2/18 13:52
 * @author: zj
 */
public class ImageSizeActivity extends AppCompatActivity {


    /**
     * 整体布局
     */
    private LinearLayout rlBgLayout;
    /**
     * 局部布局
     */
    private LinearLayout llBlurLayout;

    private SeekBar seekBar;
    Bitmap newBitmap=null;
    TextView tv_scrori;
    TextView tv_scale;
    TextView tv_scrpoint;
    TextView tv_point;
    long scrori=0;
    long scale=0;
    long scrpoint=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagesize);
        rlBgLayout =  findViewById(R.id.rl_bg_layout);
        llBlurLayout =  findViewById(R.id.ll_blur_layout);
        seekBar=findViewById(R.id.seekbar);
        Button btn_show=findViewById(R.id.btn_show);
        tv_scrori=findViewById(R.id.tv_scrori);
        tv_scale=findViewById(R.id.tv_scale);
        tv_scrpoint =findViewById(R.id.tv_scrpoint);
        tv_point=findViewById(R.id.tv_point);

        newBitmap=getImageSize2(10);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBlurLayout.setBackground(new BitmapDrawable(newBitmap));
                tv_scrori.setText("原始大小："+scrori);
                tv_scale.setText("缩放大小："+scale);
                tv_point.setText("原始比例："+scrpoint);
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>0) {
                    newBitmap=getImageSize2(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    /**
     * 根据缩放比例来改变图片大小
     * @param scall
     * @return
     */
    private Bitmap getImageSize2(int scall){
        scrpoint=scall;
        Bitmap srcBitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        scrori=srcBitmap.getByteCount();

        Bitmap newBitmap =Bitmap.createBitmap(
                srcBitmap.getWidth()/scall,srcBitmap.getHeight()/scall, Bitmap.Config.ARGB_8888);
        Canvas canvas =new Canvas(newBitmap);
        //同时缩放会显示原图大小
        canvas.scale((1f/scall),(1f/scall));
        canvas.drawBitmap(srcBitmap,0,0,new Paint());
        scale=newBitmap.getByteCount();
        return newBitmap;
    }

}
