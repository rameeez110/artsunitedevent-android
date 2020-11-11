package com.example.artsunitedeventforms.views.ui.question;

import android.net.Uri;
import android.os.Bundle;
import android.print.PDFPrint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.Utils.DialogUtils;
import com.example.artsunitedeventforms.Utils.FormManager;
import com.example.artsunitedeventforms.Utils.PdfHelper;
import com.example.artsunitedeventforms.Utils.Utils;
import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.data.local.SectionedQuestions;
import com.example.artsunitedeventforms.databinding.FragmentQuestionBinding;
import com.example.artsunitedeventforms.views.adapters.QuestionsAdapter;
import com.example.artsunitedeventforms.views.ui.MainActivity;
import com.tejpratapsingh.pdfcreator.utils.PDFUtil;

import java.io.File;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;


public class QuestionFragment extends Fragment {
    
    private FragmentQuestionBinding binding;
    private QuestionViewModel mViewModel;
    private NavController navController;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        
        binding = FragmentQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        
        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        navController = Navigation.findNavController(view);
        
        mViewModel.setArgs(QuestionFragmentArgs.fromBundle(getArguments()));
        
        setHasOptionsMenu(true);
        
        setListeners();
    }
    
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        
        inflater.inflate(R.menu.menu_main, menu);
        
        ((MainActivity) requireActivity()).getSupportActionBar()
                .setTitle(mViewModel.getArgs().getFormName().getFullName());
        
        menu.findItem(R.id.menu_submit).setVisible(true);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        switch (item.getItemId()) {
            //case android.R.id.home:
            //    navController.popBackStack(R.id.dashboardFragment, false);
            //    break;
            
            case R.id.menu_submit:
	            showConfirmationDialog();
                break;
        }
        return true;
    }
    
    public void setListeners() {
        
        mViewModel.getQuestionsLiveData().observe(getViewLifecycleOwner(), questions -> {
            
            setRecyclerView(questions);
        });
    }
    
    public void setRecyclerView(ArrayList<SectionedQuestions> questions) {
        
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.questionRecyclerView.setLayoutManager(linearLayoutManager);
        binding.questionRecyclerView.setHasFixedSize(true);
        
        QuestionsAdapter adapterRecycler = new QuestionsAdapter(getContext(), questions);
        binding.questionRecyclerView.setAdapter(adapterRecycler);
    }
    
    private void generatePdf() {
	
	    ((MainActivity) requireActivity()).showLoader("Generating pdf...");
	    
        String title = mViewModel.getArgs().getFormName().getTitle();
        
        ArrayList<Question> questions = mViewModel.getAllQuestions();
        questions.add(FormManager.getPdfIncludedField());
        
        File pdfFile = PdfHelper.createFile(getContext());
        
        PDFUtil.generatePDFFromHTML(getContext(), pdfFile,
                PdfHelper.getHtmlString(title, questions),
                new PDFPrint.OnPDFPrintListener() {
                    @Override
                    public void onSuccess(File file) {
                        
                        Uri pdfUri = Uri.fromFile(pdfFile);
                        QuestionFragmentDirections.ActionQuestionFragmentToPdfFragment action =
                                QuestionFragmentDirections.actionQuestionFragmentToPdfFragment(mViewModel.getArgs().getFormName());
                        action.setFileUri(pdfUri);
                        
                        navController.navigate(action, Utils.getDefaultNavOptions(0, false));
                    }
                    
                    @Override
                    public void onError(Exception exception) {
	
	                    ((MainActivity) requireActivity()).hideLoader();
	                    
                        Log.e("d", "QuestionFragmentLogData->onError(): EXCEPTION CAUGHT\n"
                                           + Log.getStackTraceString(exception));
                    }
                });
    }
	
	public void showConfirmationDialog() {
		
		DialogUtils.showConfirmationDialog(getContext(), () -> generatePdf(),null);
	}
}