package com.dinhtrongdat.lab06.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.lab06.Classes.DoDai;
import com.dinhtrongdat.lab06.R;

import java.util.List;

public class DoDaiAdapter extends RecyclerView.Adapter<DoDaiAdapter.dodaiViewHolder> {

    List<DoDai> data;

    public DoDaiAdapter(List<DoDai> data) {
        this.data = data;
    }

    @Override
    public dodaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_dodai, parent, false);
        return new dodaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoDaiAdapter.dodaiViewHolder holder, int position) {
        DoDai doDai = data.get(position);
        holder.name.setText(doDai.getName());
        holder.number.setText(String.valueOf(doDai.getDoDai()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class dodaiViewHolder extends RecyclerView.ViewHolder {

        TextView name, number;

        public dodaiViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lb_name_donvi);
            number = itemView.findViewById(R.id.lb_number_dodai);
        }
    }
}
