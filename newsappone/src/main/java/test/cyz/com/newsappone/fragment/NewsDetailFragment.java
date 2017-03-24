package test.cyz.com.newsappone.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import test.cyz.com.newsappone.R;

/**
 * Created by M on 2016/12/1.
 */
public class NewsDetailFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout ly_container = (LinearLayout) inflater.inflate(R.layout.fragment_news_detail, container, false);


        return ly_container;
    }

    @Override
    public void onClick(View view) {

    }
}
