package com.example.basicapp.adapter;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.basicapp.ListDisplay;
import com.example.basicapp.R;
import com.example.basicapp.Subjects;

import com.example.basicapp.data.AppDatabase.Subject;
import com.example.basicapp.ui.SubjectListActivity;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	private Context mContext;
	List<Subject> subjectList;

	public RecyclerViewAdapter(Context context, List<Subject> subjectList) {
		mContext = context;
		this.subjectList = subjectList;
	}

	@Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}

	@Override public void onBindViewHolder(ViewHolder holder, final int position) {

		Subject subject = subjectList.get(position);
		holder.imageName.setText(subject.getName());
		Glide.with(mContext).load(subject.getDrawableId()).into(holder.image);

		holder.parentLayout.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				Intent intent = new Intent(mContext, ListDisplay.class);
				intent.putExtra("subject", Subjects.values()[position]);
				mContext.startActivity(intent);
			}
		});
	}


	@Override public int getItemCount() {
		return subjectList.size();
	}


	public class ViewHolder extends RecyclerView.ViewHolder {

		CircleImageView image;
		TextView imageName;
		RelativeLayout parentLayout;

		public ViewHolder(View itemView) {
			super(itemView);
			image = itemView.findViewById(R.id.image);
			imageName = itemView.findViewById(R.id.image_name);
			parentLayout = itemView.findViewById(R.id.parent_layout);
		}
	}
}