package com.example.basicapp.ui;


import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.data.Subjects;
import com.example.basicapp.adapter.ChapterListAdapter;
import java.util.Arrays;

public class ChapterListActivity extends Activity {

	private Subjects selectedSubject;

	String[] SubSectionsInformatik = {"2.1 Basis-Grundlagen", "2.2 Theoretische Informatik",
		"2.3. Technische Informatik ", "2.4. Bioinformatik"};

	String[] SubSectionsMathematik = {"1.1 Basis-Grundlagen", "1.2 Theoretische Informatik",
		"1.3. Technische Informatik ", "1.4. Bioinformatik"};

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subjects);

		selectedSubject = (Subjects) getIntent().getSerializableExtra("subject");
		initRecyclerView();
	}

	private void initRecyclerView() {
		RecyclerView recyclerView = findViewById(R.id.RecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		ChapterListAdapter adapter = new ChapterListAdapter(this, Arrays.asList(displayList()));
		recyclerView.setAdapter(adapter);
	}

	private String[] displayList() {

		switch (selectedSubject) {
			case Mathematik:
				return SubSectionsMathematik;
			case Informatik:
				return SubSectionsInformatik;
			case Biologie:
				break;
			case Chemie:
				break;
			case Physik:
				break;
			case Technik:
				break;
		}

		return new String[0];
	}
}
