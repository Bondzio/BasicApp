package com.example.basicapp.ui;


import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.data.Subjects;
import com.example.basicapp.adapter.ChapterListAdapter;
import java.util.Arrays;

public class ChapterListActivity extends AppCompatActivity {

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
