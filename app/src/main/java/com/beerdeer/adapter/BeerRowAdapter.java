package com.beerdeer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beerdeer.R;
import com.beerdeer.model.BeerRowItem;
import com.beerdeer.model.NavDrawerItem;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by tim on 13.12.15.
 */
public class BeerRowAdapter extends RecyclerView.Adapter<BeerRowAdapter.MyViewHolder> {
    List<BeerRowItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public BeerRowAdapter(Context context, List<BeerRowItem> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.beer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BeerRowItem current = data.get(position);
        holder.image.setImageResource(current.getImageId());
        holder.name.setText(current.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.beer_name);
            image = (ImageView) itemView.findViewById(R.id.beer_img);
        }
    }
}