package test.cyz.com.newsappone.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by M on 2016/11/28.
 */
public class BaseTools {


    public final static int getWindowsWidth(Activity activity){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }


}
