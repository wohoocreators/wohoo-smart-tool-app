package com.harish.woohoosmart.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harish.woohoosmart.R;
import com.harish.woohoosmart.daily_quotes.SadQuotes;
import com.harish.woohoosmart.smart_tools.STOPWATCH;

public class splash_screen extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView=findViewById(R.id.namen);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/splsh.ttf");
       textView.setTypeface(type);
    getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    Thread thread=new Thread()
        {

            public void run(){

                try{
                   sleep(2090);

                }catch (Exception ex){
                    ex.printStackTrace();

                }
                finally {
                    getdata();

                }
            }

        };thread.start();

    }
    private void getdata()
    {

        FirebaseDatabase firebaseDatabase;
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference1234 ;
        databaseReference1234 = firebaseDatabase.getReference("reponse");

        // calling add value event listener method
        // for getting the values from database.
        databaseReference1234.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                Boolean value = snapshot.getValue(Boolean.class);

                Log.d("FIREBASEACTIVITY",""+value);
                if (value==true){
                    Intent intent= new Intent(getApplication(), AppinProg.class);
                    startActivity(intent);
                    finish();
                }else {

                    Intent inten=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(inten);
                    finish();
                }
                // after getting the value we are setting
                // our value to our text view in below line.

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