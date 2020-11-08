package com.example.artsunitedeventforms.views.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.BindingAdapter;


public class BindingAdapters {
	
	@BindingAdapter("binded_layout_height")
	public static void setLayoutHeight(View view, float height) {
		ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
		layoutParams.height = height == -1 ? layoutParams.WRAP_CONTENT : (int) height;
		view.setLayoutParams(layoutParams);
	}
}
