package com.example.artsunitedeventforms.views.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.artsunitedeventforms.Utils.Utils;
import com.example.artsunitedeventforms.data.enums.Forms;
import com.example.artsunitedeventforms.databinding.FragmentDashboardBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class DashboardFragment extends Fragment implements View.OnClickListener {
    
    FragmentDashboardBinding binding;
    NavController navController;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ((MainActivity) getActivity()).getSupportActionBar().show();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        
        navController = Navigation.findNavController(view);
        
        initButtons();
    }
    
    @Override
    public void onClick(View view) {
        
        DashboardFragmentDirections.ActionDashboardFragmentToQuestionFragment action =
                DashboardFragmentDirections.actionDashboardFragmentToQuestionFragment((Forms.valueOf((String) view.getTag())));
        navController.navigate(action, Utils.getDefaultNavOptions(0, false));
    }
    
    public void initButtons() {
        
        binding.aucReportBtn.setOnClickListener(this);
        binding.alReportBtn.setOnClickListener(this);
        binding.aucMonitorBtn.setOnClickListener(this);
        binding.alMonitorBtn.setOnClickListener(this);
        binding.aucTechBtn.setOnClickListener(this);
        binding.alTechBtn.setOnClickListener(this);
    }
}