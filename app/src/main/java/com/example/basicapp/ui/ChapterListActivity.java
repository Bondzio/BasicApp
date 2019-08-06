package com.example.basicapp.ui;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.data.AppDatabase;
import com.example.basicapp.data.Chapter;
import com.example.basicapp.data.Subjects;
import com.example.basicapp.adapter.ChapterListAdapter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ChapterListActivity extends AppCompatActivity {

	private String selectedSubject;


	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subjects);

		selectedSubject =  getIntent().getStringExtra("subject");
		initRecyclerView();
	}

	private void initRecyclerView() {
		RecyclerView recyclerView = findViewById(R.id.RecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		Log.i("ChapterListActivity", selectedSubject);
		String[] chapterList = displayList();
		String[] pathList = new String[chapterList.length];
		for(int i=0; i < chapterList.length; i++) {
			pathList[i] = selectedSubject + "/" + chapterList[i];
		}

		ChapterListAdapter adapter = new ChapterListAdapter(this, Arrays.asList(pathList));
		recyclerView.setAdapter(adapter);
	}

	private String[] displayList() {

		switch (selectedSubject) {
			case "1. Mathematik":
				return Chapter.SubSectionsMathematik;
			case "2. Informatik":
				return Chapter.SubSectionsInformatik;
			case "3. Biologie":
				return Chapter.SubSectionsBiologie;
			case "4. Chemie":
                return Chapter.SubSectionsChemie;
			case "5. Physik":
				return Chapter.SubSectionsPhysik;
			case "6. Technik":
				return Chapter.SubSectionsTechnik;
		}

		return new String[0];
	}
}
