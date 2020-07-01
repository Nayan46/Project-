package com.codewithnayan.trafficsinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithnayan.trafficsinfo.Adapters.RuleAdapter;
import com.codewithnayan.trafficsinfo.Models.RuleModel;
import com.codewithnayan.trafficsinfo.Models.SymbolModel;

import java.util.ArrayList;

public class RulesFragment extends Fragment {

    View rootView;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_trules, container, false);
        recyclerView = rootView.findViewById(R.id.rv_trules);


        ArrayList<RuleModel> list1 = new ArrayList<>();
        list1.add(new RuleModel(R.string.aaa));
        list1.add(new RuleModel(R.string.bbb));
        list1.add(new RuleModel(R.string.ccc));
        list1.add(new RuleModel(R.string.ddd));
        list1.add(new RuleModel(R.string.eee));
        list1.add(new RuleModel(R.string.fff));
        list1.add(new RuleModel(R.string.ggg));
        list1.add(new RuleModel(R.string.hhh));
        list1.add(new RuleModel(R.string.iii));
        list1.add(new RuleModel(R.string.jjj));
        list1.add(new RuleModel(R.string.kkk));
        list1.add(new RuleModel(R.string.lll));
        list1.add(new RuleModel(R.string.mmm));
        RuleAdapter adapter1 = new RuleAdapter(list1, getActivity());
        recyclerView.setAdapter(adapter1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return rootView;

    }


    // Setting the title in a fragment

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_trules);
    }
}
