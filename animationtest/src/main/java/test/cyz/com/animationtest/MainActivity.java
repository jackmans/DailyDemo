package test.cyz.com.animationtest;



import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f, 0f);
//                ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -200f, 0f);
//                ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", -360f, 0f);
//                AnimatorSet set = new AnimatorSet();
//                set.play(moveIn).with(rotate).before(fadeOut);
//                set.setDuration(5000);
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator_main);
                animator.setTarget(textView);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                        Log.d("animator", "动画开始了！");
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.d("animator", "动画结束了！");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                animator.start();
            }


        });


    }
}
