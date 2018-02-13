package example.wanghan.com.realtimemovie.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.wanghan.com.realtimemovie.R;

/**
 * Created by hs-acer on 2017/12/10.
 */

public class expandableTextView extends LinearLayout {
    private TextView textView;
    private ImageView imageView;
    private  int textColor;
    private  int textSize;
    private  int maxLine;
    private  String text;
    private  int defaultColor= Color.BLACK;
    private  int defaultTextSize=12;
    private  int defaultMaxLine=5;
    public expandableTextView(Context context) {
        this(context,null);
    }

    public expandableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public expandableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        //设置布局，并添加textview 和imageview
        setOrientation(VERTICAL);
        setGravity(Gravity.END);
        textView=new TextView(getContext());
        addView(textView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        imageView=new ImageView(getContext());
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(R.drawable.ic_expand);
        addView(imageView, 50, 50);
         //获取自定义属性
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.expandableTextView);
        textColor=a.getColor(R.styleable.expandableTextView_textColor,defaultColor);
        textSize=a.getDimensionPixelSize(R.styleable.expandableTextView_textSize,defaultTextSize);
        maxLine=a.getInt(R.styleable.expandableTextView_maxLine,defaultMaxLine);
        text=a.getString(R.styleable.expandableTextView_text);
        a.recycle();
         //将获取到的属性设置给textview
        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setMaxLines(maxLine);
        textView.setTextColor(textColor);
        //若文字行数小于最大行数，则隐藏择叠按钮。
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.setVisibility(textView.getLineCount()>maxLine?View.VISIBLE:View.GONE);
                setClickable(textView.getLineCount()>maxLine?true:false);
            }
        });
       //设置监听动画。
        setOnClickListener(new OnClickListener() {
            boolean isExpand;//
            @Override
            public void onClick(View v) {
                isExpand = !isExpand;
                textView.clearAnimation();
                final int deltaValue;
                final int startValue = textView.getHeight();
                int durationMillis = 200;
                 //设置三角下拉按钮的动画，因为处于linearlayout中 所以不需要给它添加位移动画，
                // 只要textview 高度变化了 他就会自动位移到textview的下面。

                if (isExpand) {
                    deltaValue = textView.getLineHeight() * textView.getLineCount() - startValue;//
                    //若为未展开状态，则此值为正，textview 高度 从低到高。
                    //
                    RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    imageView.startAnimation(animation);
                } else {
                    deltaValue = textView.getLineHeight() * maxLine - startValue;//若为展开状态，则此值为负值，那么下面的textview外、高度动画
                    //就是从高到低。
                    RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    imageView.startAnimation(animation);
                }
                //textview的动画
                Animation animation = new Animation() {
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        textView.setHeight((int) (startValue + deltaValue * interpolatedTime));
                    }

                };
                animation.setDuration(durationMillis);
                textView.startAnimation(animation);
            }
        });

    }
//对外提供的设置文本文字的方法。
    public   void  setText(String string){
        textView.setText(string);
}
}
