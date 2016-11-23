package test.cyz.com.newsappone.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by M on 2016/11/22.
 */
public class NewsContentFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;


    public NewsContentFragmentAdapter(FragmentManager fm, List<Fragment> flist){
        super(fm);
        this.fragmentList = flist;
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
}



