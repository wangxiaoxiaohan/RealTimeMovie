package example.wanghan.com.realtimemovie.Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by hs-acer on 2017/11/28.
 */

public class SlidePictureViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> imageViewLists;
    public SlidePictureViewPagerAdapter(ArrayList<ImageView> imageViewList) {
        this.imageViewLists=imageViewList;
    }

    @Override
    public int getCount()
    {
        return 5000000;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //此处不写 ，解决左滑空白问题。
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition=position % imageViewLists.size();
        ImageView imageView =imageViewLists.get(newPosition);

        ViewParent vp =imageView.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(imageView);
        }

        container.addView(imageView);
        return imageView;
    }
}