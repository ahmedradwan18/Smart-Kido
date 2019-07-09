package com.elasdka2.myapp.SongsAdapters;

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

public class AdapterSongAge5 extends RecyclerView.Adapter<AdapterSongAge5.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    Context mcontext;


    // data is passed into the constructor
    public AdapterSongAge5(Context context, List<String> data, Context mcontext) {
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
                Intent i = new Intent(mcontext, YoutubeVideos.class);
                if (position == 0){
                    i.putExtra("Video_URL","26k-o8taW_4");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 1){
                    i.putExtra("Video_URL","VQTVrxj4l6o");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 2){
                    i.putExtra("Video_URL","pZw9veQ76fo");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 3){
                    i.putExtra("Video_URL","_gpsKQhc7yg");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 4){
                    i.putExtra("Video_URL","VNRNAloCb5Y");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 5){
                    i.putExtra("Video_URL","tBn2UZPwrQE");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 6){
                    i.putExtra("Video_URL","4GcLWywzQXY");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 7){
                    i.putExtra("Video_URL","X5RiEcbR56E");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
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

