package com.aqj.zj.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

/**
 * @description
 * @date: 2019/2/12 18:38
 * @author: zj
 */
public class PixBlurTransformation implements Transformation<Bitmap> {

    private static int MAX_RADIUS = 25;
    private static int DEFAULT_DOWN_SAMPLING = 1;

    private Context mContext;
    private BitmapPool mBitmapPool;

    private int mRadius;
    private int mSampling;

    public PixBlurTransformation(Context context) {
        this(context, Glide.get(context).getBitmapPool(), MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public PixBlurTransformation(Context context, BitmapPool pool) {
        this(context, pool, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public PixBlurTransformation(Context context, BitmapPool pool, int radius) {
        this(context, pool, radius, DEFAULT_DOWN_SAMPLING);
    }

    public PixBlurTransformation(Context context, int radius) {
        this(context, Glide.get(context).getBitmapPool(), radius, DEFAULT_DOWN_SAMPLING);
    }

    public PixBlurTransformation(Context context, int radius, int sampling) {
        this(context, Glide.get(context).getBitmapPool(), radius, sampling);
    }

    public PixBlurTransformation(Context context, BitmapPool pool, int radius, int sampling) {
        mContext = context.getApplicationContext();
        mBitmapPool = pool;
        mRadius = radius;
        mSampling = sampling;
    }

    @Override
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
        Bitmap source = resource.get();

        int width = source.getWidth();
        int height = source.getHeight();
        int scaledWidth = width / mSampling;
        int scaledHeight = height / mSampling;

        Bitmap originBitmap = mBitmapPool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        if (originBitmap == null) {
            originBitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(originBitmap);
        canvas.scale(1f, 1f);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(source, 0, 0, paint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            try {
                originBitmap = RSBlur.blur(mContext, originBitmap, mRadius);
            } catch (RSRuntimeException rSRuntimeException) {
                originBitmap = FastBlur.blur(originBitmap, mRadius, true);
            }
        } else {
            originBitmap = FastBlur.blur(originBitmap, mRadius, true);
        }
        originBitmap=getBitmap(originBitmap);
        return BitmapResource.obtain(originBitmap, mBitmapPool);
    }

    @Override public String getId() {
        return "BlurTransformation(radius=" + mRadius + ", sampling=" + mSampling + ")";
    }

    private Bitmap getBitmap(Bitmap newBitmap){
        int w=newBitmap.getWidth();
        int h=newBitmap.getHeight();
        int[] pix = new int[w*h];
        newBitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int val =pix.length/100;
        int a=0x00ffffff;
        for(int x=0;x<pix.length; x++){
            if(x>=val*99)
            {
                a=0x01ffffff;
            }else if(x>val*98)
            {
                a=0x02ffffff;
            }
            else if(x>val*97)
            {
                a=0x03ffffff;
            }

            else if(x>val*96)
            {
                a=0x04ffffff;
            }

            else if(x>val*95)
            {
                a=0x05ffffff;
            }

            else if(x>val*94)
            {
                a=0x06ffffff;
            }

            else if(x>val*93)
            {
                a=0x07ffffff;
            }

            else if(x>val*92)
            {
                a=0x08ffffff;
            }

            else if(x>val*91)
            {
                a=0x09ffffff;
            }
            else if(x>val*90)
            {
                a=0x0affffff;
            }
            else if(x>val*89)
            {
                a=0x0bffffff;
            }
            else if(x>val*88)
            {
                a=0x0cffffff;
            }
            else if(x>val*87)
            {
                a=0x0dffffff;
            }
            else if(x>val*86)
            {
                a=0x0effffff;
            }
            else if(x>val*85)
            {
                a=0x0fffffff;
            }
            else if(x>val*84)
            {
                a=0x10ffffff;
            }
            else if(x>val*83)
            {
                a=0x11ffffff;
            }
            else if(x>val*82)
            {
                a=0x12ffffff;
            }
            else if(x>val*81)
            {
                a=0x13ffffff;
            }
            else if(x>val*80)
            {
                a=0x14ffffff;
            }

            else if(x>val*79)
            {
                a=0x15ffffff;
            }
            else if(x>val*78)
            {
                a=0x16ffffff;
            }
            else if(x>val*77)
            {
                a=0x17ffffff;
            }
            else if(x>val*76)
            {
                a=0x18ffffff;
            }
            else if(x>val*75)
            {
                a=0x19ffffff;
            }
            else if(x>val*74)
            {
                a=0x1affffff;
            }
            else if(x>val*73)
            {
                a=0x1bffffff;
            }
            else if(x>val*72)
            {
                a=0x1cffffff;
            }
            else if(x>val*71)
            {
                a=0x1dffffff;
            }
            else if(x>val*70)
            {
                a=0x1effffff;
            }

            else if(x>val*69)
            {
                a=0x1fffffff;
            }
            else if(x>val*68)
            {
                a=0x20ffffff;
            }
            else if(x>val*67)
            {
                a=0x21ffffff;
            }
            else if(x>val*66)
            {
                a=0x22ffffff;
            }
            else if(x>val*65)
            {
                a=0x23ffffff;
            }
            else if(x>val*64)
            {
                a=0x24ffffff;
            }
            else if(x>val*63)
            {
                a=0x25ffffff;
            }
            else if(x>val*62)
            {
                a=0x26ffffff;
            }
            else if(x>val*61)
            {
                a=0x27ffffff;
            }
            else if(x>val*60)
            {
                a=0x28ffffff;
            }

            else if(x>val*59)
            {
                a=0x29ffffff;
            }
            else if(x>val*58)
            {
                a=0x2affffff;
            }
            else if(x>val*57)
            {
                a=0x2bffffff;
            }
            else if(x>val*56)
            {
                a=0x2cffffff;
            }
            else if(x>val*55)
            {
                a=0x2dffffff;
            }
            else if(x>val*54)
            {
                a=0x2effffff;
            }
            else if(x>val*53)
            {
                a=0x2fffffff;
            }
            else if(x>val*52)
            {
                a=0x30ffffff;
            }
            else if(x>val*51)
            {
                a=0x31ffffff;
            }
            else if(x>val*50)
            {
                a=0x32ffffff;
            }

            else if(x>val*49)
            {
                a=0x33ffffff;
            }
            else if(x>val*48)
            {
                a=0x34ffffff;
            }
            else if(x>val*47)
            {
                a=0x35ffffff;
            }
            else if(x>val*46)
            {
                a=0x36ffffff;
            }
            else if(x>val*45)
            {
                a=0x37ffffff;
            }
            else if(x>val*44)
            {
                a=0x38ffffff;
            }
            else if(x>val*43)
            {
                a=0x39ffffff;
            }
            else if(x>val*42)
            {
                a=0x3affffff;
            }
            else if(x>val*41)
            {
                a=0x3bffffff;
            }
            else if(x>val*40)
            {
                a=0x3cffffff;
            }

            else if(x>val*39)
            {
                a=0x3dffffff;
            }
            else if(x>val*38)
            {
                a=0x3effffff;
            }
            else if(x>val*37)
            {
                a=0x3fffffff;
            }
            else if(x>val*36)
            {
                a=0x40ffffff;
            }
            else if(x>val*35)
            {
                a=0x41ffffff;
            }
            else if(x>val*34)
            {
                a=0x42ffffff;
            }
            else if(x>val*33)
            {
                a=0x43ffffff;
            }
            else if(x>val*32)
            {
                a=0x44ffffff;
            }
            else if(x>val*31)
            {
                a=0x45ffffff;
            }
            else if(x>val*30)
            {
                a=0x46ffffff;
            }

            else if(x>val*29)
            {
                a=0x47ffffff;
            }
            else if(x>val*28)
            {
                a=0x48ffffff;
            }
            else if(x>val*27)
            {
                a=0x49ffffff;
            }
            else if(x>val*26)
            {
                a=0x4affffff;
            }
            else if(x>val*25)
            {
                a=0x4bffffff;
            }
            else if(x>val*24)
            {
                a=0x4cffffff;
            }
            else if(x>val*23)
            {
                a=0x4dffffff;
            }
            else if(x>val*22)
            {
                a=0x4effffff;
            }
            else if(x>val*21)
            {
                a=0x4fffffff;
            }
            else if(x>val*20)
            {
                a=0x50ffffff;
            }

            else if(x>val*19)
            {
                a=0x51ffffff;
            }
            else if(x>val*18)
            {
                a=0x52ffffff;
            }
            else if(x>val*17)
            {
                a=0x53ffffff;
            }
            else if(x>val*16)
            {
                a=0x54ffffff;
            }
            else if(x>val*15)
            {
                a=0x55ffffff;
            }
            else if(x>val*14)
            {
                a=0x56ffffff;
            }
            else if(x>val*13)
            {
                a=0x57ffffff;
            }
            else if(x>val*12)
            {
                a=0x58ffffff;
            }
            else if(x>val*11)
            {
                a=0x59ffffff;
            }
            else if(x>val*10)
            {
                a=0x5affffff;
            }

            else if(x>=val*9)
            {
                a=0x5bffffff;
            }
            else if(x>=val*8)
            {
                a=0x5cffffff;
            }
            else if(x>=val*7)
            {
                a=0x5dffffff;
            }
            else if(x>=val*6)
            {
                a=0x5effffff;
            }
            else if(x>=val*5)
            {
                a=0x5fffffff;
            }
            else if(x>=val*4)
            {
                a=0x60ffffff;
            }
            else if(x>=val*3)
            {
                a=0x61ffffff;
            }
            else if(x>=val*2)
            {
                a=0x62ffffff;
            }
            else if(x>=val*1)
            {
                a=0x63ffffff;
            }
            else if(x>=val*0)
            {
                a=0x64ffffff;
            }
            pix[x]=pix[x] & a;
        }

        newBitmap.setPixels(pix,0, w, 0, 0, w, h);
        return newBitmap;
    }
}
