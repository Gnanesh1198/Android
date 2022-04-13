package com.annular.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.annular.developer.recruiterDto.RecruiterLoginReq;
import com.annular.developer.recruiterDto.RecruiterLoginRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecruiterLogin extends AppCompatActivity {


    TextView register;
    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_login);

        getSupportActionBar().hide();

//        register.findViewById(R.id.reg);

        register = (TextView)findViewById(R.id.reg);
        email = (EditText)findViewById(R.id.editTextLoginEmail);
        password = (EditText)findViewById(R.id.editTextLoginPassword);
        login = (Button)findViewById(R.id.login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RecruiterLogin.this,RecruiterSignUp.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    String message = "All Inputs Required";
                    Toast.makeText(RecruiterLogin.this,message,Toast.LENGTH_LONG).show();
                }else{
                    RecruiterLoginReq recruiterLoginReq = new RecruiterLoginReq();
                    recruiterLoginReq.setEmail_id(email.getText().toString());
                    recruiterLoginReq.setPassword(password.getText().toString());
                    recruiterLogin(recruiterLoginReq);

                }
            }
        });
    }

    public void recruiterLogin(RecruiterLoginReq recruiterLoginReq) {
        Call<RecruiterLoginRes> recruiterLoginResCall =ApiClient.getservice().recruiterLogin(recruiterLoginReq.getEmail_id(),recruiterLoginReq.getPassword());
        recruiterLoginResCall.enqueue(new Callback<RecruiterLoginRes>() {
            @Override
            public void onResponse(Call<RecruiterLoginRes> call, Response<RecruiterLoginRes> response) {
                if(response.isSuccessful()){
                    Intent intent =new Intent(RecruiterLogin.this,RecruiterPage.class);
                    startActivity(intent);
                }else{
                    String message = "Incorrect Password";
                    Toast.makeText(RecruiterLogin.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecruiterLoginRes> call, Throwable throwable) {
                String message = throwable.getLocalizedMessage();
                Toast.makeText(RecruiterLogin.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
}