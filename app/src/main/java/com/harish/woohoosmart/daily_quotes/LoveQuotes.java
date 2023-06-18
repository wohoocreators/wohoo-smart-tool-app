package com.harish.woohoosmart.daily_quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.harish.woohoosmart.R;

public class LoveQuotes extends AppCompatActivity {

       private FirebaseDatabase firebaseDatabase;
        private ImageView imageView;
ProgressBar progressBar;
    private String Text;
CardView cardView;
    private AdView mAdView;
    ImageView what1;
    ClipboardManager clipboardManager;
       private DatabaseReference databaseReference, databaseReference2,databaseReference3,databaseReference4,databaseReference5,databaseReference6;
        private ActionBar actionBar;
       private ClipData myc;
        // variable for Text view.
        private TextView retrieveTV,mo2,mo3,mo4,mo5,mo6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo3);

cardView=findViewById(R.id.card1);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Love Quotes");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        firebaseDatabase = FirebaseDatabase.getInstance();
imageView=findViewById(R.id.mo3clipv);
what1=findViewById(R.id.mo3what);

        databaseReference = firebaseDatabase.getReference("lo1");

        // initializing our object class variable.
        retrieveTV = findViewById(R.id.l1);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/rbl.ttf");
        retrieveTV.setTypeface(type);                   // Toast.makeText(this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
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
     getdata();

        imageView.setOnClickListener(v -> {
            ClipboardManager myClipboard;
            myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData myClip;
            Text = retrieveTV.getText().toString();
            myClip = ClipData.newPlainText("text", Text);
            myClipboard.setPrimaryClip(myClip);

            Toast.makeText(this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
        });
        getshardata();
    }

    private void getshardata() {


        what1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ClipboardManager myClipboard;
                    myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData myClip;
                    Text = retrieveTV.getText().toString();
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
}