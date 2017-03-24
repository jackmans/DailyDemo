package test.cyz.com.testmodule.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by M on 2016/12/13.
 */
public class DrawTestView extends View {

    public DrawTestView(Context context){
        super(context);
    }

    public DrawTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
//        paint.setShadowLayer(10, 5, 5, Color.BLUE);

        canvas.drawRGB(225, 225, 225);
        canvas.drawCircle(200, 200, 50, paint);

//        RectF rect1 = new RectF(300, 200, 600, 400);
//        RectF rect2 = new RectF(700, 200, 1000, 400);
//
//        Path path = new Path();
//        path.moveTo(400,400);
//        path.lineTo(800,400);
//        path.lineTo(400,800);
//        path.close();
//
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(rect1, 30, 90, true, paint);
//        canvas.drawArc(rect2, 0, 60, true, paint);
//        canvas.drawPath(path, paint);

        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);

        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);
        Region r1 = new Region(rect1);
        Region r2 = new Region(rect2);

        r1.op(r2, Region.Op.INTERSECT);

        paint.setColor(Color.BLUE);
        drawRegion(canvas, r1, paint);
    }

    private void drawRegion(Canvas canvas,Region rgn,Paint paint)
    {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
