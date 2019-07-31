package com.example.basicapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TableOfContent extends AppCompatActivity {

	private static final String TAG = "TableOfContent";

	//vars
	private ArrayList<String> mNames = new ArrayList<>();
	private ArrayList<String> mImageUrls = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_of_content);
		Log.d(TAG, "onCreate: started.");

		mNames.clear();
		mImageUrls.clear();

		initImageBitmaps();
	}

	private void initImageBitmaps(){
		Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

		mNames.add("1. Mathematik");
		mImageUrls.add("https://epsilonbildung.de/wp-content/uploads/2019/02/Fotolia_76300304_L.jpg");

		mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
		mNames.add("2. Informatik");

		mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
		mNames.add("3. Biologie");

		mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
		mNames.add("4. Chemie");

		mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
		mNames.add("5. Physik");

		mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
		mNames.add("6. Technik");

		initRecyclerView();
	}

	private void initRecyclerView(){
		Log.d(TAG, "initRecyclerView: init recyclerview.");
		RecyclerView recyclerView = findViewById(R.id.RecyclerView);
		codingwithmitch.com.recyclerview.RecyclerViewAdapter adapter = new codingwithmitch.com.recyclerview.RecyclerViewAdapter(this, mNames, mImageUrls);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
