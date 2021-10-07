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
    private final ArrayList<StoryEntity> storyLocation;
    private final Context mContext;

    public StoryAdapter(ArrayList<StoryEntity> storyLocation, Context mContext) {
        this.storyLocation = storyLocation;
        this.mContext = mContext;
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

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public StoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_story);
            itemView.setOnClickListener(view -> {
                ((MainActivity)mContext).gotoM003Screen(storyLocation,(StoryEntity)tvName.getTag());
            });
        }

    }
}
