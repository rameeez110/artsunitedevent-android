package com.example.artsunitedeventforms.Utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.artsunitedeventforms.R;

import java.util.Calendar;


public class DialogUtils {
    
    private static AlertDialog progressDialog;
    
    public static AlertDialog showProgress(Context context, String message) {
        
        progressDialog = new ProgressDialog(context);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.dialog_progress, null);
            ((TextView) popupView.findViewById(R.id.dialog_message)).setText(message);
            builder.setView(popupView);
            builder.setCancelable(false);
            progressDialog = builder.create();
            progressDialog.show();
        } catch (Exception e) {
            Log.e("d", "DialogUtilsLogData->showProgress(): EXCEPTION CAUGHT\n"
                               + Log.getStackTraceString(e));
        }
        return progressDialog;
    }
    
    public static void hideProgress() {
        
        try {
            progressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static DatePickerDialog showDatePicker(Context context,
                                                  DatePickerDialog.OnDateSetListener listener) {
        
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                listener, mYear, mMonth, mDay);
        datePickerDialog.show();
        return datePickerDialog;
    }
    
    public static TimePickerDialog showTimePicker(Context context,
                                                  TimePickerDialog.OnTimeSetListener listener) {
        
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                listener, mHour, mMinute, false);
        timePickerDialog.show();
        return timePickerDialog;
    }
    
    public static void showConfirmationDialog(Context context, Runnable positiveClick,
                                              Runnable negativeClick) {
        
        Dialog dialog = new Dialog(context, R.style.Theme_MaterialComponents_Dialog_Alert);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_confirmation);
        
        TextView mYes = dialog.findViewById(R.id.dialog_confirm_yes);
        mYes.setOnClickListener((view) -> {
            if (positiveClick != null)
                positiveClick.run();
            dialog.dismiss();
        });
        
        TextView mCancel = dialog.findViewById(R.id.dialog_confirm_cancel);
        mCancel.setOnClickListener((view) -> {
            if (negativeClick != null)
                negativeClick.run();
            dialog.dismiss();
        });
        
        dialog.show();
    }
}
