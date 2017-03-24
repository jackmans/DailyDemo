package test.cyz.com.testmodule;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/**
 * Created by M on 2016/11/28.
 */
public class MeasureTest extends TextView{
    public MeasureTest(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(50, widthMeasureSpec);
        int height = getMySize(50, heightMeasureSpec);
        if(width > height){
            height = width;
        }
        else{
            width = height;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    public int getMySize(int defaultSize, int measureSpec){
        int mySize = defaultSize;
        int mode =  MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch(mode){
            case MeasureSpec.UNSPECIFIED:
                mySize = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                mySize = size;
                break;
            case MeasureSpec.EXACTLY:
                mySize = size;
                break;
            default:
        }
        return mySize;
    }


}
