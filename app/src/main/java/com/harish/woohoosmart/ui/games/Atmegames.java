package com.harish.woohoosmart.ui.games;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.harish.woohoosmart.R;

public class Atmegames extends Fragment {
    WebView webView;
    String url ="https://play1025.atmegame.com/games/desert-champion#fullscreen";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.atmegames, container, false);
        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();

        // below line is setting toolbar color
        // for our custom chrome tab.
        customIntent.setToolbarColor(ContextCompat.getColor(getActivity(), R.color.purple_200));

        customIntent.enableUrlBarHiding();
        // we are calling below method after
        // setting our toolbar color.
        openCustomTab(myView.getContext(), customIntent.build(), Uri.parse(url));


        return myView;
    }
    public static void openCustomTab(Context activity, CustomTabsIntent customTabsIntent, Uri uri) {
        // package name is the default package
        // for our custom chrome tab
        String packageName = "com.android.chrome";
        if (packageName != null) {

            // we are checking if the package name is not null
            // if package name is not null then we are calling
            // that custom chrome tab with intent by passing its
            // package name.
            customTabsIntent.intent.setPackage(packageName);

            // in that custom tab intent we are passing
            // our url which we have to browse.
            customTabsIntent.launchUrl(activity, uri);
        } else {
            // if the custom tabs fails to load then we are simply
            // redirecting our user to users device default browser.
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
}


        /*webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://play766.atmegame.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return myView;
*/


        // return inflater.inflate(R.layout.fragment_about, container, false);



        }
