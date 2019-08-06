package com.example.basicapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.utility.SpecialCharacterReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WebViewActivity extends AppCompatActivity {

	private String url;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		url = getIntent().getStringExtra("url");

		WebView webView = findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/" + SpecialCharacterReplacement.replaceSpecialCharacters(url) + ".html");
	}
}
