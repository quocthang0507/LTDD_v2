package com.dinhtrongdat.customgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterGridView extends BaseAdapter {

    private List<Genius> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomAdapterGridView(List<Genius> listData, Context context) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.custom_item,null);
            holder = new ViewHolder();
            holder.imgView = view.findViewById(R.id.imageView);
            holder.txtTitle = view.findViewById(R.id.textView_title);
            holder.txtNumber = view.findViewById(R.id.textView_population);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Genius genius = this.listData.get(i);
        holder.txtTitle.setText(genius.getTitle());
        holder.txtNumber.setText(String.valueOf(genius.getNumber()));
        holder.imgView.setImageResource(genius.getImage());

        return view;
    }
    public class ViewHolder{
        ImageView imgView;
        TextView txtTitle, txtNumber;
    }
}
