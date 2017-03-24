package test.cyz.com.testmodule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.zip.Inflater;

/**
 * Created by M on 2016/12/2.
 */
public class DiaLogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

//        View dialogView = inflater.inflate(R.layout.dialog_test, null);

        builder.setView(inflater.inflate(R.layout.dialog_test, null));
        AlertDialog dialog = builder.create();

        //设置弹出框宽屏显示，适应屏幕宽度
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//注意此处
        dialog.getWindow().setLayout(200, 600);
//        dialog.setCanceledOnTouchOutside(true);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("dialog", "onStart: ");
//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
//        WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
//        lp.width = dm.widthPixels;
//        lp.height = dm.heightPixels;
//        getDialog().getWindow().setAttributes(lp);
    }
}
