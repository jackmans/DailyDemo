package test.cyz.com.animationtest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by M on 2016/11/17.
 */
public class CirclePainter extends View {

    private Point mCurrentPoint;

    public CirclePainter(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mCurrentPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(350, 350, mCurrentPoint.getRadius(), paint);
        }


    }

    public void doCircleAnima(){
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyEvaluator(), new Point(100), new Point(400));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurrentPoint = (Point)valueAnimator.getAnimatedValue();
                invalidate();

            }
        });

        valueAnimator.setDuration(5000);
        valueAnimator.start();

    }

}
