package test.cyz.com.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAnimaSet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima_set);

        Button btn = (Button) findViewById(R.id.btn_start);
        final TextView textView = (TextView) findViewById(R.id.text);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.animator_test);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(animation);
            }
        });



    }
}
