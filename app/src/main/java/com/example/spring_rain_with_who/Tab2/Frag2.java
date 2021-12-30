package com.example.spring_rain_with_who.Tab2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.spring_rain_with_who.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag2 extends Fragment {

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab2_main, container, false);

        ImageView Album1 = (ImageView) v.findViewById(R.id.imageView1);
        ImageView Album2 = (ImageView) v.findViewById(R.id.imageView2);
        ImageView Album3 = (ImageView) v.findViewById(R.id.imageView3);
        ImageView Album4 = (ImageView) v.findViewById(R.id.imageView4);

        Album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SubActivity1.class);
                startActivity(intent);
            }
        });
        Album2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SubActivity2.class);
                startActivity(intent);
            }
        });
        Album3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SubActivity3.class);
                startActivity(intent);
            }
        });
        Album4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SubActivity4.class);
                startActivity(intent);
            }
        });

        return v;
    }
}