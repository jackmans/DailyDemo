package test.cyz.com.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView after;
    TextView before;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.animator_test);
        Button btn2 = (Button)findViewById(R.id.button2);
        final TextView textView = (TextView)findViewById(R.id.textView2);
        before = (TextView)findViewById(R.id.textView3);
        after = (TextView)findViewById(R.id.textView4);
        textView.post(new Runnable() {
            @Override
            public void run() {
                float width = textView.getLeft();
                float height = textView.getTop();
                before.setText("left:"+ width + "," + "top:" + height);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(scaleAnimation);
                float width = textView.getLeft();
                float height = textView.getTop();
                after.setText("left:"+ width + "," + "top:" + height);
            }
        });

    }
}



