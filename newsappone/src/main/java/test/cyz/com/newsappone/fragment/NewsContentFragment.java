package test.cyz.com.newsappone.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.adapter.ListViewAdapter;
import test.cyz.com.newsappone.domain.News;
import test.cyz.com.newsappone.util.HttpUtil;
import test.cyz.com.newsappone.util.HttpsCallbackListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {


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
        ListView lv_content = (ListView) ly_newsContent.findViewById(R.id.lv_content);
        new Thread(new Runnable() {
            @Override
            public void run() {
                requestForNews();
            }
        }).start();
        listViewAdapter = new ListViewAdapter(getContext(), R.layout.list_items, NewsArray);
        lv_content.setAdapter(listViewAdapter);

        return ly_newsContent;
    }

    private void requestForNews(){
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
