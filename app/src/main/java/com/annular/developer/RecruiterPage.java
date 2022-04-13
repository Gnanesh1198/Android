package com.annular.developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.annular.developer.recruiterDashboardFragments.RecruiterBidding;
import com.annular.developer.recruiterDashboardFragments.RecruiterHome;
import com.annular.developer.recruiterDashboardFragments.RecruiterProfile;
import com.annular.developer.recruiterDashboardFragments.RecruiterSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RecruiterPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_page);

        bottomNavigationView = findViewById(R.id.recruiter_bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.recruiter_dashboard,new RecruiterHome()).commit();
        bottomNavigationView.setSelectedItemId(R.id.rec_home_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case  R.id.rec_home_nav:
                        fragment = new RecruiterHome();
//                        setFragment(new RecruiterHome());
                        break;
                    case  R.id.rec_profile_nav:
                        fragment = new RecruiterProfile();
                        break;
                    case  R.id.rec_bidding_nav:
                        fragment = new RecruiterBidding();
                        break;
                    case  R.id.rec_setting_nav:
                        fragment = new RecruiterSetting();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.recruiter_dashboard,fragment).commit();
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.recriuter_page_home,fragment);
        fragmentTransaction.commit();

    }
}