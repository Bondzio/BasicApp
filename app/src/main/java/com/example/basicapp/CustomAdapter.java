package com.example.basicapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] subjects){
        super(context, R.layout.custom_row, subjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater TableInflator = LayoutInflater.from(getContext());
        View customView = TableInflator.inflate(R.layout.custom_row, parent, false);

        String singleSubjectItem = getItem(position);
        TextView TextField = (TextView) customView.findViewById(R.id.TextField);
        ImageView TableImage = (ImageView) customView.findViewById(R.id.TableImageButton);

        TextField.setText(singleSubjectItem);
        TableImage.setImageResource(R.drawable.maths);

        // if(TextField.getText() == "maths"){
        //     TextField.setText(singleSubjectItem);
        //     TableImage.setImageResource(R.drawable.maths);
        //  }
        //  else if(TextField.getText() == "informatik"){
        //       TextField.setText(singleSubjectItem);
        //        TableImage.setImageResource(R.drawable.informatik);
        //  }
        return customView;
    }


}

