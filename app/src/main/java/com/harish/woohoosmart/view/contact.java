package com.harish.woohoosmart.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ActivityNotFoundException;
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

import com.google.android.material.resources.TextAppearance;
import com.harish.woohoosmart.R;

public class contact extends AppCompatActivity {
TextView textView,textView2;
ImageView imageView,ista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    getSupportActionBar().hide();
    textView=findViewById(R.id.titlle1);
    textView2=findViewById(R.id.tittle2);
    ista=findViewById(R.id.instaint);
imageView=findViewById(R.id.mail1);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/rr.ttf");
        textView.setTypeface(type);
        Typeface type2 = Typeface.createFromAsset(getAssets(),"fonts/rbo.ttf");
        textView2.setTypeface(type2);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "harishcse5@gmail.com"});

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
});
ista.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("http://instagram.com/_u/wohoo_tech");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/wohoo_tech")));
        }
    }
});
    }
}