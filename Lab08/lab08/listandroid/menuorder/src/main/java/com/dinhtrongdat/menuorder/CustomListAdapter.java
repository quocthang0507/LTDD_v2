package com.dinhtrongdat.menuorder;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.menu_order, viewGroup, false);

            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtVN = view.findViewById(R.id.txtSub);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.imgView = view.findViewById(R.id.imageView);
            holder.btnEdit = view.findViewById(R.id.btnEdit);
            holder.btnDel = view.findViewById(R.id.btnDel);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Food food = foodList.get(i);

        holder.txtName.setText(food.getFoodName());
        holder.txtVN.setText(food.getFoddVn());
        holder.txtPrice.setText(food.getPrice() + "");
        holder.imgView.setImageResource(food.getFoodPic());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogEdit(i);
            }
        });
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodList.remove(i);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private void DialogEdit(int pos){
        Food food = foodList.get(pos);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_add);

        EditText dienTen = (EditText) dialog.findViewById(R.id.txtNhapTen1);
        EditText dienTen2 = (EditText) dialog.findViewById(R.id.txtNhapTen2);
        EditText gia = (EditText) dialog.findViewById(R.id.txtGia);

        dienTen.setText(food.getFoodName().toString());
        dienTen2.setText(food.getFoddVn().toString());
        gia.setText(String.valueOf(food.getPrice()));

        Button btnAdd = (Button) dialog.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food.setFoodName(dienTen.getText().toString());
                food.setFoddVn(dienTen2.getText().toString());
                food.setPrice((Double.parseDouble(gia.getText().toString())));
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public class ViewHolder{
        TextView txtName,txtVN,txtPrice;
        ImageView imgView;
        ImageButton btnEdit, btnDel;
    }
}
