package com.harish.woohoosmart.ui.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.harish.woohoosmart.R;
import com.harish.woohoosmart.WebActivity;
import com.harish.woohoosmart.social_media.Amazon;
import com.harish.woohoosmart.social_media.Facebook;
import com.harish.woohoosmart.social_media.Flipkart;
import com.harish.woohoosmart.social_media.Gmail;
import com.harish.woohoosmart.social_media.Instagram;
import com.harish.woohoosmart.social_media.Linklidin;
import com.harish.woohoosmart.social_media.Meesho;
import com.harish.woohoosmart.social_media.Pinterest;
import com.harish.woohoosmart.social_media.Quora;
import com.harish.woohoosmart.social_media.Twitter;
import com.harish.woohoosmart.social_media.Wikipedia;
import com.harish.woohoosmart.social_media.Youtube;
import com.harish.woohoosmart.view.MainActivity;


public class about extends Fragment implements View.OnClickListener {
    private LinearLayout myButton,myButton2,myButton3,myButton4,myButton5,myButton6,myButton7,myButton8,myButton9,myButton10,myButton11,myButton12;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myView = inflater.inflate(R.layout.fragment_about, container, false);



        myButton =  myView.findViewById(R.id.facebook);
        myButton2 = myView.findViewById(R.id.twitter);
        myButton3 = myView.findViewById(R.id.instagram);
        myButton4 = myView.findViewById(R.id.gmail);
        myButton5 = myView.findViewById(R.id.youtube);
        myButton6 = myView.findViewById(R.id.linklidin);

        myButton7 = myView.findViewById(R.id.pintrest);
        myButton8 = myView.findViewById(R.id.wikipedia);
        myButton9 = myView.findViewById(R.id.quora);
        myButton10 = myView.findViewById(R.id.flipkart);
        myButton11 = myView.findViewById(R.id.amazon);
        myButton12 = myView.findViewById(R.id.meesho);
        myButton.setOnClickListener(this);
        myButton2.setOnClickListener(this);
        myButton3.setOnClickListener(this);
        myButton4.setOnClickListener(this);

        myButton5.setOnClickListener(this);
        myButton6.setOnClickListener(this);
        myButton7.setOnClickListener(this);
        myButton8.setOnClickListener(this);
        myButton9.setOnClickListener(this);
        myButton10.setOnClickListener(this);

        myButton11.setOnClickListener(this);
        myButton12.setOnClickListener(this);
        return myView;


       // return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WebActivity.class);
        switch (v.getId()) {
            case R.id.facebook:
            /*    Intent intent = new Intent(getActivity().getApplicationContext(), Facebook.class);
                startActivity(intent);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.twitter:
               /* Intent intent2 = new Intent(getActivity().getApplicationContext(), Twitter.class);
                startActivity(intent2);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.instagram:
               /* Intent intent3 = new Intent(getActivity().getApplicationContext(), Instagram.class);
                startActivity(intent3);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.gmail:
               /* Intent intent4 = new Intent(getActivity().getApplicationContext(), Gmail.class);
                startActivity(intent4);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.youtube:
               /* Intent intent5 = new Intent(getActivity().getApplicationContext(), Youtube.class);
                startActivity(intent5);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.linklidin:
               /* Intent intent6 = new Intent(getActivity().getApplicationContext(), Linklidin.class);
                startActivity(intent6);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.pintrest:
               /* Intent intent7 = new Intent(getActivity().getApplicationContext(), Pinterest.class);
                startActivity(intent7);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.wikipedia:
                /*Intent intent8 = new Intent(getActivity().getApplicationContext(), Wikipedia.class);
                startActivity(intent8);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.quora:
                /*Intent intent9 = new Intent(getActivity().getApplicationContext(), Quora.class);
                startActivity(intent9);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.flipkart:
               /* Intent intent10 = new Intent(getActivity().getApplicationContext(), Flipkart.class);
                startActivity(intent10);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.amazon:
            /*    Intent intent11 = new Intent(getActivity().getApplicationContext(), Amazon.class);
                startActivity(intent11);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;
            case R.id.meesho:
                /*Intent intent12 = new Intent(getActivity().getApplicationContext(), Meesho.class);
                startActivity(intent12);*/
                intent.putExtra("url","https://www.amazon.in/");
                break;

        }
        startActivity(intent);
    }
}