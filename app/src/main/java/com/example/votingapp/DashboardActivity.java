package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeFragment:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.candidateListFragment:
                    loadFragment(new CandidateListFragment());
                    return true;
                case R.id.electionListFragment:
                    loadFragment(new ElectionListFragment());
                    return true;
                case R.id.dashboardFragment:
                    loadFragment(new DashboardFragment());
                    return true;
                default:
                    return false;
            }
        });

        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}