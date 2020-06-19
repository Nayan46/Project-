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
        list1.add(new RuleModel("1.   While driving always carry your driving license and \n      important documents such as your vehicle registration \n      certificate."));
        list1.add(new RuleModel("2.   MUST NOT carry more than one pillion rider and he/ \n      she MUST sit astride the machine on a proper seat and \n      should keep both feet on the footrests."));
        list1.add(new RuleModel("3.   You should be aware of what is behind and in the sides \n       before maneuvering. Look behind you; use mirrors if \n       they are fitted."));
        list1.add(new RuleModel("4.    Never Drink while driving."));
        list1.add(new RuleModel("5.    Follow the traffic signals, lights and signs."));
        list1.add(new RuleModel("6.    Avoid using the cell phone when driving. If urgent \n       move to left, stop and then take the call."));
        list1.add(new RuleModel("7.     Always use a helmet."));
        list1.add(new RuleModel("8.    Do not ride or wheel your vehicle on to the footpath."));
        list1.add(new RuleModel("9.    Understand the signals given by other road users and \n       use the same when riding."));
        list1.add(new RuleModel("10.   Never stop abruptly in traffic. Move to the left and \n        slow down."));
        list1.add(new RuleModel("11.   MUST wear a protective helmet. Helmets MUST \n        comply with the Regulations and they MUST be \n        fastened securely."));
        list1.add(new RuleModel("12.   Don't sit children on fuel tanks or stand them in front \n        of the rider"));
        list1.add(new RuleModel("13.   Dangerous Curse To Left Road Sign"));
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Traffic Rules");
    }
}
