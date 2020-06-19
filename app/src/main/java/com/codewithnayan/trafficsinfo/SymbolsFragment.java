package com.codewithnayan.trafficsinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithnayan.trafficsinfo.Adapters.SymbolAdapter;
import com.codewithnayan.trafficsinfo.Models.SymbolModel;

import java.util.ArrayList;

public class SymbolsFragment extends Fragment {

    View rootView;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tsymbols, container, false);
        // referencing the recyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);


        // Giving Data to Adapter for tSymbols

        ArrayList<SymbolModel> list = new ArrayList<>();
        list.add(new SymbolModel(R.drawable.i , "10% Slope Danger Warning Road Sign"));
        list.add(new SymbolModel(R.drawable.ii, "Bike Path Road Sign"));
        list.add(new SymbolModel(R.drawable.iii, "Danger Warning River Bank Road Sign"));
        list.add(new SymbolModel(R.drawable.iv , "No Right Turn Traffic Sign"));
        list.add(new SymbolModel(R.drawable.v, "No Left Turn Traffic Sign"));
        list.add(new SymbolModel(R.drawable.vi , "Speed Limit Road Sign"));
        list.add(new SymbolModel(R.drawable.vii, "No Overtaking Road Sign"));
        list.add(new SymbolModel(R.drawable.viii, "Slippery Road Warning Sign"));
        list.add(new SymbolModel(R.drawable.ix, "Men At Work"));
        list.add(new SymbolModel(R.drawable.x, "No Motorcycles Road Sign"));
        list.add(new SymbolModel(R.drawable.xi , "3.5T Restriction Truck Road Sign"));
        list.add(new SymbolModel(R.drawable.xii, "One Way Street Road Sign"));
        list.add(new SymbolModel(R.drawable.xiii, "No Entry Traffic Sign"));
        list.add(new SymbolModel(R.drawable.xiv, "Zigzag Road Warning Road Sign"));
        list.add(new SymbolModel(R.drawable.xv, "Width Restriction Road Sign"));
        list.add(new SymbolModel(R.drawable.xvi, "Stop Sign on Pole"));
        list.add(new SymbolModel(R.drawable.xvii, "Children Traffic Sign"));



        SymbolAdapter adapter = new SymbolAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);

        // GridLayout for tSymbols
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);


        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Traffic Symbols");
    }
}
