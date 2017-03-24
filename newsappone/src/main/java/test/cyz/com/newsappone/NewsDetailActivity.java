package test.cyz.com.newsappone;

import android.media.Image;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import test.cyz.com.newsappone.dialog.NewsDialog;
import test.cyz.com.newsappone.fragment.NewsDetailFragment;

public class NewsDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fy_newsDetailContainer);
        ImageView iv_back = (ImageView)findViewById(R.id.iv_back);
        ImageView iv_share = (ImageView)findViewById(R.id.iv_sharing);

        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction t = fragmentManager.beginTransaction();
        t.replace(R.id.fy_newsDetailContainer, newsDetailFragment);
        t.commit();
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsDialog dialog = new NewsDialog(NewsDetailActivity.this, R.style.Theme_Light_Dialog);
                dialog.show();
            }
        });

    }

}
