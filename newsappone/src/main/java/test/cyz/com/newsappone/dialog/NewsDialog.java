package test.cyz.com.newsappone.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.zip.Inflater;

import test.cyz.com.newsappone.R;

/**
 * Created by M on 2016/12/7.
 */
public class NewsDialog extends AlertDialog {

    Context mContext;

    public NewsDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout_dialog = inflater.inflate(R.layout.dialog_news_bottom, null);
        setContentView(layout_dialog);
        Window window = getWindow();
        window.setWindowAnimations(R.style.dialog_anim_style);
        window.getDecorView().setPadding(0,50,0,0);
        window.setGravity(Gravity.BOTTOM);
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setLayout(-1, -2);
    }
}
