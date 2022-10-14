package com.dinhtrongdat.listandroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Product> list;

    public ListViewAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = View.inflate(viewGroup.getContext(), R.layout.custom_listview,null);
        Product product = (Product)getItem(i);
        ImageView img = view.findViewById(R.id.imgRow);
        img.setImageResource(product.image);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(product.title);
        TextView txtContent = view.findViewById(R.id.txtContent);
        txtContent.setText(product.content);
        return view;
    }
}
