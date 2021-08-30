package com.dinhtrongdat.danhbadienthoai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<contast> {
    private Context context;
    private int resource;
    private List<contast> list;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<contast> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_adapter, parent, false);

            viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.img_view);
            viewHolder.textName = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder.textNum = (TextView) convertView.findViewById(R.id.text_std);

            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        contast con = list.get(position);

        viewHolder.textName.setText(con.getmName());
        viewHolder.textNum.setText(con.getmNumPhone());

        if(con.getmAvatar().equals("Gia đình")){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.family);
        }
        else if (con.getmAvatar().equals("Bạn bè")){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.relation);
        }
        else if (con.getmAvatar().equals("Cơ quan")){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.busines);
        }
        else if(con.getmAvatar().equals("Trường học")){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.meeting);
        }


        return convertView;
    }

    public class ViewHolder{
        ImageView imgAvatar;
        TextView textName;
        TextView textNum;
    }
}
