package com.example.artsunitedeventforms.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.artsunitedeventforms.BR;
import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.Utils.DialogUtils;
import com.example.artsunitedeventforms.data.enums.QuestionType;
import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.data.local.SectionedQuestions;
import com.intrusoft.sectionedrecyclerview.SectionRecyclerViewAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


public class QuestionsAdapter extends SectionRecyclerViewAdapter<SectionedQuestions, Question,
		QuestionsAdapter.HeaderDataViewHolder, QuestionsAdapter.ChildDataViewHolder> {
	
	Context context;
	ArrayList<SectionedQuestions> sectionedQuestionsItemList;
	
	public QuestionsAdapter(Context context, ArrayList<SectionedQuestions> sectionedQuestionsItemList) {
		
		super(context, sectionedQuestionsItemList);
		this.sectionedQuestionsItemList = sectionedQuestionsItemList;
		this.context = context;
	}
	
	@Override
	public HeaderDataViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
		
		LayoutInflater mLayoutInflater = LayoutInflater.from(context);
		ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_section,
				viewGroup, false);
		
		return new HeaderDataViewHolder(binding);
	}
	
	@Override
	public ChildDataViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
		
		LayoutInflater mLayoutInflater = LayoutInflater.from(context);
		ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_question,
				viewGroup, false);
		return new ChildDataViewHolder(binding);
	}
	
	@Override
	public void onBindSectionViewHolder(HeaderDataViewHolder headerDataViewHolder, int i, SectionedQuestions sectionedQuestions) {
		
		headerDataViewHolder.binding.setVariable(BR.header, sectionedQuestions);
	}
	
	@Override
	public void onBindChildViewHolder(ChildDataViewHolder childDataViewHolder, int parentPostion,
									  int childPosition, Question question) {
		
		SectionedQuestions section = sectionedQuestionsItemList.get(parentPostion);
		
		childDataViewHolder.binding.setVariable(BR.childSize, section.getChildItems().size());
		childDataViewHolder.binding.setVariable(BR.parentPosition, parentPostion);
		childDataViewHolder.binding.setVariable(BR.childPosition, childPosition);
		childDataViewHolder.binding.setVariable(BR.questionsAdapter, this);
		
		//childDataViewHolder.showQuestionTypeView(question.getType());
		childDataViewHolder.bindData(question);
	}
	
	public void showDateTimeDialog(QuestionType type, Integer parentPosition, Integer childPosition) {
		
		if (type == QuestionType.DATE) {
			DialogUtils.showDatePicker(context, (view, year, month, dayOfMonth) -> {
				String date = String.format("%2d-%2d-%2d", dayOfMonth, month, year);
				sectionedQuestionsItemList.get(parentPosition)
						.getChildItems().get(childPosition)
						.getAnswer().setDate(date);
			});
		}
		else if (type == QuestionType.TIME) {
			
			DialogUtils.showTimePicker(context, (view, hourOfDay, minute) -> {
				String time = String.format("%2d:%2d", hourOfDay, minute);
				sectionedQuestionsItemList.get(parentPosition)
						.getChildItems().get(childPosition)
						.getAnswer().setDate(time);
			});
		}
	}
	
	class HeaderDataViewHolder extends RecyclerView.ViewHolder {
		
		ViewDataBinding binding;
		TextView mSectionTitle;
		
		public HeaderDataViewHolder(@NonNull ViewDataBinding binding) {
			
			super(binding.getRoot());
			this.binding = binding;
			
			mSectionTitle = binding.getRoot().findViewById(R.id.item_question_section_txt);
		}
	}
	
	class ChildDataViewHolder extends RecyclerView.ViewHolder {
		
		ViewDataBinding binding;
		
		public ChildDataViewHolder(@NonNull ViewDataBinding binding) {
			
			super(binding.getRoot());
			this.binding = binding;
		}
		
		public void bindData(Question question) {
			
			binding.setVariable(BR.question, question);
		}
	}
}
