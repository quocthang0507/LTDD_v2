package com.dinhtrongdat.lab2bai4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Planet> listData;
    private int layout;
    private Context context;

    public CustomListAdapter(List<Planet> listData, int layout, Context context) {
        this.listData = listData;
        this.layout = layout;
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtDetail = (TextView) view.findViewById(R.id.txtDetail);
        ImageView imgView = (ImageView) view.findViewById(R.id.imageView);

        Planet planet = listData.get(i);

        txtName.setText(planet.getPlanetName());
        txtDetail.setText(planet.getDetail());
        imgView.setImageResource(planet.getPic());

        return view;
    }
}
