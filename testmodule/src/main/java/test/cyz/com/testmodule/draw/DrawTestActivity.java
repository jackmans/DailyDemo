package test.cyz.com.testmodule.draw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import test.cyz.com.testmodule.R;

public class DrawTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_draw);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layout_draw_root);
        View drawTestView  = new DrawTestView(DrawTestActivity.this);
        linearLayout.addView(drawTestView);
    }
}
