package test.cyz.com.dailydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M on 2016/9/13.
 */
public class ListViewActivity extends Activity implements View.OnTouchListener{

    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private TextView textContent;
    private LinearLayout rootLayout;
    private List<String> list = new ArrayList<>();
    private final int MAX_WIDTH = 60;
    private int lastX;
    private boolean isOpen = false;
    private View listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_move);
        initArray();
        listView = (ListView) findViewById(R.id.lv_list);
        arrayAdapter = new ListViewAdapter(this, R.layout.lv_item, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnTouchListener(this);
    }

    private void initArray() {
        String[] text = new String[]{"头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性", "头条", "体育", "科技", "财经", "汽车", "时尚", "房产", "段子", "军事", "历史", "游戏", "两性"};
        for(int a = 0; a < text.length; a++){
            list.add(text[a]);
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("move", "ListView:" + view.toString());
        Log.d("move", "进入ListView触摸事件！");
        ListView lv = (ListView) view;
                int maxLength = dip2px(this, MAX_WIDTH);
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int scrollX ;
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(isOpen == true){
                            rootLayout.scrollTo(0, 0);
                            rootLayout = null;
                        }
                        int position = listView.pointToPosition(x, y);
                        listItem = lv.getChildAt(position);
                        rootLayout = (LinearLayout) listItem.findViewById(R.id.lt_item);
                        Log.d("move", "rootLayout:" + rootLayout.toString());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        scrollX = rootLayout.getScrollX();
                        int newScrollX = scrollX + lastX - x;
                        Log.d("move", "x:" + x);
                        Log.d("move", "newScrollX:" + scrollX);
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
                        scrollX = rootLayout.getScrollX();
                        if(scrollX> 0){
                            rootLayout.scrollTo(maxLength, 0);
                            isOpen = true;
                        }
                        break;
                }
                lastX = x;
                return false;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
