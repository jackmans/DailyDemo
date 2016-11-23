package test.cyz.com.animationtest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CirclePainterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_circlepainter);
        Button btn_circle = (Button)findViewById(R.id.button_circle);
        final CirclePainter circle = (CirclePainter) findViewById(R.id.circle_view);
        btn_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle.doCircleAnima();
            }
        });

    }



}
