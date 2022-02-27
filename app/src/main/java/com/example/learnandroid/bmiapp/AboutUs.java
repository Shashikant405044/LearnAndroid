package com.example.learnandroid.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.ActivityAboutUsBinding;

public class AboutUs extends BaseActivity {
    private ProgressDialog dialog;

    ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AboutUs.this.setTitle("AboutApp");

//        dialog = new ProgressDialog(context);
//        dialog.setTitle(R.string.app_name);
//        dialog.setMessage("Loading... Please Wait");
//        dialog.setCancelable(false);
//        dialog.show();
        binding.webview.loadUrl("https://en.wikipedia.org/wiki/Body_mass_index#Public_health");
        binding.webview.setWebViewClient(new MyWebViewClient());


    }
    class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            binding.progressbar.setVisibility(View.GONE);
            dialog.hide();
        }
    }
}