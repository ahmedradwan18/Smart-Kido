package com.elasdka2.myapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.elasdka2.myapp.StoriesAdapters.AdapterStoriesAge2;
import com.elasdka2.myapp.StoriesAdapters.AdapterStoriesAge3;
import com.elasdka2.myapp.StoriesAdapters.AdapterStoriesAge4;
import com.elasdka2.myapp.StoriesAdapters.AdapterStoriesAge5;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class YoutubeStories extends YouTubeBaseActivity {

    @BindView(R.id.youtube_view_default_stories)
    YouTubePlayerView myoutubeplayer;
    @BindView(R.id.recycler_stories)
    RecyclerView recyclerView;

    Context mcontext;

    YouTubePlayer.OnInitializedListener mInitializeListener;

    int uniqueID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_stories_act);
        ButterKnife.bind(this);

        uniqueID = getIntent().getExtras().getInt("ID2");

        mcontext = YoutubeStories.this;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 1) {

            } else if (uniqueID == 2) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("Chicken Little - Story Time for Kids at Cool School!");
                VideosTitle.add("The Hardworking Mother - Good Habits Bedtime Stories & Moral Stories for Kids");
                VideosTitle.add("The Goose Girl Story");
                VideosTitle.add("The Gingerbread Man | Full Story ");
                VideosTitle.add("Naughty ChaCha Gets Lost");

                AdapterStoriesAge2 recycler_adapter = new AdapterStoriesAge2(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);

            } else if (uniqueID == 3) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("THE MAGIC POT STORY | STORIES FOR KIDS");
                VideosTitle.add("A GLASS OF MILK | ENGLISH ANIMATED STORIES FOR KIDS");
                VideosTitle.add("BAD HABITS - MORAL STORIES FOR KIDS || KIDS LEARNING");
                VideosTitle.add("Lazy Son | Moral Stories for Kids in English ");
                VideosTitle.add("The Two Frogs | English Short Stories For Children");

                AdapterStoriesAge3 recycler_adapter = new AdapterStoriesAge3(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            } else if (uniqueID == 4) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("The Fly that Forgot It's Name");
                VideosTitle.add("The Selfish Crocodile By Faustin Charles Illustrated By Michael Terry");
                VideosTitle.add("The Story of the Three Little Pigs");
                VideosTitle.add("The Snail and The Cherry Tree ");

                AdapterStoriesAge4 recycler_adapter = new AdapterStoriesAge4(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            } else if (uniqueID == 5) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("The Lazy Girl and The Jack and The beanstalk");
                VideosTitle.add("Snow White - Rapunzel - Cinderella Three Beautiful Bedtime Stories");
                VideosTitle.add("Nighty Night Circus – a lovely bedtime story app for kids");
                VideosTitle.add("THE RED ROSE | ENGLISH ANIMATED STORIES FOR KIDS");
                VideosTitle.add("19 Best Short English Stories for Kids Collection");

                AdapterStoriesAge5 recycler_adapter = new AdapterStoriesAge5(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }
        }
        mInitializeListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (uniqueID == 1){
                    youTubePlayer.loadVideo("kzhAvl3wKF8");

                }else if (uniqueID == 2){
                    youTubePlayer.loadVideo("L-9WYPVxjDw");

                }else if (uniqueID == 3){
                    youTubePlayer.loadVideo("HFZAQgmr50E");

                }else if (uniqueID == 4){
                    youTubePlayer.loadVideo("wFYGKOr1zi4");

                }else if (uniqueID == 5){
                    youTubePlayer.loadVideo("HFZAQgmr50E");

                }

                //youTubePlayer.loadVideo("ZzAm13KsBCc");   for single video

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "failed to Initialize");

            }
        };
        myoutubeplayer.initialize(YoutubeConfig.getApiKey(), mInitializeListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(YoutubeStories.this,Categories.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}
