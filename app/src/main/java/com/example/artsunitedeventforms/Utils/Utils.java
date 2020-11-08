package com.example.artsunitedeventforms.Utils;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.data.local.Answer;
import com.example.artsunitedeventforms.data.local.Question;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.navigation.NavOptions;


public class Utils {
    
    public static NavOptions getDefaultNavOptions() {
        
        return new NavOptions.Builder()
                       .setEnterAnim(R.anim.slide_in_from_right)
                       .setExitAnim(R.anim.slide_out_to_left)
                       .setPopEnterAnim(R.anim.slide_in_from_left)
                       .setPopExitAnim(R.anim.slide_out_to_right)
                       .build();
    }
    
    public static String getCurrentDate(String format){
        
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
}
