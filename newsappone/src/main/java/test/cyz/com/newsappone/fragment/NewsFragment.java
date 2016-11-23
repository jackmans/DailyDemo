package test.cyz.com.newsappone.fragment;


import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.adapter.NewsContentFragmentAdapter;

public class NewsFragment extends Fragment {

    LinearLayout ly_items;
    List<String> listItems = new ArrayList<String>();
    HorizontalScrollView horizontalScrollView;
    int itemSelectIndex;
    LinearLayout ly_newsFrag;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private int currentIndex;


    public NewsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        ly_newsFrag = (LinearLayout) inflater.inflate(R.layout.fragment_news, container, false);
        ly_items = (LinearLayout) ly_newsFrag.findViewById(R.id.ly_items);
        horizontalScrollView = (HorizontalScrollView) ly_newsFrag.findViewById(R.id.scroll);
        viewPager = (ViewPager)ly_newsFrag.findViewById(R.id.viewpager);
        initNewsCategory();
        init_newsItem();
        initContentFragment();
        FragmentManager fm = getFragmentManager();
        NewsContentFragmentAdapter fpAdapter = new NewsContentFragmentAdapter(fm, fragmentList);
        viewPager.setAdapter(fpAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TextView selectBe = (TextView) ly_items.getChildAt(currentIndex);
                selectBe.setTextColor(Color.BLACK);
                selectBe.setTextSize(20);
                currentIndex = position;
                TextView selectAf = (TextView) ly_items.getChildAt(currentIndex);
                selectAf.setTextColor(Color.RED);
                selectAf.setTextSize(25);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return ly_newsFrag;

    }

    private void init_newsItem(){
        ly_items.removeAllViews();
        int count = listItems.size();
        for(int i = 0; i < count; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 25;
            params.rightMargin = 25;
            final TextView tv_items = new TextView(this.getActivity());
            tv_items.setGravity(Gravity.CENTER);
            tv_items.setPadding(5,5,5,5);
            tv_items.setId(i);
            tv_items.setText(listItems.get(i));
            tv_items.setTextColor(Color.BLACK);
            tv_items.setTextSize(20);
//            if(itemSelectIndex == i){
//
//            }
            tv_items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   for(int i = 0; i < ly_items.getChildCount(); i++)
                   {
                       View selectView = ly_items.getChildAt(i);
                       if(selectView == view){

                           TextView selectBefore = (TextView) ly_items.getChildAt(currentIndex);
                           selectBefore.setTextColor(Color.BLACK);
                           selectBefore.setTextSize(20);
                           currentIndex = i;
                           TextView selectAfter = (TextView)view;
                           selectAfter.setTextColor(Color.RED);
                           selectAfter.setTextSize(25);

                           viewPager.setCurrentItem(i);

                       }

                   }

                }
            });
            ly_items.addView(tv_items, i, params);
        }
    }

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

    private String getSpecNews() throws MalformedURLException {
        String result = null;
         URL url = new URL("https://matthew-yao.com/chenyuanze.php");
         InputStreamReader in = null;

                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(3000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    if (connection instanceof HttpsURLConnection) { // 是Https请求
                        SSLContext sslContext = SSLContextUtil.getSSLContext();
                        if (sslContext != null) {
                            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                            ((HttpsURLConnection) connection).setSSLSocketFactory(sslSocketFactory);
                        }
                    }
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    DataOutputStream op = new DataOutputStream(connection.getOutputStream());
                    op.writeBytes("token=836b32ec64436f6fbc7c0a3d1c8bc17a");
                    op.flush();
                    op.close();

                    in = new InputStreamReader(connection.getInputStream());
                    BufferedReader reader = new BufferedReader(in);
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    result = response.toString();

                } catch (IOException e) {
                    e.printStackTrace();
                }
         return result;

    }



    private void setRequestParm(){

    }

}
