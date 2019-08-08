package com.example.basicapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.basicapp.R;
import com.example.basicapp.adapter.SearchListAdaper;
import com.example.basicapp.data.AppDatabase;
import com.example.basicapp.data.WordPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener {

    private SearchView searchView;

    private WordPath[] words;
    private SearchListAdaper adapter;
    private List<WordPath> candidates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initWordPaths();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        candidates = new ArrayList<>();
        candidates.addAll(Arrays.asList(words));

        adapter = new SearchListAdaper(this, candidates);
        recyclerView.setAdapter(adapter);
    }

    private void initWordPaths()
    {
        List<WordPath> wordPaths = new LinkedList<>();

        List<AppDatabase.Subject> subjects = AppDatabase.getSubjectList();

        StringBuilder curPath;

        for(AppDatabase.Subject subject : subjects) {
            curPath = new StringBuilder();

            String curSubject = subject.getName();
            curPath.append(curSubject).append("/");
            int subjectIndex = curPath.length();

            String[] chapters = ChapterListActivity.displayList(curSubject);

            for(String chapter : chapters) {

                curPath.append(chapter).append("/");
                int chapterIndex = curPath.length();

                String[] words = WordListActivity.displayList(chapter);

                for(String word : words) {
                    curPath.append(word);

                    wordPaths.add(new WordPath(curPath.toString()));

                    curPath.delete(chapterIndex, curPath.length());
                }

                curPath.delete(subjectIndex, curPath.length());
            }
        }

        words = new WordPath[wordPaths.size()];

        for(int i=0; i < words.length; i++) {
            words[i] = wordPaths.get(i);
        }

        Arrays.sort(words);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setIconified(false);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        // search on lower case characters
        newText = newText.toLowerCase();
        candidates.clear();

        if(newText.isEmpty()) {
            candidates.addAll(Arrays.asList(words));
        } else {
            // only works if words list is ordered!
            boolean foundCandidates = false;
            for(WordPath candidate : words) {

                if(candidate.word().toLowerCase().startsWith(newText)) {
                    candidates.add(candidate);
                    foundCandidates = true;
                } else if(foundCandidates) {
                    break;
                }
            }
        }

        adapter.notifyDataSetChanged();

        return false;
    }

    @Override
    public boolean onClose() {
        return true;
    }
}
