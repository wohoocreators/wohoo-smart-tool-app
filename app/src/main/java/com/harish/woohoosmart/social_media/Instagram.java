package com.harish.woohoosmart.social_media;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.harish.woohoosmart.R;

public class Instagram extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        webView=findViewById(R.id.instagweb);

        getSupportActionBar().setTitle("Instagram");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#004e92"));
        actionBar.setBackgroundDrawable(colorDrawable);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.instagram.com/");

        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public void onBackPressed(){
        if(webView.canGoBack())
        {
            webView.goBack();

        }
        else{
            super.onBackPressed();
        }
    }

}