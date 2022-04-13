package com.annular.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {



//checking

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(DeveloperProfileCreate.PREFER_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);

                SharedPreferences sharedPreferences1 = getSharedPreferences(RecruiterSignUp.PREFER_NAME1,0);
                boolean hasLoggedIn1 = sharedPreferences1.getBoolean("hasLoggedIn1",false);

                if(hasLoggedIn){
                    Intent main = new Intent(MainActivity.this, Home.class);
                    startActivity(main);
                }else if(hasLoggedIn1){
                    Intent main = new Intent(MainActivity.this, RecruiterLogin.class);
                    startActivity(main);
                }else{
                    Intent main = new Intent(MainActivity.this, DeveloperConnect.class);
                    startActivity(main);
                }
                }
        },3000);
    }
}