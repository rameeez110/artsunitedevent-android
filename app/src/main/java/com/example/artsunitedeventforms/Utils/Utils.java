package com.example.artsunitedeventforms.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.data.local.Answer;
import com.example.artsunitedeventforms.data.local.Question;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.navigation.NavOptions;


public class Utils {
    
    private static final String PREFERENCE_NAME = "FormsSharedPreference";
    private static final String ACCEPTED_KEY = "isUserAcceptedTermsCondition";
    
    public static NavOptions getDefaultNavOptions(int popUpToDestination, Boolean shouldPop) {
        
        NavOptions.Builder builder = new NavOptions.Builder()
                                             .setEnterAnim(R.anim.slide_in_from_right)
                                             .setExitAnim(R.anim.slide_out_to_left)
                                             .setPopEnterAnim(R.anim.slide_in_from_left)
                                             .setPopExitAnim(R.anim.slide_out_to_right);
        
        if (shouldPop) {
            builder.setPopUpTo(popUpToDestination, true);
            builder.setLaunchSingleTop(true);
        }
        
        return builder.build();
    }
    
    public static String getCurrentDate(String format) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date currentDate = new Date();
        String date = dateFormat.format(currentDate);
        return date;
    }
    
    public static String getAnswerFromType(Question question, Answer answer) {
        
        switch (question.getType()) {
            
            case TEXT:
            case MULTILINE_TEXT:
            case NUMBER:
                return answer.getText();
            
            case DATE:
            case TIME:
            case AUTO_GEN_DATE:
                return answer.getDate();
            
            case BOOLEAN_SWITCH:
            case BOOLEAN_CHECK:
                return answer.getFormatedBoolean();
        }
        return "";
    }
    
    public static void saveTermsConditionAccept(Context context, boolean value) {
        
        SharedPreferences preferences =
                context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(ACCEPTED_KEY, value);
        editor.apply();
    }
    
    public static boolean getTermsConditionAccept(Context context) {
        
        SharedPreferences preferences =
                context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(ACCEPTED_KEY, false);
    }
    
    public static Snackbar showSnackBar(Activity activity, String message) {
        
        Snackbar snackbar;
        snackbar = Snackbar.make(activity.findViewById(android.R.id.content).getRootView(), message, Snackbar.LENGTH_LONG);
        TextView textView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
        
        snackbar.getView().setBackgroundColor(activity.getResources().getColor(R.color.snackBarBGColor,null));
        textView.setTextColor(Color.BLACK);
        
        snackbar.show();
        return snackbar;
    }
}
