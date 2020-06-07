package com.codewithnayan.trafficsinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {

    private Button btn_about , btn_contact, btn_feedback, btn_version;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        // referencing the button of more fragment

        btn_about = view.findViewById(R.id.btn_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutUs.class);
                startActivity(intent);
            }
        });

        btn_contact = view.findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactUs.class);
                startActivity(intent);
            }
        });

        btn_feedback = view.findViewById(R.id.btn_feedback);
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Feedback.class);
                startActivity(intent);
            }
        });

        btn_version = view.findViewById(R.id.btn_version_control);
        btn_version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VersionControl.class);
                startActivity(intent);
            }
        });

        return view;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("More");
    }
}
