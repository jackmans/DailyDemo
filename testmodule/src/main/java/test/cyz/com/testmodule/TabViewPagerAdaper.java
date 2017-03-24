package test.cyz.com.testmodule;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by M on 2016/11/29.
 */
public class TabViewPagerAdaper extends FragmentPagerAdapter{

    private List<Fragment> pagerList;
    private String[] tabArray;

    public TabViewPagerAdaper(FragmentManager fm, List pagerList, String[] text){
        super(fm);
        this.pagerList = pagerList;
        this.tabArray = text;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerList.get(position);
    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabArray[position];
    }
}
