package com.harish.woohoosmart.smart_tools;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.harish.woohoosmart.R;

public class compass extends AppCompatActivity implements SensorEventListener {
ImageView imageView;
TextView textView;
int mazfmuth;
private SensorManager sensorManager;
private Sensor rotator,acellometer,magnetometer;
float[]rmat=new float[9];
float[]orientation=new float[9];
private float[] lastAccelometer=new float[3];
    private float[] lastMagnetometer=new float[3];
    private boolean havesensor=false,havesensor2=false;

    private boolean mLastmagnetometerset=false;
    private boolean mLastaccelometerset=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Compass");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        imageView=findViewById(R.id.cmpimg);
        textView=findViewById(R.id.txtazi);
        start();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ROTATION_VECTOR){

            SensorManager.getRotationMatrixFromVector(rmat,event.values);
            mazfmuth=(int)((Math.toDegrees(SensorManager.getOrientation(rmat,orientation)[0])+360)%360);
        }
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            System.arraycopy(event.values,0,lastAccelometer,0,event.values.length);
           mLastaccelometerset=true;

        }

        if (event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            System.arraycopy(event.values,0,lastMagnetometer,0,event.values.length);
            mLastmagnetometerset=true;

        }

        if (mLastmagnetometerset && mLastaccelometerset){
          SensorManager.getRotationMatrix(rmat,null,lastAccelometer,lastMagnetometer);
          SensorManager.getOrientation(rmat,orientation);
          mazfmuth=(int) ((Math.toDegrees(SensorManager.getOrientation(rmat,orientation)[0])+360%360));



        }

mazfmuth=Math.round(mazfmuth);
        imageView.setRotation(mazfmuth);


    String where="No";
    if (mazfmuth>=350|| mazfmuth<=10)
    where="N";
        if (mazfmuth<350|| mazfmuth>280)
            where="NW";
        if (mazfmuth<=280|| mazfmuth<=260)
            where="W";
        if (mazfmuth<=260|| mazfmuth<=190)
            where="SW";
        if (mazfmuth<=190|| mazfmuth<=170)
            where="S";
        if (mazfmuth<=170|| mazfmuth<=100)
            where="SE";
        if (mazfmuth<=100|| mazfmuth<=80)
            where="E";
        if (mazfmuth<=80|| mazfmuth<=10)
            where="NE";
        textView.setText(mazfmuth+""+where);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void start() {

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)==null){
            if(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)==null||sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)==null){
            nosensoralert();
        }
     else {

         acellometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         magnetometer=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
         havesensor=sensorManager.registerListener(this,acellometer,SensorManager.SENSOR_DELAY_UI);
                havesensor2=sensorManager.registerListener(this,magnetometer,SensorManager.SENSOR_DELAY_UI);
            }
    }

    else {

        rotator=sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            havesensor2=sensorManager.registerListener(this,rotator,SensorManager.SENSOR_DELAY_UI);
        }
    }


    private void nosensoralert() {

        AlertDialog.Builder alertdialog= new AlertDialog.Builder(this);
        alertdialog.setMessage("Your device doesn't Support the compass").setCancelable(false).setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });




    }

    public void stop(){

        if(havesensor && havesensor2) {

            sensorManager.unregisterListener(this, acellometer);
            sensorManager.unregisterListener(this, magnetometer);

        }else {



            if(havesensor){

                sensorManager.unregisterListener(this,rotator);
            }

        }

    }
public void onpause(){


        super.onPause();

        stop();


}
protected void ons(){


    }
}