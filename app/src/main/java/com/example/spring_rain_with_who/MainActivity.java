package com.example.spring_rain_with_who;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.spring_rain_with_who.Tab0.Frag0;
import com.example.spring_rain_with_who.Tab1.Frag1;
import com.example.spring_rain_with_who.Tab2.Frag2;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
        adapter = new FragmentAdapter(getSupportFragmentManager(), 1);

        adapter.addFragment(new Frag0());
        adapter.addFragment(new Frag1());
        adapter.addFragment(new Frag2());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("A");
        tabLayout.getTabAt(1).setText("B");
        tabLayout.getTabAt(2).setText("C");
    }
}