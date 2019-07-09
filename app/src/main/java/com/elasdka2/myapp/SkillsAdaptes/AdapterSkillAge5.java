package com.elasdka2.myapp.SkillsAdaptes;

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

public class AdapterSkillAge5 extends RecyclerView.Adapter<AdapterSkillAge5.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    Context mcontext;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public AdapterSkillAge5(Context context, List<String> data, Context mcontext) {
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
        /*Toast.makeText(mcontext,getItemCount()+ "",Toast.LENGTH_LONG).show();*/
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, YoutubeVideos.class);
                if (position == 0){
                    i.putExtra("Video_URL","SDKgeb3aDsQ");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 1){
                    i.putExtra("Video_URL","1LSdLjKjOLE");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 2){
                    i.putExtra("Video_URL","CvKgP6Ei-U8");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 3){
                    i.putExtra("Video_URL","fHqjNHxmB7c");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 4){
                    i.putExtra("Video_URL","DA8DF6VdX3E");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 5){
                    i.putExtra("Video_URL","BGa3AqeqRy0");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 6){
                    i.putExtra("Video_URL","Qxd9ok73qoA");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 7){
                    i.putExtra("Video_URL","65Ly3XJxdAQ");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 8){
                    i.putExtra("Video_URL","vkRDOcma9Qk");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 9){
                    i.putExtra("Video_URL","PoSfNpyBq5A");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }
                /*else if (position == 10){
                    i.putExtra("Video_URL","09t9f3z_dqk");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 11){
                    i.putExtra("Video_URL","dzvBAaDcM_Y");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 12){
                    i.putExtra("Video_URL","L32Ugx_RX8w");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 13){
                    i.putExtra("Video_URL","gN06dMqQHUA");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 14){
                    i.putExtra("Video_URL","RE5tvaveVak");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 15){
                    i.putExtra("Video_URL","MLZCI9JicFY");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 16){
                    i.putExtra("Video_URL","NBuA6YIQHCs");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 17){
                    i.putExtra("Video_URL","jzSzLFskqrs");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 18){
                    i.putExtra("Video_URL","Q9JJyfnbY6g");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 19){
                    i.putExtra("Video_URL","0cxDUNy1-2k");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 20){
                    i.putExtra("Video_URL","ifXb9PlIsBw");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 21){
                    i.putExtra("Video_URL","CezgTNwk1-s");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 22){
                    i.putExtra("Video_URL","s7pcWnlwcjA");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 23){
                    i.putExtra("Video_URL","wrF1e6boNbc");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }else if (position == 24){
                    i.putExtra("Video_URL","SDKgeb3aDsQ");
                    i.putExtra("Age",5);
                    mcontext.startActivity(i);
                }*/

            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageButton btn;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.video_title1);
            btn = itemView.findViewById(R.id.play_video1);
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}

