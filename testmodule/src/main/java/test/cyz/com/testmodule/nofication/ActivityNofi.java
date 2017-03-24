package test.cyz.com.testmodule.nofication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import test.cyz.com.testmodule.R;

/**
 * Created by M on 2017/1/9.
 */
public class ActivityNofi extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nofication);
        Button button = (Button) findViewById(R.id.button_send);

        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("New Notification")
                .setContentText("下午茶下午茶！！")
                .setSmallIcon(R.drawable.iv_run)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);

        Intent intent = new Intent(this, AnotherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 11, intent, 0);
        mBuilder.setContentIntent(pendingIntent);
        final Notification notification = mBuilder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(1, notification);
            }
        });


    }
}
