package com.example.artsunitedeventforms.data.local;


import com.example.artsunitedeventforms.data.enums.QuestionType;

import androidx.databinding.BaseObservable;


public class Question extends BaseObservable {
	
	String question;
	Answer answer;
	QuestionType type;
	
	public Question(String question,QuestionType questionType){
	 
		this.question = question;
		this.type = questionType;
		
		answer = new Answer();
	}
	
	public String getQuestion() {
		
		return question;
	}
	
	public void setQuestion(String question) {
		
		this.question = question;
	}
	
	public Answer getAnswer() {
		
		return answer;
	}
	
	public void setAnswer(Answer answer) {
		
		this.answer = answer;
	}
	
	public QuestionType getType() {
		
		return type;
	}
	
	public void setType(QuestionType type) {
		
		this.type = type;
	}
	
}
