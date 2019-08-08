package com.example.basicapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicapp.R;
import com.example.basicapp.adapter.RecyclerViewAdapter;
import com.example.basicapp.data.AppDatabase;

public class SubjectListActivity extends AppCompatActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subjects);
		initRecyclerView();
	}

	private void initRecyclerView() {
		RecyclerView recyclerView = findViewById(R.id.RecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, AppDatabase.getSubjectList());
		recyclerView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search_link_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.search_link:
				// User chose the "Search" item, show the activity...
				Intent intent = new Intent(this, SearchActivity.class);
				//EditText editText = (EditText) findViewById(R.id.editText);
				//String message = editText.getText().toString();
				//intent.putExtra(EXTRA_MESSAGE, message);
				startActivity(intent);

				return true;

			default:
				// If we got here, the user's action was not recognized.
				// Invoke the superclass to handle it.
				return super.onOptionsItemSelected(item);

		}
	}
}
