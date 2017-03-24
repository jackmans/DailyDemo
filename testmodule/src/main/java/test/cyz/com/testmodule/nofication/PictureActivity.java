package test.cyz.com.testmodule.nofication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

import java.util.ArrayList;

import test.cyz.com.testmodule.R;

/**
 * Created by M on 2017/1/9.
 */
public class PictureActivity extends AppCompatActivity {

    final String PRE_PICTRUE = "com.cyz.notification.PRE_PIC";
    final String NEXT_PICTRUE = "com.cyz.notification.NEXT_PIC";
    private int index;
    private int count;
    private ImageView imageView;
    int[] imageId;
    IntentFilter intentFilter;
    NotificationReceiver notificationReceiver;
    NotificationManager manager;
    Notification notify;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(notificationReceiver);
        manager.cancelAll();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_picture);
        Button button = (Button)findViewById(R.id.btn_pic_send);
        imageView = (ImageView)findViewById(R.id.iv_picture);
        initImage();

        intentFilter = new IntentFilter();
        intentFilter.addAction(PRE_PICTRUE);
        intentFilter.addAction(NEXT_PICTRUE);
        notificationReceiver = new NotificationReceiver();
        registerReceiver(notificationReceiver, intentFilter);


        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        RemoteViews  remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notifi_picture);
//        remoteViews.setImageViewResource(R.id.iv_nofi_picture, R.drawable.iv_run);
//        remoteViews.setTextViewText(R.id.tv_nofi_text, "标题要长......");
//        remoteViews.setTextViewText(R.id.text, "内容要短......");

        Intent btn_pre = new Intent(PRE_PICTRUE);
        PendingIntent pendingIntent_pre = PendingIntent.getBroadcast(this, 1, btn_pre, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn_before, pendingIntent_pre);

        Intent btn_next = new Intent(NEXT_PICTRUE);
        PendingIntent pendingIntent_next = PendingIntent.getBroadcast(this, 1, btn_next, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn_after, pendingIntent_next);
        
        mBuilder.setContent(remoteViews)
//                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.iv_setting_email)
                .setContentTitle("My notification")
                .setTicker("new message");
        notify = mBuilder.build();
        notify.flags = Notification.FLAG_ONGOING_EVENT;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.notify(54, notify);
            }
        });


    }

    class NotificationReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

            String notificationMsg = intent.getAction();
            if(notificationMsg.equals(PRE_PICTRUE)){
                changePrePic();
                imageView.setImageResource(imageId[index]);
            }
            if(notificationMsg.equals(NEXT_PICTRUE)){
                changeNextPic();

                imageView.setImageResource(imageId[index]);
            }

        }
    }

    public void changePrePic(){
        index = index - 1;
        if(index < 0){
            index = index + count;
        }
    }

    public void changeNextPic(){
        index = index + 1;
        if(index > count - 1){
            index = index - count;
        }
    }

    private void initImage(){
        imageId = new int[]{R.drawable.iv_taxi, R.drawable.iv_run, R.drawable.iv_train, R.drawable.iv_work};
        index = 0;
        count = imageId.length;
    }


}
