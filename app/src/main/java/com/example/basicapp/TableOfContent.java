package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TableOfContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_of_content);

        String[] subjects = {"1. Mathematik", "2. Informatik", "3. Biologie", "4. Chemie", "5. Physik", "6. Technik"}; // these are our list items
        ListAdapter TableAdapter=new CustomAdapter(this, subjects);
        ListView TableListView= (ListView) findViewById(R.id.TableListView);
        TableListView.setAdapter(TableAdapter);
        //adapter is responsible for the conversion from java code to list items

      //  TableListView.setOnItemClickListener(
        //        new AdapterView.OnItemClickListener() {
          //          @Override
            //        public void onItemClick(AdapterView<?> parent, View view, int position, long l) {    //this class should
              //          String subjects = String.valueOf(parent.getItemAtPosition(position));
                //        Intent intent = new Intent();

                   //     intent.setClass(TableOfContent.this, MathsTableOfContent.class);
                //        startActivity(intent);
             //       }
            //    });

        ImageButton TableImageButton = (ImageButton)findViewById(R.id.TableImageButton);
        TableImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                        public void onClick(View view) {
                            Intent startIntent = new Intent(getApplicationContext(),MathsTableOfContent.class);
                          //  startIntent.putExtra("AndroidStudioProjects.BasicApp.SOMETHING", "HELLO WORLD!");
                            startActivity(startIntent);

                        }

                });
    }

    }
