package test.cyz.com.jmnews;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by M on 2016/8/31.
 */
public class ScrollActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    GridView gridView;
    private ArrayList<String> catelist = new ArrayList<String>();
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private FragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private View selectView;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.page_layout);
        Log.d("gridView", "主布局中的linearlayout：" + linearLayout.toString());
        LinearLayout ly_listitem = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.lv_listitem, null);
        Log.d("gridView", "ViewPager的父布局:" + ly_listitem.toString());
        viewPager = (ViewPager) ly_listitem.findViewById(R.id.vp_myViePage);
        Log.d("gridView", "viewPager的父布局：" + viewPager.getParent().toString());

        linearLayout.addView(ly_listitem);
        Log.d("gridView", "viewPager的父布局的父布局：" + ly_listitem.getParent().toString());
//        Fragment fragment = new MyFragment1();
//        Fragment fragment2 = new MyFragment2();
//        fragmentList.add(fragment);
//        fragmentList.add(fragment2);
//        Fragment fragment = new ContentFragment();
//        fragmentList.add(fragment);
//        gridView = (GridView) findViewById(R.id.gridView);

        initCategory();
////        Fragment my1 = new MyFragment1();
////        Fragment my2 = new MyFragment2();
////        fragmentList.add(my1);
////        fragmentList.add(my2);
//        pagerAdapter = new NewsAdapter(getSupportFragmentManager(), fragmentList);
//        viewPager.setAdapter(pagerAdapter);
        initFragment();
        Log.d("gridView", "init Fragment");

//        setGridView();

//        CategoryAdapter adapter = new CategoryAdapter(this, R.layout.lv_listitem, catelist);
//        gridView.setAdapter(adapter);



//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //点击导航栏上的按钮，跳到想对应的fragment页面
//                TextView textView = (TextView) view.findViewById(R.id.category_item);
//                textView.setTextColor(Color.RED);
//                viewPager.setCurrentItem(i);
//            }
//        });




    }

    private void initCategory(){
        String[] text = new String[]{"头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性"};
        for(int i = 0; i < text.length; i++){
            String string = text[i];
            catelist.add(string);
            Log.d("gridView", catelist.toString());
        }
//         categoryAdapter = new CategoryAdapter(this, R.layout.lv_listitem, catelist);
//         gridView.setAdapter(categoryAdapter);
    }

    private void setGridView(){
        int size = catelist.size();
//        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
//        int gridviewWidth = (int) (size * (length + 4) * density);
//        int itemWidth = (int)(length * density);
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridviewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
//        gridView.setLayoutParams(params);
//        gridView.setColumnWidth(itemWidth);
//        gridView.setHorizontalSpacing(3);
//        gridView.setStretchMode(GridView.NO_STRETCH);
//        gridView.setNumColumns(size);
        int allWidth = (int) (110 * size * density);
        int itemWidth = (int) (100 * density);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                allWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gridView.setLayoutParams(params);
        gridView.setColumnWidth(itemWidth);
        gridView.setHorizontalSpacing(2);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(size);
    }

    private void initFragment() {
        for (int i = 0; i < catelist.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString("name", catelist.get(i));
            Fragment newsFragment = new ContentFragment();
            newsFragment.setArguments(bundle);
            fragmentList.add(newsFragment);
        }
        Log.d("gridView", fragmentList.toString());
        pagerAdapter = new NewsAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        TextView selectView = (TextView) categoryAdapter.getView(position, null, null);
        gridView.smoothScrollToPosition(position);
        selectView.setTextColor(Color.RED);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
