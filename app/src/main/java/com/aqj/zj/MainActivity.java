package com.aqj.zj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aqj.zj.blur.BlurActivity;
import com.aqj.zj.blur.BlurAphaActivity;
import com.aqj.zj.imagesize.ImageSizeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_blur = findViewById(R.id.btn_blur);
        btn_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,BlurActivity.class);
                startActivity(intent);
            }
        });

        Button btn_blur_apha = findViewById(R.id.btn_blur_apha);
        btn_blur_apha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,BlurAphaActivity.class);
                startActivity(intent);
            }
        });

        Button btn_size = findViewById(R.id.btn_size);
        btn_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ImageSizeActivity.class);
                startActivity(intent);
            }
        });

    }

}
