package com.example.basicapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import com.example.basicapp.R;

public class HomeActivity extends AppCompatActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ImageButton b = findViewById(R.id.ImageButton);
		b.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				Intent i = new Intent(HomeActivity.this, SubjectListActivity.class);
				startActivity(i);
			}
		});
	}
}
