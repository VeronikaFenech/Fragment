package sss.com.fragments;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "ON_CREATE");
        viewPager = findViewById(R.id.containerLay);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), Arrays.asList(new Monday(), new Tuesday(), new Wednesday(),new Thursday(),new Friday(),new Sunday(),new Saturday()));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void addFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(viewPager.getId(), new Monday(),"Monday");
    }


}