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
        list.add(new SymbolModel(R.drawable.i , R.string.aa));
        list.add(new SymbolModel(R.drawable.ii, R.string.bb));
        list.add(new SymbolModel(R.drawable.iii, R.string.cc));
        list.add(new SymbolModel(R.drawable.iv , R.string.dd));
        list.add(new SymbolModel(R.drawable.v, R.string.ee));
        list.add(new SymbolModel(R.drawable.vi , R.string.ff));
        list.add(new SymbolModel(R.drawable.vii, R.string.gg));
        list.add(new SymbolModel(R.drawable.viii, R.string.hh));
        list.add(new SymbolModel(R.drawable.ix, R.string.ii));
        list.add(new SymbolModel(R.drawable.x, R.string.jj));
        list.add(new SymbolModel(R.drawable.xi , R.string.kk));
        list.add(new SymbolModel(R.drawable.xii, R.string.ll));
        list.add(new SymbolModel(R.drawable.xiii, R.string.mm));
        list.add(new SymbolModel(R.drawable.xiv, R.string.nn));
        list.add(new SymbolModel(R.drawable.xv, R.string.oo));
        list.add(new SymbolModel(R.drawable.xvi, R.string.pp));
        list.add(new SymbolModel(R.drawable.xvii, R.string.qq));


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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_tsymbols);
    }
}
