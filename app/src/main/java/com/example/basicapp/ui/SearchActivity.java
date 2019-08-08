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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener {

    private SearchView searchView;

    private String[] words = { "a", "b", "c", "d", "e", "f", "ab", "cd", "ef", "abc", "def" };

    private SearchListAdaper adapter;
    private List<String> candidates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Arrays.sort(words);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        //searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setIconified(false);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);


        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i("OnQueryListener", "submit:" + query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("OnQueryListener",newText);

        candidates.clear();

        if(newText.isEmpty()) {
            candidates.addAll(Arrays.asList(words));
        } else {
            // only works if words list is ordered!
            boolean foundCandidates = false;
            for(String candidate : words) {

                if(candidate.startsWith(newText)) {
                    candidates.add(candidate);
                    foundCandidates = true;
                } else if(foundCandidates) {
                    break;
                }
            }
        }

        Log.i("OnQueryListener", "candidates:" + candidates);

        adapter.notifyDataSetChanged();

        return true;
    }

    @Override
    public boolean onClose() {
        return true;
    }
}
