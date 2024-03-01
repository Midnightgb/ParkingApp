package com.example.parkingapp.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentHomeBinding;
import com.example.parkingapp.MainActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    TextView tvUsername;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Context context = root.getContext();
        tvUsername = root.findViewById(R.id.tvUsername);
        SharedPreferences sharedPref = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);
        tvUsername.setText(sharedPref.getString("name", "¿Quién eres?"));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}