package com.example.basicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basicapp.R;

import java.util.List;

public class SearchListAdaper extends RecyclerView.Adapter<SearchListAdaper.ViewHolder>  {

    private Context mContext;
    List<String> elementsList;

    public SearchListAdaper(Context context, List<String> elementsList) {
        mContext = context;
        this.elementsList = elementsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_searchitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String word = elementsList.get(position);
        TextView textView = holder.word;
        textView.setText(word);

        textView = holder.wordPath;
        textView.setText(word + "/" + word + "/" + word);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(mContext, elementsList.get(position), Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(mContext, ChapterListActivity.class);
                //intent.putExtra("subject", subjectList.get(position).getName());
                //mContext.startActivity(intent);
            }
        });
    }


    @Override public int getItemCount() {
        return elementsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView word;
        TextView wordPath;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word_name);
            wordPath = itemView.findViewById(R.id.word_path);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
