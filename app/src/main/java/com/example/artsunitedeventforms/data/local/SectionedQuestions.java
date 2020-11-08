package com.example.artsunitedeventforms.data.local;

import com.intrusoft.sectionedrecyclerview.Section;

import java.util.ArrayList;


public class SectionedQuestions implements Section<Question> {
	
	ArrayList<Question> questions;
	public String sectionTitle;
	
	public SectionedQuestions(ArrayList<Question> questions, String sectionTitle){
		this.sectionTitle = sectionTitle;
		this.questions = questions;
	}
	
	@Override
	public ArrayList<Question> getChildItems() {
		
		return questions;
	}
}
