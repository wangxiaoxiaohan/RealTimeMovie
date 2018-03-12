package example.wanghan.com.realtimemovie.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import example.wanghan.com.realtimemovie.R;

/**
 * Created by hs-acer on 2018/3/12.
 */

public class TransparentButtonView  extends RelativeLayout {

    public TransparentButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.transparentbuttonview,this);
    }


}
