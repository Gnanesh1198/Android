package com.annular.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DeveloperConnect extends AppCompatActivity {

    Button developer;
    Button recruiter;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_connect);

        developer = findViewById(R.id.button);
        recruiter = findViewById(R.id.button2);

//        FirebaseUser user = mAuth.getCurrentUser();
//        if(user != null){
//            Intent intent = new Intent(DeveloperConnect.this,Home.class);
//            startActivity(intent);
//        }



        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(DeveloperConnect.this, DeveloperLogin.class);
                    startActivity(intent);

            }
        });

        recruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DeveloperConnect.this, "Login to your account or register", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DeveloperConnect.this, RecruiterLogin.class);
                startActivity(intent);
            }
        });
    }
    }
