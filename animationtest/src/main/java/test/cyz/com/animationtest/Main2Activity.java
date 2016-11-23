package test.cyz.com.animationtest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.textView);
        Button btn = (Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorMethod();

            }
        });

    }

    private void animatorMethod() {
        final ValueAnimator animator = ValueAnimator.ofFloat(0f, 50f, 400f, 360f);
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.INFINITE);
        animator.setRepeatCount(10);
        animator.setEvaluator(new MyEvaluator());

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int)animator.getAnimatedValue();
                textView.layout(curValue,curValue,curValue+textView.getWidth(),curValue+textView.getHeight());
            }
        });
    }
}