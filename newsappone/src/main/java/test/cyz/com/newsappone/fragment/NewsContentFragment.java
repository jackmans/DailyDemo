package test.cyz.com.newsappone.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.cyz.com.newsappone.R;
import test.cyz.com.newsappone.adapter.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {

    private List<String> list = new ArrayList<>();


    public NewsContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout ly_newsContent = (LinearLayout)inflater.inflate(R.layout.fragment_news_content, container, false);
        ListView lv_content = (ListView) ly_newsContent.findViewById(R.id.lv_content);
        initList();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext(), R.layout.list_items, list);
        lv_content.setAdapter(listViewAdapter);

        return ly_newsContent;
    }

    void initList(){
        String[] text = new String[]{"头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性"};
        for(int i = 0; i < text.length; i++){
            list.add(text[i]);
        }
    }

}
