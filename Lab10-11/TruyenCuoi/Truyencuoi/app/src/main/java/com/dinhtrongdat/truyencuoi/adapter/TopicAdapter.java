package com.dinhtrongdat.truyencuoi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.truyencuoi.R;
import com.dinhtrongdat.truyencuoi.model.Topic;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    ArrayList<Topic> topicLocation;
    final private ListItemClickListener mOnClickListener;

    public TopicAdapter(ArrayList<Topic> topicLocation, ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
        this.topicLocation = topicLocation;
    }

    @Override
    public TopicViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TopicAdapter.TopicViewHolder holder, int position) {
        Topic topicHelper = topicLocation.get(position);
        holder.imgView.setImageBitmap(topicHelper.getImg());
        holder.txtView.setText(topicHelper.getName());
    }

    @Override
    public int getItemCount() {
        return topicLocation.size();
    }

    public interface ListItemClickListener {
        void onTopicListClick(int clickedItemIndex);
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgView;
        TextView txtView;

        public TopicViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgView = itemView.findViewById(R.id.iv_topic);
            txtView = itemView.findViewById(R.id.tv_topic);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onTopicListClick(clickedPosition);
        }
    }
}
