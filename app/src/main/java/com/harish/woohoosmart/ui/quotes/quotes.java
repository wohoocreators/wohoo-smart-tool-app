package com.harish.woohoosmart.ui.quotes;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.harish.woohoosmart.R;
import com.harish.woohoosmart.daily_quotes.Birthdayquotes;
import com.harish.woohoosmart.daily_quotes.FrndQuotes;
import com.harish.woohoosmart.daily_quotes.Funnyquote;
import com.harish.woohoosmart.daily_quotes.LoveQuotes;
import com.harish.woohoosmart.daily_quotes.MotivatonQuotes;
import com.harish.woohoosmart.daily_quotes.SadQuotes;


public class quotes extends Fragment implements View.OnClickListener {


    private TextView retrieveTV;
   private  LinearLayout myButton,myButton2,myButton3,myButton4,myButton5,myButton6;
    private TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



   //     View myView2 = inflater.inflate(R.layout.fragment_quotes, container, false);

        View myView = inflater.inflate(R.layout.fragment_quotes, container, false);

        textView =myView.findViewById(R.id.motxt);
        textView2 =myView.findViewById(R.id.lovetxt);
        textView3 =myView.findViewById(R.id.frndtxt);
        textView4 =myView.findViewById(R.id.sadtxt);
        textView5 =myView.findViewById(R.id.dailyquotetxt);
        textView6 =myView.findViewById(R.id.funtxt);
        textView7 =myView.findViewById(R.id.birtxt);


        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/rbo.ttf");
        textView.setTypeface(type);
        textView2.setTypeface(type);
        textView3.setTypeface(type);
        textView4.setTypeface(type);
        textView5.setTypeface(type);
        textView6.setTypeface(type);
        textView7.setTypeface(type);


       myButton =  myView.findViewById(R.id.motivat);
       myButton2 = myView.findViewById(R.id.lov);
        myButton3 = myView.findViewById(R.id.sadqq);
        myButton4 = myView.findViewById(R.id.friednint);
        myButton5 = myView.findViewById(R.id.fqs);
        myButton6 = myView.findViewById(R.id.birth);
        myButton.setOnClickListener(this);
        myButton2.setOnClickListener(this);
        myButton3.setOnClickListener(this);
        myButton4.setOnClickListener(this);

        myButton5.setOnClickListener(this);
        myButton6.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.motivat:
                Intent intent = new Intent(getActivity().getApplicationContext(), LoveQuotes.class);
                startActivity(intent);
                break;
            case R.id.lov:
                Intent intent2 = new Intent(getActivity().getApplicationContext(), MotivatonQuotes.class);
                startActivity(intent2);
                break;
            case R.id.sadqq:
                Intent intent3 = new Intent(getActivity().getApplicationContext(), SadQuotes.class);
                startActivity(intent3);
                break;
            case R.id.friednint:
                Intent intent4 = new Intent(getActivity().getApplicationContext(), FrndQuotes.class);
                startActivity(intent4);
                break;
            case R.id.fqs:
                Intent intent5 = new Intent(getActivity().getApplicationContext(), Funnyquote.class);
                startActivity(intent5);
                break;
            case R.id.birth:
                Intent intent6 = new Intent(getActivity().getApplicationContext(), Birthdayquotes.class);
                startActivity(intent6);
                break;
        }

    }





          // return inflater.inflate(R.layout.fragment_quotes, container, false);


    }
