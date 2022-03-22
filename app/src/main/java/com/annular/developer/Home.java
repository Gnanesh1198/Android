package com.annular.developer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Button;

import com.annular.developer.dashboardFragments.JobsAdapter;
import com.annular.developer.dashboardFragments.JobsModel;
import com.annular.developer.dashboardFragments.PostFragment;
import com.annular.developer.dashboardFragments.blogsFragment;
import com.annular.developer.dashboardFragments.jobsFragment;
import com.annular.developer.dashboardFragments.settingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Home extends AppCompatActivity {

    Button logout;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();


        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard,new jobsFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_jobs);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){


                    case  R.id.nav_jobs:
                        fragment = new jobsFragment();
                        break;
                    case  R.id.nav_blogs:
                        fragment = new blogsFragment();
                        break;
                    case  R.id.nav_post:
                        fragment = new PostFragment();
                        break;
                    case  R.id.nav_settings:
                        fragment = new settingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.dashboard,fragment).commit();

                return true;
            }
        });

//        logout = findViewById(R.id.button5);
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(), DeveloperLogin.class);
//                startActivity(intent);
//
//            }
//        });
    }

}