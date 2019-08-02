package com.example.basicapp.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicapp.R;
import com.example.basicapp.adapter.RecyclerViewAdapter;
import com.example.basicapp.data.AppDatabase;
import java.util.ArrayList;

public class SubjectListActivity extends AppCompatActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_of_content);
		initRecyclerView();
	}

	private void initRecyclerView() {
		RecyclerView recyclerView = findViewById(R.id.RecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, AppDatabase.getSubjectList());
		recyclerView.setAdapter(adapter);
	}
}
