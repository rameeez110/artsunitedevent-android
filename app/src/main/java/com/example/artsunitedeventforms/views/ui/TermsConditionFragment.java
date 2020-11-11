package com.example.artsunitedeventforms.views.ui;

import android.icu.util.UniversalTimeScale;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.Utils.Utils;
import com.example.artsunitedeventforms.databinding.FragmentTermsConditionBinding;
import com.google.android.material.snackbar.Snackbar;


public class TermsConditionFragment extends Fragment {
    
    FragmentTermsConditionBinding binding;
    Snackbar snackbar ;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTermsConditionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ((MainActivity) getActivity()).getSupportActionBar().show();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        
        NavController navController = Navigation.findNavController(view);
        
        binding.termsConditionNext.setOnClickListener(v -> {
            
            if (binding.termsCondtionSwitch.isChecked()) {
                Utils.saveTermsConditionAccept(getContext(), binding.termsCondtionSwitch.isChecked());
    
                int destination = R.id.dashboardFragment;
                navController.navigate(destination, null, Utils.getDefaultNavOptions(R.id.termsConditionFragment, true));
                
                if (snackbar !=null)
                    snackbar.dismiss();
            }
            else
               snackbar = Utils.showSnackBar(getActivity(),
                       "Please accept the terms and conditions");
        });
    }
}