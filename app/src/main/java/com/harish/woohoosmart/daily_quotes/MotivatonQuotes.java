package com.harish.woohoosmart.daily_quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harish.woohoosmart.Cliboardd;
import com.harish.woohoosmart.R;

import java.util.Objects;

public class MotivatonQuotes extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    ImageView imageView,what1,imageView2;
Activity activity;

boolean state=false;
Toast toasthelper;
private AdView mAdView;
   private String Text;
   private DatabaseReference databaseReference, databaseReference2,databaseReference3,databaseReference4,databaseReference5,databaseReference6;
   private ActionBar actionBar;
    ClipData myc;
    // variable for Text view.
    private TextView retrieveTV,mo2,mo3,mo4,mo5,mo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moq);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Motivation Quotes");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference("mo1");


        // initializing our object class variable.
  what1=findViewById(R.id.what1);


       /* what2=findViewById(R.id.what2);
        what3=findViewById(R.id.what3);
        what4=findViewById(R.id.what4);
        what5=findViewById(R.id.what1);
        what6=findViewById(R.id.what6);*/


        retrieveTV = findViewById(R.id.jbjbjb);
       /* mo2=findViewById(R.id.mo2);
        mo3=findViewById(R.id.mo3);
        mo4=findViewById(R.id.mo4);
        mo5=findViewById(R.id.mo5);
        mo6=findViewById(R.id.mo6);*/
        imageView=findViewById(R.id.textcpy1);
        mAdView=new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-6850472818552165/9726817833");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/rbl.ttf");
        retrieveTV.setTypeface(type);                   // Toast.makeText(this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        // calling method
        // for getting data.
        getdata();

        getshardata();


         Cliboardd clipo= new Cliboardd(this);



        imageView.setOnClickListener(v -> {
            Text = retrieveTV.getText().toString();

            clipo.clip( Text);


        });


        what1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text = retrieveTV.getText().toString();

                clipo.IntentCLip(Text);

            }
        });
    }




    private void getshardata() {


    }


    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clip(){


    }

}