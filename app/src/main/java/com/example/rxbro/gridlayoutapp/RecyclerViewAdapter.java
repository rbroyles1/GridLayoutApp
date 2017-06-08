package com.example.rxbro.gridlayoutapp;

import android.content.Context;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.data;

/**
 * Created by rxbro on 6/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private String[] Data = new String[0];
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public RecyclerViewAdapter(Context context, String[] data) {
        this.inflater = LayoutInflater.from(context);
        this.Data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = Data[position];
        holder.textView.setText(position);

    }

    @Override
    public int getItemCount() {
        return Data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());

            }
        }
    }
    public String getItem(int id) {
        return Data[id];
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
