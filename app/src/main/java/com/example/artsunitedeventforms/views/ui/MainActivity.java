package com.example.artsunitedeventforms.views.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.print.PDFPrint;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.Utils.DialogUtils;
import com.example.artsunitedeventforms.Utils.PdfHelper;
import com.example.artsunitedeventforms.data.enums.QuestionType;
import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.databinding.ActivityMainBinding;
import com.tejpratapsingh.pdfcreator.activity.PDFViewerActivity;
import com.tejpratapsingh.pdfcreator.utils.PDFUtil;

import java.io.File;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {

	ActivityMainBinding binding;
	AppBarConfiguration appBarConfiguration;
	NavController navController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		//generatePdf();
		
		NavHostFragment navHostFragment =
				(NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
		navController = navHostFragment.getNavController();
		appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		
		
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		if (!NavigationUI.navigateUp(navController, appBarConfiguration))
			finish();
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		
		switch (item.getItemId()) {
			case android.R.id.home:
				navController.navigateUp();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void showLoader(String message) {
		
		DialogUtils.showProgress(this,message);
	}
	
	public void hideLoader() {
		
		DialogUtils.hideProgress();
	}
}