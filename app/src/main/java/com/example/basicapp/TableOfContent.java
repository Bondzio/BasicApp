package com.example.basicapp;

/* import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TableOfContent extends AppCompatActivity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_of_content);

		String[] subjects = {"1. Mathematik", "2. Informatik", "3. Biologie", "4. Chemie", "5. Physik",
			"6. Technik"}; // these are our list items

		ListAdapter TableAdapter = new CustomAdapter(this, createData());
		ListView TableListView = (ListView) findViewById(R.id.TableListView);
		TableListView.setAdapter(TableAdapter);
		//adapter is responsible for the conversion from java code to list items


		TableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override public void onItemClick(AdapterView<?> parent, View view, int position, long l) {    //this class

				String subjects = String.valueOf(parent.getItemAtPosition(position));

				Intent intent = new Intent();
				intent.setClass(TableOfContent.this, MathsTableOfContent.class);
				startActivity(intent);
			}
		});

//		ImageButton TableImageButton = (ImageButton) findViewById(R.id.TableImageButton);
//		TableImageButton.setOnClickListener(new View.OnClickListener() {
//			@Override public void onClick(View view) {
//				Intent startIntent = new Intent(getApplicationContext(), MathsTableOfContent.class);
//				//  startIntent.putExtra("AndroidStudioProjects.BasicApp.SOMETHING", "HELLO WORLD!");
//				startActivity(startIntent);
//
//			}
//
//		});

	}

	class RowItem {

		int imageressource;
		String text;

		RowItem(int res, String text) {
			this.imageressource = res;
			this.text = text;
		}

	}

	RowItem[] createData() {

		RowItem item[] = new RowItem[6];
		item[0] = new RowItem(R.drawable.maths, "1. Mathematik");
		item[1] = new RowItem(R.drawable.informatik, "2. Informatik");
		item[2] = new RowItem(R.drawable.biology,"3. Biologie");
		item[3] = new RowItem(R.drawable.biology,"4. Chemie");
		item[4] = new RowItem(R.drawable.physics,"5. Physik");
		item[5] = new RowItem(R.drawable.biology,"6. Technik");

		return item;
	}
} */

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
