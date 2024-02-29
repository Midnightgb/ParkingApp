package com.example.parkingapp.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkingapp.databinding.FragmentProfileBinding;
import com.example.parkingapp.ui.authentication.LoginActivity;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    LinearLayout logoutBtn;
    TextView userEmail, userName;
    Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        logoutBtn = binding.logoutBtn;
        userEmail = binding.userEmail;
        userName = binding.userName;


        SharedPreferences sharedPreferences = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);
        String userEmailKey = sharedPreferences.getString("email", null);
        String userNameKey = sharedPreferences.getString("name", null);

        userEmail.setText(userEmailKey);
        userName.setText(userNameKey);

        logoutBtn.setOnClickListener(this::logout);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void logout(View view){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}