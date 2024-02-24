package com.example.parkingapp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentHomeBinding;
import com.example.parkingapp.MainActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    Button btnSection1;
    Button btnSection2;
    LinearLayout section1;
    LinearLayout section2;
    LinearLayout detail_parking;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Context context = root.getContext();
        btnSection1 = root.findViewById(R.id.btnSection1);
        btnSection2 = root.findViewById(R.id.btnSection2);
        section1 = root.findViewById(R.id.fragmentContainerView1);
        section2 = root.findViewById(R.id.fragmentContainerView2);
        detail_parking = root.findViewById(R.id.detail_parking);


        btnSection1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(section2, section1);
            }
        });

        btnSection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(detail_parking, section2);
            }
        });

        return root;
    }

    public void switchSection(View section, View previousSection) {
        if (section.getVisibility() == View.GONE) {
            section.setVisibility(View.VISIBLE);
            previousSection.setVisibility(View.GONE);
        } else {
            section.setVisibility(View.GONE);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}