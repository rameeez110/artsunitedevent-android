package com.example.artsunitedeventforms.views.ui.pdf;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.artsunitedeventforms.R;
import com.example.artsunitedeventforms.databinding.FragmentPdfBinding;
import com.example.artsunitedeventforms.views.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class PdfFragment extends Fragment {
    
    FragmentPdfBinding binding;
    PdfViewModel mViewModel;
    NavController navController;
    
    Handler emailHandler = new Handler(Looper.getMainLooper());
    Runnable emailRunnable = () -> {
        ((MainActivity) requireActivity()).hideLoader();
    
        //Log.d("d", "PdfFragmentLogData->getEmailIntent(): "+mViewModel.getArgs().getFileUri());
        //openEmailApp();
        sendEmail();
    };
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        binding = FragmentPdfBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PdfViewModel.class);
        navController = Navigation.findNavController(view);
        
        emailHandler.postDelayed(emailRunnable, 2000);
        
        mViewModel.setArgs(PdfFragmentArgs.fromBundle(getArguments()));
        
        binding.pdfView.fromUri(mViewModel.getArgs().getFileUri())
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();
    }
    
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        emailHandler.removeCallbacks(emailRunnable);
    }
    
    public Intent getEmailIntent() {
        
        Intent intent = new Intent();
        setEmailIntentData(intent);
        //intent.setType("application/pdf");
        
        List<ResolveInfo> resInfoList =
                getContext().getPackageManager()
                        .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        
        for (ResolveInfo resolveInfo : resInfoList) {
            String packageName = resolveInfo.activityInfo.packageName;
            getContext().grantUriPermission(packageName, mViewModel.getArgs().getFileUri(),
                    Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        }
        
        return intent;
    }
    
    private void openEmailApp() {
        
        List<Intent> emailAppLauncherIntents = new ArrayList<>();
        
        Intent emailAppIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        
        PackageManager packageManager = getContext().getPackageManager();
        
        List<ResolveInfo> emailApps = packageManager.queryIntentActivities(emailAppIntent,
                PackageManager.MATCH_ALL);
        
        if (emailApps == null || emailApps.size() == 0) {
    
            Intent chooser = Intent.createChooser(getEmailIntent(), "Choose an Email client :");
            chooser.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            startActivity(chooser);
        }
        else {
            
            for (ResolveInfo resolveInfo : emailApps) {
                String packageName = resolveInfo.activityInfo.packageName;
                String name = resolveInfo.activityInfo.name;
                
                getContext().grantUriPermission(packageName, mViewModel.getArgs().getFileUri(),
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                
                Intent launchIntent = packageManager.getLaunchIntentForPackage(packageName);
                launchIntent.setAction(Intent.ACTION_SEND);
                setEmailIntentData(launchIntent);
                
                launchIntent.setComponent(new ComponentName(packageName, name));
                
                emailAppLauncherIntents.add(launchIntent);
            }
            
            Intent chooserIntent = Intent.createChooser(new Intent(), "Select email app:");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, emailAppLauncherIntents.toArray(
                    new Parcelable[emailAppLauncherIntents.size()]));
            chooserIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            startActivity(chooserIntent);
        }
    }
    
    public void setEmailIntentData(Intent intent) {
        
        String message = "This is a PDF exported from the data you have entered.";
        String ccAddress = mViewModel.getArgs().getFormName().getEmail();
        
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, mViewModel.getArgs().getFormName().getTitle());
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_STREAM, mViewModel.getArgs().getFileUri());
        intent.putExtra(Intent.EXTRA_EMAIL, "");
        intent.putExtra(Intent.EXTRA_CC, new String[]{ccAddress});
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    }
    
    public void sendEmail() {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        Intent emailIntent = new Intent();
        String message = "This is a PDF exported from the data you have entered.";
        String ccAddress = mViewModel.getArgs().getFormName().getEmail();
    
        emailIntent.setAction(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mViewModel.getArgs().getFormName().getTitle());
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.putExtra(Intent.EXTRA_STREAM, mViewModel.getArgs().getFileUri());
        emailIntent.putExtra(Intent.EXTRA_CC, new String[]{ccAddress});
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    
        startActivity(Intent.createChooser(emailIntent, null));
    }
}