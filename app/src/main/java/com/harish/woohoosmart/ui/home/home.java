package com.harish.woohoosmart.ui.home;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.harish.woohoosmart.R;

import com.harish.woohoosmart.scanbutt;
import com.harish.woohoosmart.smart_tools.Agecalculator;
import com.harish.woohoosmart.smart_tools.BmiActivity;
import com.harish.woohoosmart.smart_tools.STOPWATCH;
import com.harish.woohoosmart.smart_tools.agediffernce;
import com.harish.woohoosmart.smart_tools.compass;
import com.harish.woohoosmart.smart_tools.mirror;
import com.harish.woohoosmart.smart_tools.passwordgenerator;
import com.harish.woohoosmart.smart_tools.torchlight;


public class home extends Fragment implements View.OnClickListener {
    private LinearLayout myButton, myButton2, myButton3, myButton4, myButton5, myButton6,myButton7,myButton8,mybutton9;
    private TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        myButton = myView.findViewById(R.id.torch);
        myButton2 = myView.findViewById(R.id.mirror);
        myButton3 = myView.findViewById(R.id.Qrcode);
        myButton4 = myView.findViewById(R.id.compass);
        myButton5 = myView.findViewById(R.id.agecalc);
        myButton6 = myView.findViewById(R.id.agediff);
        myButton7 = myView.findViewById(R.id.bmical);
        myButton8 = myView.findViewById(R.id.timer);
        mybutton9 = myView.findViewById(R.id.passgenerta);
       textView =myView.findViewById(R.id.tooltxt);
        textView2 =myView.findViewById(R.id.trchtxt);
        textView3 =myView.findViewById(R.id.mirrtxt);
        textView4 =myView.findViewById(R.id.qrctxt);
        textView5 =myView.findViewById(R.id.stoptxt);
        textView6 =myView.findViewById(R.id.agecalctxt);
        textView7 =myView.findViewById(R.id.agedifftxt);
        textView8 =myView.findViewById(R.id.bmitxt);
        textView9 =myView.findViewById(R.id.timertxt);
        textView10 =myView.findViewById(R.id.psstxt);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/rbo.ttf");

        textView.setTypeface(type);
        textView2.setTypeface(type);
        textView3.setTypeface(type);
        textView4.setTypeface(type);
        textView5.setTypeface(type);
        textView6.setTypeface(type);
        textView7.setTypeface(type);
        textView8.setTypeface(type);
        textView9.setTypeface(type);
        textView10.setTypeface(type);
        myButton.setOnClickListener(this);
        myButton2.setOnClickListener(this);
        myButton3.setOnClickListener(this);
        myButton4.setOnClickListener(this);
        myButton5.setOnClickListener(this);
        myButton6.setOnClickListener(this);
        myButton7.setOnClickListener(this);
        myButton8.setOnClickListener(this);
        mybutton9.setOnClickListener(this);
return myView;

    }





    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.torch:

            case R.id.mirror:
                Intent intent2 = new Intent(getActivity().getApplicationContext(), mirror.class);
                startActivity(intent2);
                break;
            case R.id.Qrcode:
                Intent intent3 = new Intent(getActivity().getApplicationContext(), scanbutt.class);
                startActivity(intent3);
                break;
            case R.id.agecalc:
                Intent intent4 = new Intent(getActivity().getApplicationContext(), agediffernce.class);
                startActivity(intent4);
                break;
            case R.id.agediff:
                Intent intent5 = new Intent(getActivity().getApplicationContext(), Agecalculator.class);
                startActivity(intent5);
                break;
            case R.id.compass:
                Intent intent6 = new Intent(getActivity().getApplicationContext(), compass.class);
                startActivity(intent6);
                break;

            case R.id.bmical:
                Intent intent7 = new Intent(getActivity().getApplicationContext(), BmiActivity.class);
                startActivity(intent7);
                break;
            case R.id.timer:
                Intent intent8 = new Intent(getActivity().getApplicationContext(), STOPWATCH.class);
                startActivity(intent8);
                break;
            case R.id.passgenerta:
                Intent intent9 = new Intent(getActivity().getApplicationContext(), passwordgenerator.class);
                startActivity(intent9);
                break;
        }
    }
}

