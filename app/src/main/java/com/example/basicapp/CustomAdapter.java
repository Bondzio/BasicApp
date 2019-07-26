/*package com.example.basicapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.basicapp.TableOfContent.RowItem;

class CustomAdapter extends ArrayAdapter<TableOfContent.RowItem> {

    RowItem[] subjects1;

    CustomAdapter(Context context, TableOfContent.RowItem[] subjects){
        super(context, R.layout.custom_row, subjects);

         this.subjects1 = subjects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater TableInflator = LayoutInflater.from(getContext());
        View customView = TableInflator.inflate(R.layout.custom_row, parent, false);

        TextView TextField = (TextView) customView.findViewById(R.id.TextField);
        ImageView TableImage = (ImageView) customView.findViewById(R.id.TableImageButton);

        TextField.setText(getItem(position).text);
        TableImage.setImageResource(getItem(position).imageressource);
        return customView;

        // if(TextField.getText() == "maths"){
        //     TextField.setText(singleSubjectItem);
        //     TableImage.setImageResource(R.drawable.maths);
        //  }
        //  else if(TextField.getText() == "informatik"){
        //       TextField.setText(singleSubjectItem);
        //        TableImage.setImageResource(R.drawable.informatik);
        //  }
    }

    @Override public int getCount() {
        return subjects1.length;
    }

    @Override public boolean areAllItemsEnabled() {
        return true;
    }

    @Override public boolean isEnabled(int position) {
        return true;
    }
}

*/