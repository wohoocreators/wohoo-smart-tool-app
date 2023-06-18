package com.harish.woohoosmart.social_media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.harish.woohoosmart.R;

public class Amazon extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);
        Intent intent =getIntent();
        intent.getStringExtra("url");

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        webView=findViewById(R.id.amazonweb);
      getSupportActionBar().setTitle("Amazon");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.amazon.in/");

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