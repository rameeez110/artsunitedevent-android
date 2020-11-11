package com.example.artsunitedeventforms.views.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.Utils.Utils;


public class SplashFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ((MainActivity) getActivity()).getSupportActionBar().hide();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        
        NavController navController = Navigation.findNavController(view);
        
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            
            int destination;
            if (Utils.getTermsConditionAccept(getContext()))
                destination = R.id.dashboardFragment;
            else
                destination = R.id.termsConditionFragment;
            
            navController.navigate(destination, null, Utils.getDefaultNavOptions(R.id.splashFragment, true));
        }, 2000);
    }
}