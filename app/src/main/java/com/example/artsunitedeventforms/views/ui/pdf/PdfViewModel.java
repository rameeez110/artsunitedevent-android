package com.example.artsunitedeventforms.views.ui.pdf;

import android.net.Uri;

import com.example.artsunitedeventforms.data.enums.Forms;

import java.net.URI;

import androidx.lifecycle.ViewModel;


public class PdfViewModel extends ViewModel {
	
	private PdfFragmentArgs args;
	
	
	public void setArgs(PdfFragmentArgs args) {
		
		this.args = args;
		
	}
	
	
	public PdfFragmentArgs getArgs() {
		
		return args;
	}
}
