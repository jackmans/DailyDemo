package test.cyz.com.jmnews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by M on 2016/8/31.
 */
public class ContentFragment extends Fragment {
    private String channelName;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_content, container, false);
//        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_content);

            //该部分可通过xml文件设计Fragment界面，再通过LayoutInflater转换为View组件
            //这里通过代码为fragment添加一个TextView
            TextView tvTitle=new TextView(getActivity());
            tvTitle.setText(channelName);
            tvTitle.setTextSize(16);
            tvTitle.setGravity(Gravity.CENTER);
            tvTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//            linearLayout.addView(tvTitle);
        Log.d("gridView","执行onCreateView" +  container.toString());
            view =  tvTitle;
//        ViewGroup parent=(ViewGroup)view.getParent();
//        if(parent!=null){//如果View已经添加到容器中，要进行删除，负责会报错
//            parent.removeView(view);
//        }
        if(view == null){
            Log.d("gridView", "view is null");
        }
        Log.d("gridView", "返回根布局:" + view.toString() +"根布局的父布局：" +  view.getParent());
        Log.d("gridView", "Contianer中子项：" + String.valueOf(container.getChildCount()));

        return view;


    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        channelName = args.getString("name");
    }
}
