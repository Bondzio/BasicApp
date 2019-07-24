package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

	private ImageButton b;                                  //the starting picture is a button

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		b = (ImageButton) findViewById(R.id.ImageButton);
		b.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				Intent i = new Intent(HomeActivity.this, TableOfContent.class);
				startActivity(i);
				//after clicking on the starting picture, a new activity with the TableOfContent will open

			}
		});
	}
}
