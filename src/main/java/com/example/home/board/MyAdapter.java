package com.example.home.board;

/**
 * Created by home on 2017-07-07.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    List<Chat> mChat;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public TextView dTextView;

        public ViewHolder(View itemView){
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.title2);
            dTextView = (TextView) itemView.findViewById(R.id.date2);
        }
    }

    public MyAdapter( List<Chat> mChat){
        this.mChat = mChat;
    }

    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singer_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText(mChat.get(position).getTitle());
        holder.dTextView.setText(mChat.get(position).getDate());
    }

    public int getItemCount(){
        return mChat.size();
    }
}
