package com.dinhtrongdat.menuorder;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Food> foodList;
    private int layout;
    private Context context;

    public CustomListAdapter(List<Food> foodList, int layout, Context context) {
        this.foodList = foodList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
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
        TextView txtVN = (TextView) view.findViewById(R.id.txtSub);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        ImageView imgView = (ImageView) view.findViewById(R.id.imageView);

        Food food = foodList.get(i);

        txtName.setText(food.getFoodName());
        txtVN.setText(food.getFoddVn());
        txtPrice.setText(food.getPrice() + "");
        imgView.setImageResource(food.getFoodPic());

        return view;
    }
}
