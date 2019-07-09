package com.elasdka2.myapp.StoriesAdapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elasdka2.myapp.R;
import com.elasdka2.myapp.YoutubeVideos;

import java.util.List;

public class AdapterStoriesAge3 extends RecyclerView.Adapter<AdapterStoriesAge3.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    Context mcontext;


    // data is passed into the constructor
    public AdapterStoriesAge3(Context context, List<String> data, Context mcontext) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mcontext = mcontext;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String Title = mData.get(position);
        holder.myTextView.setText(Title);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext,YoutubeVideos.class);
                if (position == 0){
                    i.putExtra("Video_URL","KHzJVnY2egA");
                    i.putExtra("Age",3);
                    mcontext.startActivity(i);
                    ((Activity)mcontext).finish();
                }else if (position == 1){
                    i.putExtra("Video_URL","aTi5dbVmUhU");
                    i.putExtra("Age",3);
                    mcontext.startActivity(i);
                    ((Activity)mcontext).finish();
                }else if (position == 2){
                    i.putExtra("Video_URL","Xtp0CMb3afQ");
                    i.putExtra("Age",3);
                    mcontext.startActivity(i);
                    ((Activity)mcontext).finish();
                }else if (position == 3){
                    i.putExtra("Video_URL","QkaqcgmUlqQ");
                    i.putExtra("Age",3);
                    mcontext.startActivity(i);
                    ((Activity)mcontext).finish();
                }else if (position == 4){
                    i.putExtra("Video_URL","kIPrjjAmsrM");
                    i.putExtra("Age",3);
                    mcontext.startActivity(i);
                    ((Activity)mcontext).finish();
                }

            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageButton btn;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.video_title1);
            btn = itemView.findViewById(R.id.play_video1);
        }


    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught

}

