package com.example.artsunitedeventforms.views.ui.question;


import com.example.artsunitedeventforms.Utils.FormManager;
import com.example.artsunitedeventforms.data.enums.Forms;
import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.data.local.SectionedQuestions;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class QuestionViewModel extends ViewModel {
	
	private MutableLiveData<ArrayList<SectionedQuestions>> questionsLiveData =
			new MutableLiveData<>();
	
	private QuestionFragmentArgs args;
	
	
	public void setArgs(QuestionFragmentArgs args) {
		
		this.args = args;
	}
	
	
	public QuestionFragmentArgs getArgs() {
		
		return args;
	}
	
	
	public MutableLiveData<ArrayList<SectionedQuestions>> getQuestionsLiveData() {
		
		questionsLiveData.setValue(getQuestions(args.getFormName()));
		return questionsLiveData;
	}
	
	
	public ArrayList<SectionedQuestions> getQuestions(Forms fromName) {
		
		//if (true) {
		//	return FormManager.getTestingData();
		//}
		
		switch (fromName) {
			case AUC_REPORT:
				return FormManager.getAucEventReportForm();

			case AL_REPORT:
				return FormManager.getAlEventReportForm();

			case AUC_MONITOR:
				return FormManager.getAucDeskMonitorForm();

			case AL_MONITOR:
				return FormManager.getAlDeskMonitorForm();

			case AUC_TECH:
				return FormManager.getAucTechForm();

			case AL_TECH:
				return FormManager.getAlTechForm();
		}
		
		return new ArrayList<>();
	}
	
	
	public ArrayList<Question> getAllQuestions() {
		
		ArrayList<SectionedQuestions> sectionedQuestions = questionsLiveData.getValue();
		ArrayList<Question> questions = new ArrayList<>();
		for (int i = 0; i < sectionedQuestions.size(); i++) {
			questions.addAll(sectionedQuestions.get(i).getChildItems());
		}
		return questions;
	}
}