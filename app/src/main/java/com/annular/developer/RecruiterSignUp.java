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

import com.annular.developer.recruiterDto.RecruiterReqDto;
import com.annular.developer.recruiterDto.RecruiterRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecruiterSignUp extends AppCompatActivity {

    TextView clickHere;
    Button signup;
    EditText emailId,username,mobile,password,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_sign_up);

        clickHere = (TextView)findViewById(R.id.clickHereTectView);
        signup = (Button) findViewById(R.id.register);
        emailId = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.EditTextUsername);
        mobile = (EditText) findViewById(R.id.editTextmobile);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        confirmPassword = (EditText) findViewById(R.id.editTextTextPassword4);


        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecruiterSignUp.this,RecruiterLogin.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(emailId.getText().toString()) ||
                        TextUtils.isEmpty(username.getText().toString()) ||
                        TextUtils.isEmpty(mobile.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString()) ||
                        TextUtils.isEmpty(confirmPassword.getText().toString())){
                    String message = "All Inputs Required";
                    Toast.makeText(RecruiterSignUp.this,message,Toast.LENGTH_LONG).show();
                }else{
                    RecruiterReqDto recruiterReqDto = new RecruiterReqDto();
                    recruiterReqDto.setEmail_id(emailId.getText().toString());
                    recruiterReqDto.setUsername(username.getText().toString());
                    recruiterReqDto.setMobile(mobile.getText().toString());
                    if(password.getText().toString().equals(confirmPassword.getText().toString())){
                        recruiterReqDto.setPassword(password.getText().toString());
                        recruiterSignup(recruiterReqDto);

                    }else{
                        Toast.makeText(RecruiterSignUp.this,"Password does not match",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }

    public void recruiterSignup(RecruiterReqDto recruiterReqDto) {
        Call<RecruiterRes> recruiterResCall = ApiClient.getservice().recruiterSignup(recruiterReqDto);
        recruiterResCall.enqueue(new Callback<RecruiterRes>() {
            @Override
            public void onResponse(Call<RecruiterRes> call, Response<RecruiterRes> response) {
                if(response.isSuccessful()){
                    String email = response.body().getEmail_id().toString();
//                    if(email.equals(emailId)){
                        Toast.makeText(RecruiterSignUp.this,"Registered Successfull",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RecruiterSignUp.this,RecruiterLogin.class);
                        startActivity(intent);
//                    }else{
//                        Toast.makeText(RecruiterSignUp.this,"Email Id Already Exists",Toast.LENGTH_LONG).show();
//                    }

                }else{
                    Toast.makeText(RecruiterSignUp.this,"No Response From Server",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecruiterRes> call, Throwable throwable) {
                String message = throwable.getLocalizedMessage();
                Toast.makeText(RecruiterSignUp.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
}