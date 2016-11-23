package test.cyz.com.newsappone;




import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.cyz.com.newsappone.fragment.LiveFragment;
import test.cyz.com.newsappone.fragment.NewsFragment;
import test.cyz.com.newsappone.fragment.RecommendFragment;
import test.cyz.com.newsappone.fragment.SettingFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private TextView tv_news;
    private TextView tv_recommend;
    private TextView tv_live;
    private TextView tv_setting;
    private LinearLayout ly_btm;
    FragmentManager fragmentManager;
    private Fragment newsFragment;
    private Fragment liveFragment;
    private Fragment recommendFragment;
    private Fragment settingFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        setSelection(0);
    }

    private void initView(){
        tv_news = (TextView)findViewById(R.id.tv_news);
        tv_recommend =  (TextView)findViewById(R.id.tv_recommend);
        tv_live =  (TextView)findViewById(R.id.tv_live);
        tv_setting =  (TextView)findViewById(R.id.tv_setting);
        ly_btm = (LinearLayout)findViewById(R.id.ly_btm_titleBar);
        tv_news.setOnClickListener(this);
        tv_recommend.setOnClickListener(this);
        tv_live.setOnClickListener(this);
        tv_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_news:
                setSelection(0);
                break;
            case R.id.tv_recommend:
                setSelection(1);
                break;
            case R.id.tv_live:
                setSelection(2);
                break;
            case R.id.tv_setting:
                setSelection(3);
                break;
        }
    }

    private void setSelection(int index){
        transaction = fragmentManager.beginTransaction();
        hideFragment();
        clearColor();
        switch (index){
            case 0:
                tv_news.setTextColor(Color.WHITE);
                if(newsFragment != null){
                    transaction.show(newsFragment);
                }
                else{
                    newsFragment =  new NewsFragment();
                    transaction.add(R.id.fl_container, newsFragment);
                }
                break;
            case 1:
                tv_recommend.setTextColor(Color.WHITE);
                if(recommendFragment != null){
                    transaction.show(recommendFragment);
                }
                else{
                    recommendFragment =  new RecommendFragment();
                    transaction.add(R.id.fl_container, recommendFragment);
                }
                break;
            case 2:
                tv_live.setTextColor(Color.WHITE);
                if(liveFragment != null){
                    transaction.show(liveFragment);
                }
                else{
                    liveFragment =  new LiveFragment();
                    transaction.add(R.id.fl_container, liveFragment);
                }
                break;
            case 3:
                tv_setting.setTextColor(Color.WHITE);
                if(settingFragment != null){
                    transaction.show(settingFragment);
                }
                else{
                    settingFragment =  new SettingFragment();
                    transaction.add(R.id.fl_container, settingFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();

    }

    private void hideFragment(){
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (recommendFragment != null) {
            transaction.hide(recommendFragment);
        }
        if (liveFragment != null) {
            transaction.hide(liveFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }


    private void clearColor(){
        tv_news.setTextColor(Color.BLACK);
        tv_recommend.setTextColor(Color.BLACK);
        tv_live.setTextColor(Color.BLACK);
        tv_setting.setTextColor(Color.BLACK);
    }


}
