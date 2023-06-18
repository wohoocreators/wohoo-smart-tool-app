package com.harish.woohoosmart.smart_tools;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.harish.woohoosmart.R;

public class torchlight extends AppCompatActivity {
    LinearLayout linearLayout;
    CameraManager cameraManager;
    ConstraintLayout imageView;
    String cam;
    Boolean sta =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torchlight);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setTitle("Torch Light");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        imageView=findViewById(R.id.flashon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sta==false){

                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cam=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cam,sta);
                        imageView.setBackgroundResource(R.drawable.flashoff);

                        sta=true;


                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }else {

                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cam=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cam,sta);
                        imageView.setBackgroundResource(R.drawable.flashon);
                        //addnotification();
                        sta=false;
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

           /* private void addnotification() {

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.logo)
                                .setContentTitle("Notifications Example")
                                .setContentText("This is a test notification");

                Intent notificationIntent = new Intent(this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
            }*/

        });
    }
}