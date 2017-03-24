package test.cyz.com.newsappone.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.cyz.com.newsappone.NewsDetailActivity;
import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.adapter.ListViewAdapter;
import test.cyz.com.newsappone.domain.News;
import test.cyz.com.newsappone.util.HttpUtil;
import test.cyz.com.newsappone.util.HttpsCallbackListener;
import test.cyz.com.newsappone.util.RefreshableView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {

    SwipeRefreshLayout mSwipeLayout;

    //将获取到的新闻信息存在这里
    List<News> NewsArray = new ArrayList<News>();

    public NewsContentFragment() {
        // Required empty public constructor
    }

private  ListViewAdapter listViewAdapter;
    private Handler handler = new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout ly_newsContent = (LinearLayout)inflater.inflate(R.layout.fragment_news_content, container, false);
        ListView lv_content = (ListView) ly_newsContent.findViewById(R.id.lv_refreshView);
//        final RefreshableView refreshableView = (RefreshableView) ly_newsContent.findViewById(R.id.refreshable_view);

        mSwipeLayout = (SwipeRefreshLayout) ly_newsContent.findViewById(R.id.refreshable_view);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(300);
                    mSwipeLayout.setRefreshing(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeLayout.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeLayout.setSize(SwipeRefreshLayout.LARGE); // 设置圆圈的大小

        new Thread(new Runnable() {
            @Override
            public void run() {
                requestForNews();
            }
        }).start();
        listViewAdapter = new ListViewAdapter(getContext(), R.layout.list_items, NewsArray);
        lv_content.setAdapter(listViewAdapter);
//        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
//            @Override
//            public void onRefresh() throws InterruptedException {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                refreshableView.finishRefreshing();
//            }
//        }, 1);

        lv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(getContext(), NewsDetailActivity.class);
                startActivity(intent);
            }
        });
        return ly_newsContent;
    }

    private void requestForNews(){
        Log.d("news", "requestForNews()");
        String address = "https://matthew-yao.com/chenyuanze.php";
        String body = "token=836b32ec64436f6fbc7c0a3d1c8bc17a";
        HttpUtil.sendHttpsRequest(address, body, new HttpsCallbackListener() {
            @Override
            public void onFinish(String response) {
                String result = response;
                try {
                    newsHandler(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private void newsHandler(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        for (int i=0; i <jsonArray.length(); i++ ){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String title = (String) jsonObject.get("title");
            String content = jsonObject.getString("content");
            String author = jsonObject.getString("author");
            String date =  jsonObject.getString("date");
            News newsItem = new News(author, content, date, title);
            NewsArray.add(newsItem);
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                listViewAdapter.notifyDataSetChanged();
            }
        });
    }

}
