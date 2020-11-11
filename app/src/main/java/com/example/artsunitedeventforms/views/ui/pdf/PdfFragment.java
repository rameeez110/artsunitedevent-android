package com.example.artsunitedeventforms.views.ui.pdf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.artsunitedeventforms.databinding.FragmentPdfBinding;
import com.example.artsunitedeventforms.views.ui.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class PdfFragment extends Fragment {
	
	FragmentPdfBinding binding;
	PdfViewModel mViewModel;
	NavController navController;
	
	Handler emailHandler = new Handler(Looper.getMainLooper());
	Runnable emailRunnable = ()->{
		((MainActivity)requireActivity()).hideLoader();
		startActivity(Intent.createChooser(getEmailIntent(), "Choose an Email client :"));
	};
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		binding = FragmentPdfBinding.inflate(inflater, container, false);
		return binding.getRoot();
	}
	
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		
		super.onViewCreated(view, savedInstanceState);
		mViewModel = new ViewModelProvider(this).get(PdfViewModel.class);
		navController = Navigation.findNavController(view);
		
		emailHandler.postDelayed(emailRunnable,2000);
		
		mViewModel.setArgs(PdfFragmentArgs.fromBundle(getArguments()));
		
		binding.pdfView.fromUri(mViewModel.getArgs().getFileUri())
				.enableSwipe(true)
				.swipeHorizontal(false)
				.enableDoubletap(true)
				.defaultPage(0)
				.enableAnnotationRendering(false)
				.password(null)
				.scrollHandle(null)
				.enableAntialiasing(true)
				.spacing(0)
				.load();
	}
	
	
	@Override
	public void onDestroy() {
		
		super.onDestroy();
		emailHandler.removeCallbacks(emailRunnable);
	}
	
	
	public Intent getEmailIntent() {
		String mailTo = "";
		String ccAddress = mViewModel.getArgs().getFormName().getEmail();
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+mailTo));
		intent.putExtra(Intent.EXTRA_SUBJECT, mViewModel.getArgs().getFormName().getTitle());
		intent.putExtra(Intent.EXTRA_TEXT,
				"This is a PDF exported from the data you have entered.");
		intent.putExtra(Intent.EXTRA_CC, new String[] { ccAddress });
		intent.putExtra(Intent.EXTRA_STREAM, mViewModel.getArgs().getFileUri());
		return intent;
	}
}