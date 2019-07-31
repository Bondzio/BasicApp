package com.example.basicapp;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay extends Activity {

	private Subjects selectedSubject;

    String[] SubSectionsMathematik = {"1.1 Basis-Grundlagen Mathematik", "1.2 Mathematik in der Informatik",
            "1.3. Mathematik in der Biologie ", "1.4. Mathematik in der Chemie", "1.5 Mathematik in der Physik", "1.6 Mathematik in der Technik"};

	String[] SubSectionsInformatik = {"2.1 Basis-Grundlagen Informatik", "2.2 Theoretische Informatik",
		"2.3. Bioinformatik", "2.4. Technische Informatik"};

	String[] SubSectionsBiologie = {"3.1 Basis-Grundlagen Chemie", "3.2 Theoretische Biologie", "3.3. Bioinformatik",
			"3.3. Bio-Chemie", "3.4. Bio-Physik", "3.5 Technische Biologie"};

    String[] SubSectionsChemie = {"4.1 Basis-Grundlagen Chemie", "4.2 Theoretische Chemie",
			"4.3. Organische Chemie", "4.4 Physikalische Chemie", "4.5. Technische Chemie"};

	String[] SubSectionsPhysik = {"5.1 Basis-Grundlagen Physik", "5.2 Theoretische Physik",
			"5.3. Technische Physik ", "5.4. Bio-Physik", "5.5 Chemie-Physik"};

	String[] SubSectionsTechnik = {"6.1 Basis-Grundlagen Technik", "6.2 Technische Mathematik",
			"6.3. Technische Informatik ", "6.4. Technische Biologie", "6.5 Technische Chemie", "6.6 Technische Physik" };
	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);

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
				return SubSectionsBiologie;
			case Chemie:
                return SubSectionsChemie;
			case Physik:
				return SubSectionsPhysik;
			case Technik:
				return SubSectionsTechnik;
		}

		return new String[0];
	}


}
