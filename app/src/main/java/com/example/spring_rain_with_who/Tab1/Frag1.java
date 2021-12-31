package com.example.spring_rain_with_who.Tab1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spring_rain_with_who.R;

import java.util.ArrayList;

public class Frag1 extends Fragment {

    private ArrayList<Item> items = new ArrayList<>();

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1_main, container, false);

        initDataset();

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter adapter = new ItemAdapter(context, items);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initDataset(){
        items.clear();
        items.add(new Item("강준서", "000-0000-0000", R.drawable.ic_launcher_foreground));
        items.add(new Item("임승재", "111-1111-1111", R.drawable.ic_launcher_foreground));
    }
}