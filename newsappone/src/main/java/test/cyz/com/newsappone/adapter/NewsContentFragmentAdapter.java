package test.cyz.com.newsappone.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import test.cyz.com.newsappone.domain.News;

/**
 * Created by M on 2016/11/22.
 */
public class NewsContentFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> newsItems;

    public NewsContentFragmentAdapter(FragmentManager fm, List<Fragment> flist, List<String>newsItems){
        super(fm);
        this.fragmentList = flist;
        this.newsItems = newsItems;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return newsItems.get(position);
    }
}



