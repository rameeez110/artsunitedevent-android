package com.example.artsunitedeventforms.data.local;

import com.example.artsunitedeventforms.BR;

import java.util.FormatFlagsConversionMismatchException;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class Answer extends BaseObservable {
	
	String date;
	String text;
	Boolean bool;
	
	public Answer(){
	    date = "";
	    text = "";
		bool = false;
	}
	
	@Bindable
	public String getDate() {
		
		return date;
	}
	
	public void setDate(String date) {
		
		this.date = date;
		notifyPropertyChanged(BR.date);
	}
	
	public String getText() {
		
		return text;
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	public Boolean getBool() {
		
		return bool;
	}
	
	public void setBool(Boolean bool) {
		
		this.bool = bool;
	}
	
	public String getFormatedBoolean() {
		
		if (getBool())
			return "yes";
		else
			return "no";
			
	}
}
