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
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harish.woohoosmart.R;

public class Funnyquote extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private ImageView imageView,what1,what2,what3,what4,what5,what6;
    private Activity activity;


    Toast toasthelper;
    private String Text;
    private DatabaseReference databaseReference123 ;
    private static final String TAG = "Funnyquote";

    private AdView mAdView;

    private TextView Frnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funnyquote);
        firebaseDatabase = FirebaseDatabase.getInstance();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        getSupportActionBar().setTitle("Funny Quotes");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/rbl.ttf");

        databaseReference123 = firebaseDatabase.getReference("fun");
        what1 = findViewById(R.id.funnywhat1);
        Frnd = findViewById(R.id.funnyquo);
        imageView = findViewById(R.id.funnytextcpy1);
        Frnd.setTypeface(type);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView=new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-6850472818552165/9726817833");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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

        // initializing our object class variable.

getdata();
getshardata();

        imageView.setOnClickListener(v -> {
            ClipboardManager myClipboard;
            myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData myClip;
            Text = Frnd.getText().toString();
            myClip = ClipData.newPlainText("text", Text);
            myClipboard.setPrimaryClip(myClip);

            Toast.makeText(this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
        });

    }
        private void getshardata() {


            what1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ClipboardManager myClipboard;
                    myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData myClip;
                    Text = Frnd.getText().toString();
                    myClip = ClipData.newPlainText("text", Text);
                    myClipboard.setPrimaryClip(myClip);

                    Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,Text );
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                    //  whatshappint1.text(Text);

                }
            });
        }


        private void getdata() {

            // calling add value event listener method
            // for getting the values from database.
            databaseReference123.addValueEventListener(new ValueEventListener() {
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
                    Frnd.setText(value);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // calling on cancelled method when we receive
                    // any error or we are not able to get the data.
                    Toast.makeText(getApplicationContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
                }
            });
    }
}