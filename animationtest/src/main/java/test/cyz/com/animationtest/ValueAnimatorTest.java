package test.cyz.com.animationtest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by M on 2016/9/27.
 */
public class ValueAnimatorTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_move);
        final TextView textView = (TextView) findViewById(R.id.textView_move);
        Button button = (Button) findViewById(R.id.button);

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.ofFloat(0f, 400f);
        valueAnimator.setDuration(300);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                int cur = ((int) value);
                textView.layout(cur, cur, cur+textView.getWidth(), cur+textView.getHeight());
            }
        });
        valueAnimator.start();
    }




}
