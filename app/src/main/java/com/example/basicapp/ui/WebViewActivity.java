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
		//webView.getSettings().setDefaultTextEncodingName("utf-8");
		Log.i("WebViewActivity", url);
		webView.loadUrl("file:///android_asset/" + SpecialCharacterReplacement.replaceSpecialCharacters(url) + ".html");
		//webView.loadDataWithBaseURL(null, readFile(url + ".html"), "text/html", "UTF-8", null);
		try {
			Log.i("WebViewActivity", Arrays.toString(getAssets().list("2. Informatik/2.4 Technische Informatik")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readFile(String path)
	{
		Log.i("WebViewActivity", path);
		StringBuilder file = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(getAssets().open(path)));

			// do reading, usually loop until end of file reading
			String line;
			while ((line = reader.readLine()) != null) {
				file.append(line);
			}
		} catch (IOException e) {
			//log the exception
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					//log the exception
				}
			}
		}

		return file.toString();
	}
}
