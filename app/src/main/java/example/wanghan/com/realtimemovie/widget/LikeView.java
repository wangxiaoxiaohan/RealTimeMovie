package example.wanghan.com.realtimemovie.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import example.wanghan.com.realtimemovie.R;

/**
 * Created by hs-acer on 2017/12/23.
 */

public class LikeView extends LinearLayout {
    private  int Icon_size;
    private  float textSize;
    private ImageView imageView;
    private View pointView;
    private FrameLayout frameLayout;
    private  FrameLayout.LayoutParams params;
    private int LikeCount;
    private TextView textView;
    private  LinearLayout.LayoutParams countParam;

    public LikeView(Context context) {
        super(context);
    }
    public LikeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        TypedArray mTypeArray =context.obtainStyledAttributes(attrs, R.styleable.LikeView);
        Icon_size=mTypeArray.getDimensionPixelSize(R.styleable.LikeView_icon_size,(int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
        textSize=mTypeArray.getDimensionPixelSize(R.styleable.LikeView_likeCount_size,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                16, getResources().getDisplayMetrics()));
        mTypeArray.recycle();


        setOrientation(HORIZONTAL);
        //首先中添加一个FrameLayout；
        frameLayout=new FrameLayout(getContext());
        addView(frameLayout,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        //向FrameLayout中添加一个ImageView，用于放点赞的图
        imageView=new ImageView(getContext());
        imageView.setImageResource(R.drawable.dislike);
        imageView.setPadding(20,20,20,20);
        frameLayout.addView(imageView, Icon_size,Icon_size);

        //再向这个FrameLayout中添加十个小圆点，并居中。
        for (int i=0;i<12;i++){
            params=new FrameLayout.LayoutParams(10,10);
            params.gravity= Gravity.CENTER;
            pointView=new View(getContext());
            pointView.setBackgroundResource(R.drawable.circle);
            pointView.setAlpha(0f);
            frameLayout.addView(pointView,params);

        }

        countParam=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        countParam.gravity=Gravity.CENTER_VERTICAL;
        textView=new TextView(getContext());
        textView.setTextColor(Color.parseColor("#bfbfbf"));
        addView(textView,countParam);


        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setClickable(false);
                //大拇指图标缩放旋转动画。
                imageView.setImageResource(R.drawable.like);
                ObjectAnimator animator1=ObjectAnimator.ofFloat(imageView,"rotation",0f,-23f,23f,0);
                ObjectAnimator animator2=ObjectAnimator.ofFloat(imageView,"scaleX",1f,1.4f,1f);
                ObjectAnimator animator3=ObjectAnimator.ofFloat(imageView,"scaleY",1f,1.4f,1f);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(animator1).with(animator2).with(animator3);
                animatorSet.setDuration(350);
                animatorSet.start();
                //周围十二个小圆点的动画。
                for (int i=1;i<13;i++){
                    float baseDistance=frameLayout.getHeight()*2/5;
                    ObjectAnimator animatorX=ObjectAnimator.ofFloat(
                            frameLayout.getChildAt(i),"translationX",0, baseDistance*(float) (Math.cos(Math.PI*(i-1)/6)));
                    ObjectAnimator animatorY=ObjectAnimator.ofFloat(
                            frameLayout.getChildAt(i),"translationY",0,baseDistance*(float) (Math.sin(Math.PI*(i-1)/6)));
                    ObjectAnimator animatorA=ObjectAnimator.ofFloat(
                            frameLayout.getChildAt(i),"alpha",0,0.7f,0.8f,0.9f,1.0f,0f);
                    AnimatorSet animatorSetT=new AnimatorSet();
                    animatorSetT.setDuration(1100).play(animatorX).with(animatorY).with(animatorA);
                    animatorSetT.start();

                }
                /**
                 * 点击点赞数目增加逻辑，
                 * 如果点赞书目暂时为零，则不显示点赞数目，如果点击大拇指图标，则增加为1，并出现点赞数目。
                 * 如果点赞数目不为一。则显示点赞数目。同样点击增加点赞数目。
                 */
                textView.setVisibility(VISIBLE);
                LikeCount+=1;
                textView.setText(String.valueOf(LikeCount));

            }
        });

    }

    public LikeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
    public  void  setLikeCount(int count){
        LikeCount=count;
        textView.setText(String.valueOf(LikeCount));
        if (LikeCount==0){
            textView.setVisibility(GONE);
        }
    }

}