package com.example.basicapp;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay extends Activity {

	private Subjects selectedSubject;

	String[] SubSectionsInformatik = {"2.1 Basis-Grundlagen", "2.2 Theoretische Informatik",
		"2.3. Technische Informatik ", "2.4. Bioinformatik"};

	String[] SubSectionsMathematik = {"1.1 Basis-Grundlagen", "1.2 Theoretische Informatik",
		"1.3. Technische Informatik ", "1.4. Bioinformatik"};

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// This is how one can pass data between activities
		//TODO You can read more about Serializable
		selectedSubject = (Subjects) getIntent().getSerializableExtra("subject");

		ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, displayList());
		ListView listView = (ListView) findViewById(R.id.InformatikSubSections);
		listView.setAdapter(adapter);
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
