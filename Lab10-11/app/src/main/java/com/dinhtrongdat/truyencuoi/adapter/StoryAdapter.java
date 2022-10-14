package com.dinhtrongdat.truyencuoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.truyencuoi.MainActivity;
import com.dinhtrongdat.truyencuoi.R;
import com.dinhtrongdat.truyencuoi.model.StoryEntity;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private ArrayList<StoryEntity> storyLocation;
    private final ListItemClickListener mOnClickListener;

    public StoryAdapter(ArrayList<StoryEntity> storyLocation,ListItemClickListener mOnClickListener) {
        this.storyLocation = storyLocation;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public StoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,parent,false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryAdapter.StoryViewHolder holder, int position) {
        StoryEntity item = storyLocation.get(position);
        holder.tvName.setTag(item.getName());
        holder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return storyLocation.size();
    }

    public interface ListItemClickListener {
        void onStoryListClick(int clickedItemIndex);
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;

        public StoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_story);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onStoryListClick(clickedPosition);
        }
    }
}
