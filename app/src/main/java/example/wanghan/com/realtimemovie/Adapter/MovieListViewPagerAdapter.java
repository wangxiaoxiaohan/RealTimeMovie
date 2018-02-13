package example.wanghan.com.realtimemovie.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hs-acer on 2017/11/30.
 */

public class MovieListViewPagerAdapter extends FragmentPagerAdapter {
    private  List<Fragment> fragments;
    public MovieListViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override//选写
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
