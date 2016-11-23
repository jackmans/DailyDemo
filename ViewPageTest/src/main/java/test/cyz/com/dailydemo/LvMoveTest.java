package test.cyz.com.dailydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M on 2016/9/18.
 */
public class LvMoveTest extends Activity{
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private TextView textContent;
    private LinearLayout rootLayout;
    private List<String> list = new ArrayList<>();
    private final int MAX_WIDTH = 100;
    private int lastX;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_item);
        rootLayout= (LinearLayout) findViewById(R.id.lt_item);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("move", "点击了layout！");
            }
        });
        rootLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("move", "进入触摸事件！");
                int maxLength = dip2px(LvMoveTest.this, MAX_WIDTH);

                int scrollX = rootLayout.getScrollX();
                int x = (int) motionEvent.getX();

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(isOpen == true){
                            rootLayout.scrollTo(0, 0);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int newScrollX = scrollX + lastX - x;
                        Log.d("move", "action move:" + scrollX);
                        if( newScrollX < 0){
                            newScrollX = 0;
                        }
                        else if(newScrollX > maxLength){
                            newScrollX = maxLength;
                        }
                        rootLayout.scrollTo(newScrollX, 0);
                        break;

                    case MotionEvent.ACTION_UP:
                    default:
                        if(scrollX> 0){
                            rootLayout.scrollTo(maxLength, 0);
                            isOpen =true;
                        }
                        break;
                }
                lastX = x;
                return false;
            }



        });
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
