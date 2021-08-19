package com.dinhtrongdat.todolistt;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private MainActivity context;
    private int layout;
    private List<CongViec> list;

    public CustomAdapter(@NonNull MainActivity context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_adapter, parent, false);

            viewHolder.txtTen = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.BtnEdit = (ImageButton) convertView.findViewById(R.id.btnEdit);
            viewHolder.btnDelete = (ImageButton) convertView.findViewById(R.id.btnDelete);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CongViec cv = list.get(position);
        viewHolder.txtTen.setText(cv.getTenCV());


        viewHolder.BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogEdit(cv.getTenCV(), cv.getId());
            }
        });
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DeleteQuery(cv.getTenCV(), cv.getId());
            }
        });

        return convertView;
    }

    private class ViewHolder{
        TextView txtTen;
        ImageButton BtnEdit, btnDelete;

    }


}
