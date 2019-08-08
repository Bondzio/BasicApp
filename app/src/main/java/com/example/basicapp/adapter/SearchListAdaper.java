package com.example.basicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basicapp.R;
import com.example.basicapp.data.WordPath;
import com.example.basicapp.ui.WebViewActivity;

import java.util.List;

public class SearchListAdaper extends RecyclerView.Adapter<SearchListAdaper.ViewHolder>  {

    private Context mContext;
    List<WordPath> elementsList;

    public SearchListAdaper(Context context, List<WordPath> elementsList) {
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

        WordPath wordPath = elementsList.get(position);

        TextView textView = holder.word;
        textView.setText(wordPath.word());

        textView = holder.wordPath;
        textView.setText(wordPath.path());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("url", elementsList.get(position).path());
                mContext.startActivity(intent);
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
