package test.cyz.com.newsappone.fragment;


import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.adapter.NewsContentFragmentAdapter;
import test.cyz.com.newsappone.domain.News;
import test.cyz.com.newsappone.util.BaseTools;
import test.cyz.com.newsappone.util.HttpUtil;
import test.cyz.com.newsappone.util.HttpsCallbackListener;

public class NewsFragment extends Fragment {

    LinearLayout ly_items;
    //新闻标题集合
    List<String> listItems = new ArrayList<String>();
    HorizontalScrollView horizontalScrollView;
    int itemSelectIndex;
    LinearLayout ly_newsFrag;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private int currentIndex = 0;
    private  int AfLeft;
    private int BeLeft;
    private int screenWidth;
    private TabLayout tabLayout;

    public NewsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final Handler handler = new Handler();
        ly_newsFrag = (LinearLayout) inflater.inflate(R.layout.fragment_news, container, false);
//        ly_items = (LinearLayout) ly_newsFrag.findViewById(R.id.ly_items);
//        horizontalScrollView = (HorizontalScrollView) ly_newsFrag.findViewById(R.id.scroll);
        viewPager = (ViewPager)ly_newsFrag.findViewById(R.id.viewpager);
        tabLayout = (TabLayout)ly_newsFrag.findViewById(R.id.tabLayout);
        tabLayout.setTabMode (TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        screenWidth = BaseTools.getWindowsWidth(getActivity());

        initNewsCategory();
//         init_newsItem();
        initContentFragment();
        FragmentManager fm = getFragmentManager();
        NewsContentFragmentAdapter fpAdapter = new NewsContentFragmentAdapter(fm, fragmentList, listItems);
        viewPager.setAdapter(fpAdapter);
        tabLayout.setupWithViewPager(viewPager);
//        viewPager.setCurrentItem(0);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                final TextView selectBe = (TextView) ly_items.getChildAt(currentIndex);
//                selectBe.setTextColor(Color.BLACK);
//                selectBe.setTextSize(20);
//                currentIndex = position;
//                final TextView selectAf = (TextView) ly_items.getChildAt(currentIndex);
//                selectAf.setTextColor(Color.RED);
//                selectAf.setTextSize(25);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        AfLeft = selectAf.getLeft();
//                        BeLeft = selectBe.getLeft();
//                    }
//
//                });
//                //
//                int dis = AfLeft - BeLeft;
//                if( dis >= 0 ){
//                    horizontalScrollView.smoothScrollBy(dis, 0);
//                }
//                else{
//                    horizontalScrollView.smoothScrollBy(dis, 0);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Log.d("aaa", String.valueOf(position));
//                System.out.print(String.valueOf(position));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        return ly_newsFrag;

    }

//    private void init_newsItem(){
//        ly_items.removeAllViews();
//        int count = listItems.size();
//        for(int i = 0; i < count; i++){
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.leftMargin = 25;
//            params.rightMargin = 25;
//            final TextView tv_items = new TextView(this.getActivity());
//            tv_items.setGravity(Gravity.CENTER);
//            tv_items.setPadding(5,5,5,5);
//            tv_items.setId(i);
//            tv_items.setText(listItems.get(i));
//            tv_items.setTextColor(Color.BLACK);
//            tv_items.setTextSize(20);
//
//            tv_items.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                   for(int i = 0; i < ly_items.getChildCount(); i++)
//                   {
//                       View selectView = ly_items.getChildAt(i);
//                       if(selectView == view){
//
//                           TextView selectBefore = (TextView) ly_items.getChildAt(currentIndex);
//                           selectBefore.setTextColor(Color.BLACK);
//                           selectBefore.setTextSize(20);
//                           currentIndex = i;
//                           TextView selectAfter = (TextView)view;
//                           selectAfter.setTextColor(Color.RED);
//                           selectAfter.setTextSize(25);
//                           viewPager.setCurrentItem(i);
//
//                       }
//
//                   }
//
//                }
//            });
//            ly_items.addView(tv_items, i, params);
//        }
//    }

    private void initNewsCategory() {
        String[] text = new String[]{"头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性"};
        for(int i = 0; i < text.length; i++){
            listItems.add(text[i]);
        }
    }

    private void initContentFragment(){
        for(int i = 0; i < listItems.size(); i++){
            Fragment newsContent = new NewsContentFragment();
            fragmentList.add(newsContent);
        }
    }

}
