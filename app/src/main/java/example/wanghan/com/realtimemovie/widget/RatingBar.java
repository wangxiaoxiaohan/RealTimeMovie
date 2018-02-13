package example.wanghan.com.realtimemovie.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import example.wanghan.com.realtimemovie.R;

/**
 * Created by hs-acer on 2017/11/29.
 */
/**
  自定义打分View
 可以为任何形状。
  可以设定打分图形数量,，默认为5个。
 默认会将十分制得分转换为五分制。
 默认wrap_content
 */
public class RatingBar extends View {
    private  int starCount=0;
    private int starDistance=0;
    private  int startSize;
    private  float starMark=0.0f;//电影得分
    private Paint paint;

    private Bitmap fillStarBitmap;
    private Drawable emptyStarDrawable;


    public RatingBar(Context context) {
        super(context);

    }
    public RatingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        TypedArray mTypedArray=context.obtainStyledAttributes(attrs, R.styleable.RatingBar);
                  this.starCount=mTypedArray.getInt(R.styleable.RatingBar_starCount,5);
                  this.starDistance=mTypedArray.getInt(R.styleable.RatingBar_starDistance,8);
                  this.startSize= (int) mTypedArray.getDimension(R.styleable.RatingBar_starSize,15);
                  this.emptyStarDrawable=mTypedArray.getDrawable(R.styleable.RatingBar_starEmpty);
                  this.fillStarBitmap=DrawableToBitmap(mTypedArray.getDrawable(R.styleable.RatingBar_starFill));
        mTypedArray.recycle();
         paint=new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(fillStarBitmap,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP));
    }

    public RatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context,attrs);
    }


    private  Bitmap  DrawableToBitmap(Drawable drawable){
       if (drawable==null){
           return null;}
        Bitmap bitmap=Bitmap.createBitmap(startSize,startSize, Bitmap.Config.ARGB_8888);
        Canvas canvas =new Canvas(bitmap);//准备bitmap画布

        drawable.setBounds(0,0,startSize,startSize);
        drawable.draw(canvas);//将drawable 画bitmap画布上。
         return bitmap;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(startSize*starCount+starDistance*starCount,startSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (emptyStarDrawable==null||fillStarBitmap==null){
          return;
        }
        for(int i=0;i<starCount;i++){
            emptyStarDrawable.setBounds((starDistance+startSize)*i,0,(starDistance+startSize)*i+startSize,startSize);
            emptyStarDrawable.draw(canvas);//画空白星星。

        }
        if (starMark>1) {

            canvas.drawRect(0,0,startSize,startSize,paint);

            for (int i = 2; i <= starMark; i++) {
                 canvas.translate(startSize+starDistance,0);
                canvas.drawRect(0,0,startSize,startSize,paint);//

            }
             canvas.translate(startSize+starDistance,0);
             canvas.drawRect(0,0,(starMark-(int)starMark)*startSize,startSize,paint);

        }else{
            canvas.drawRect(0,0,starMark*startSize,startSize,paint);

        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    public  void  setStarMark(float mark){
        starMark=  mark/2;//得分转换为五星制。
        invalidate();

    }
}
