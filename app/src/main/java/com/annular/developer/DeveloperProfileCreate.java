package com.annular.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeveloperProfileCreate extends AppCompatActivity {

    public static String PREFER_NAME="file";

    Button signup;
    EditText username, mobile, skills, experience, project,email;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_profile_create);

        signup = findViewById(R.id.button3);
        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        skills = findViewById(R.id.skills);
        experience = findViewById(R.id.experience);
        project = findViewById(R.id.projects);
        name = findViewById(R.id.textView4);
        email = findViewById(R.id.editTextTextEmailAddress);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
        }



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(DeveloperProfileCreate.PREFER_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",true);
                editor.commit();

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(mobile.getText().toString()) || TextUtils.isEmpty(skills.getText().toString()) || TextUtils.isEmpty(experience.getText().toString()) || TextUtils.isEmpty(project.getText().toString())){
                    String message = "All inputs required";
                    Toast.makeText(DeveloperProfileCreate.this,message,Toast.LENGTH_LONG).show();
                }else {
                    RegisterReq registerReq = new RegisterReq();
                    registerReq.setUsername(username.getText().toString());
                    registerReq.setMobile(mobile.getText().toString());
                    registerReq.setSkills(skills.getText().toString());
                    registerReq.setExperience(experience.getText().toString());
                    registerReq.setProject(project.getText().toString());
                    registerReq.setEmail(email.getText().toString());
                    registerUser(registerReq);
                }
            }
        });
    }

        public void registerUser(RegisterReq registerReq){
            Call<RegisterRes> registerResCall = ApiClient.getservice().registerUser(registerReq);
            registerResCall.enqueue(new Callback<RegisterRes>() {
                @Override
                public void onResponse(Call<RegisterRes> call, Response<RegisterRes> response) {
                    Toast.makeText(DeveloperProfileCreate.this,response.message(),Toast.LENGTH_LONG).show();
                    if(response.isSuccessful()){
                        String message = "Profile created successfully";
                        Toast.makeText(DeveloperProfileCreate.this,message,Toast.LENGTH_LONG).show();

                        Intent main = new Intent(DeveloperProfileCreate.this,Home.class);
                        startActivity(main);
                        finish();

                    }else{
                        String message = "Please try again later";
                        Toast.makeText(DeveloperProfileCreate.this,message,Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<RegisterRes> call, Throwable throwable) {
                    String message = throwable.getLocalizedMessage();
                    Toast.makeText(DeveloperProfileCreate.this,message,Toast.LENGTH_LONG).show();
                }
            });
        }


    }
