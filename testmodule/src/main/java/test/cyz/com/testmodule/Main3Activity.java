package test.cyz.com.testmodule;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Main3Activity extends AppCompatActivity {

    String[] text = new String[]{"头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性"};
    List<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        ViewPager viewPager =(ViewPager)findViewById(R.id.viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.ac_tab_layout);
        init_TabFragment();
//        for(int i = 0; i < text.length; i++){
//            String cate = text[i];
//            TabLayout.Tab tab = tabLayout.newTab();
//            tabLayout.addTab(tab.setText(cate));
//        }
        tabLayout.setTabMode (TabLayout.MODE_SCROLLABLE);
        FragmentManager fm = getSupportFragmentManager();
        TabViewPagerAdaper tb = new TabViewPagerAdaper(fm, fragmentList, text);
        viewPager.setAdapter(tb);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void init_TabFragment(){
        for(int i = 0; i < text.length; i++){
            Fragment tabFragment = new TabFragment();
            fragmentList.add(tabFragment);
        }
    }
}
