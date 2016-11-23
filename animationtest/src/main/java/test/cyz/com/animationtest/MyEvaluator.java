package test.cyz.com.animationtest;

import android.animation.TypeEvaluator;

/**
 * Created by M on 2016/11/16.
 */
public class MyEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float v, Point t1, Point t2) {

        float start = t1.getRadius();
        float end = t2.getRadius();
        float current = start +  v * (end - start);
        return new Point(current);
    }
}
