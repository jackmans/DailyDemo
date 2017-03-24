package test.cyz.com.testmodule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by M on 2016/12/6.
 */
public class DialogTest extends AlertDialog implements View.OnClickListener{

    Context mContext;
    View layout;
    private CustomeEventListener mCustomeEventListener;

    public DialogTest(Context context, int themeResId, CustomeEventListener customeEventListener) {
        super(context, themeResId);
        mContext = context;
        mCustomeEventListener = customeEventListener;
    }

    public DialogTest(Context context){
        super(context);
        mContext = context;
    }

    public interface CustomeEventListener{
        void customeEvent(int id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);


        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        View dialogView = inflater.inflate(R.layout.dialog_test, null);

//        builder.setView(inflater.inflate(R.layout.dialog_test, null));

        layout = inflater.inflate(R.layout.activity_bottom_dialog, null);
        initView();
        this.setContentView(layout);

        //设置弹出框宽屏显示，适应屏幕宽度
        this.setCancelable(true);
//        this.setCanceledOnTouchOutside(true);

//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//注意此处
        this.getWindow().setLayout(-1,400);
        Window window = this.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
//        window.setWindowAnimations(R.style.dialogStyle);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
//        dialog.setCanceledOnTouchOutside(true);

    }

    public void initView(){
        ImageView iv_run = (ImageView) layout.findViewById(R.id.iv_run);
        ImageView iv_taxi = (ImageView) layout.findViewById(R.id.iv_taxi);
        ImageView iv_work = (ImageView) layout.findViewById(R.id.iv_work);
        ImageView iv_train = (ImageView) layout.findViewById(R.id.iv_train);
        iv_run.setOnClickListener(this);
        iv_taxi.setOnClickListener(this);
        iv_work.setOnClickListener(this);
        iv_train.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id  = view.getId();
        int drawbleId = -1;
        switch(id){
            case R.id.iv_run:
                drawbleId = R.drawable.iv_run;
                Log.d("dialog", "iv_run");
                break;
            case R.id.iv_taxi:
                drawbleId = R.drawable.iv_taxi;
                Log.d("dialog", "iv_taxi");
                break;
            case R.id.iv_train:
                drawbleId = R.drawable.iv_train;
                Log.d("dialog", "iv_train");
                break;
            case R.id.iv_work:
                drawbleId = R.drawable.iv_work;
                Log.d("dialog", "iv_work");
                break;
            default:
                break;
        }
        if(drawbleId != -1){
            mCustomeEventListener.customeEvent(drawbleId);
        }
        dismiss();
    }
}
