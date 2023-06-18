package com.harish.woohoosmart.smart_tools;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.harish.woohoosmart.R;
import com.harish.woohoosmart.loq;

import java.security.SecureRandom;

public class passwordgenerator extends AppCompatActivity {
TextView textView,textView1;
SeekBar seekBar;
Button button;
    int len;
int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordgenerator);
    seekBar=findViewById(R.id.seekbar1);
    button=findViewById(R.id.generatehkk);

    textView=findViewById(R.id.txtpos);
    textView1=findViewById(R.id.length);


        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/rbo.ttf");
        textView1.setTypeface(type);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Generate Password");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            pos=progress;
            textView.setText(""+pos);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });


    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if (pos > 8) {
                Intent intent = new Intent(passwordgenerator.this, loq.class);
                intent.putExtra("val", pos);

                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(), "Select atleast Greater Than 8 ", Toast.LENGTH_SHORT).show();
            }
        }


    });
    }
}