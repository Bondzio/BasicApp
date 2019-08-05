package com.example.basicapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import com.example.basicapp.R;

public class SplashActivity extends AppCompatActivity {

	private static int SPLASH_TIME_OUT = 2000;              // time to show the starting symbol is 4 seconds

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Handler().postDelayed(new Runnable() {
			@Override public void run() {
				Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);  //to go to the next activity
				startActivity(homeIntent);
				finish();
			}
		}, SPLASH_TIME_OUT);
	}
}
