package com.example.basicapp.ui;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.adapter.WordListAdapter;
import com.example.basicapp.data.Subjects;
import com.example.basicapp.adapter.ChapterListAdapter;
import com.example.basicapp.data.Words;

import java.util.Arrays;

public class WordListActivity extends AppCompatActivity {

    private String selectedSubject;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        selectedSubject = getIntent().getStringExtra("subject");

        Log.i("WordListActivity", selectedSubject);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] wordList = displayList();
        String[] pathList = new String[wordList.length];
        for(int i=0; i < wordList.length; i++) {
            pathList[i] = selectedSubject + "/" + wordList[i];
        }

        WordListAdapter adapter = new WordListAdapter(this, Arrays.asList(pathList));
        recyclerView.setAdapter(adapter);
    }

    private String[] displayList() {

        String subjectNumber = selectedSubject.substring(selectedSubject.lastIndexOf("/") + 1)
                                                .substring(0,3);

        Log.i("WordListActivity", subjectNumber);

        switch (subjectNumber) {
            case "1.1": return Words.SubSectionsMathematik11;
            case "1.2": return Words.SubSectionsMathematik12;
            case "1.3": return Words.SubSectionsMathematik13;
            case "1.4": return Words.SubSectionsMathematik14;
            case "1.5": return Words.SubSectionsMathematik15;
            case "1.6": return Words.SubSectionsMathematik16;

            case "2.1": return Words.SubSectionsInformatik11;
            case "2.2": return Words.SubSectionsInformatik12;
            case "2.3": return Words.SubSectionsInformatik13;
            case "2.4": return Words.SubSectionsInformatik14;

            case "3.1": return Words.SubSectionsBiologie11;
            case "3.2": return Words.SubSectionsBiologie12;
            case "3.3": return Words.SubSectionsBiologie13;
            case "3.4": return Words.SubSectionsBiologie14;
            case "3.5": return Words.SubSectionsBiologie15;

            case "4.1": return Words.SubSectionsChemie11;
            case "4.2": return Words.SubSectionsChemie12;
            case "4.3": return Words.SubSectionsChemie13;
            case "4.4": return Words.SubSectionsChemie14;
            case "4.5": return Words.SubSectionsChemie15;

            case "5.1": return Words.SubSectionsPhysik11;
            case "5.2": return Words.SubSectionsPhysik12;
            case "5.3": return Words.SubSectionsPhysik13;
            case "5.4": return Words.SubSectionsPhysik14;
            case "5.5": return Words.SubSectionsPhysik15;

            case "6.1": return Words.SubSectionsTechnik11;
            case "6.2": return Words.SubSectionsTechnik12;
            case "6.3": return Words.SubSectionsTechnik13;
            case "6.4": return Words.SubSectionsTechnik14;
            case "6.5": return Words.SubSectionsTechnik15;
            case "6.6": return Words.SubSectionsTechnik16;
        }

        return new String[0];
    }
}
