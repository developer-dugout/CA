package com.coding.pixel.ca.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coding.pixel.ca.R;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class JobsFragment extends Fragment {


    public JobsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_jobs, container, false);
        LayoutInflater lf = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_jobs, container, false);

        TextView one = view.findViewById(R.id.last_date_one);
        one.setSelected(true);
        TextView two = view.findViewById(R.id.last_date_two);
        two.setSelected(true);
        TextView three = view.findViewById(R.id.last_date_three);
        three.setSelected(true);
        TextView four = view.findViewById(R.id.last_date_four);
        four.setSelected(true);
        TextView five = view.findViewById(R.id.last_date_five);
        five.setSelected(true);
        TextView six = view.findViewById(R.id.last_date_six);
        six.setSelected(true);
        TextView seven = view.findViewById(R.id.last_date_seven);
        seven.setSelected(true);
        TextView eight = view.findViewById(R.id.last_date_eight);
        eight.setSelected(true);
        TextView nine = view.findViewById(R.id.last_date_nine);
        nine.setSelected(true);
        TextView ten = view.findViewById(R.id.last_date_ten);
        ten.setSelected(true);



        return view;
    }

}
