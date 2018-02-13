package example.wanghan.com.realtimemovie.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;


import example.wanghan.com.realtimemovie.R;

/**
 * Created by hs-acer on 2017/12/24.
 */

public class CircleImageView extends AppCompatImageView {
    private Paint mPaint;
    private Bitmap mBitmap;
    private  int Width;
    private  int mRadius;
    private  float scaleX=1.0f;
     private  float scaleY=1.0f;
    private BitmapShader mBitmapShader;
    private Matrix mMatrix;


    public CircleImageView(Context context) {

    super(context);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypeArray=context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);
         Width=mTypeArray.getDimensionPixelSize(R.styleable.CircleImageView_Width,(int) TypedValue.applyDimension(
                 TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
        // mBitmap=DrawableToBitmap(mTypeArray.getDrawable(R.styleable.CircleImageView_image));
         mTypeArray.recycle();



    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRadius=Width/2;
        setMeasuredDimension(Width,Width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap!=null) { //这个不能重用啊！！！！
            mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mMatrix = new Matrix();

            // int bSize = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
            scaleX = Width * 1.0f / mBitmap.getWidth();
            scaleY = Width * 1.0f / mBitmap.getHeight();

            //核心 画笔bitmapShader的矩阵变换。
            mMatrix.setScale(scaleX, scaleY);
            // 设置变换矩阵
            mBitmapShader.setLocalMatrix(mMatrix);
            // 设置shader
            mPaint.setShader(mBitmapShader);
           canvas.drawCircle(mRadius,mRadius,mRadius,mPaint);

        }

    }

    private  Bitmap  DrawableToBitmap(Drawable drawable){
        if (drawable==null){
            return null;}
        int w=drawable.getIntrinsicWidth();
        int h=drawable.getIntrinsicHeight();
        Bitmap bitmap=Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        Canvas canvas =new Canvas(bitmap);//准备bitmap画布
        drawable.setBounds(0,0,w,h);
        drawable.draw(canvas);//将drawable 画bitmap画布上。
        return bitmap;
    }

    public  void setmDrawable(Drawable drawable){//把这个方法留在Glide的Listener的OnResourceReady方法中调用。
          mBitmap=DrawableToBitmap(drawable);
          invalidate();
    }

}
