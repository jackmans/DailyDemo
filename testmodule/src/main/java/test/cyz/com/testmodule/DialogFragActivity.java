package test.cyz.com.testmodule;


import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by M on 2016/12/2.
 */
public class DialogFragActivity extends Activity {
    ImageView showImage;
    DialogTest dialogTest;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Button button = (Button) findViewById(R.id.btn_start);
        showImage = (ImageView) findViewById(R.id.iv_show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DiaLogFragment dialogFragment = new DiaLogFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                dialogFragment.show(fm, "dialog");

                dialogTest = new DialogTest(DialogFragActivity.this, R.style.Theme_Light_Dialog, new DialogTest.CustomeEventListener() {
                    @Override
                    public void customeEvent(int id) {
                        showImage.setImageResource(id);
                    }
                });

                dialogTest.show();
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        DisplayMetrics dm = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics( dm );
//        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
//        lp.width = dm.widthPixels;
//        lp.height = dm.heightPixels;
//        this.getWindow().setAttributes(lp);
//    }
}
