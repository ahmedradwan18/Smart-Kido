package com.elasdka2.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge4;
import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge5;
import com.elasdka2.myapp.SongsAdapters.AdapterSongAge1;
import com.elasdka2.myapp.SongsAdapters.AdapterSongAge2;
import com.elasdka2.myapp.SongsAdapters.AdapterSongAge3;
import com.elasdka2.myapp.SongsAdapters.AdapterSongAge4;
import com.elasdka2.myapp.SongsAdapters.AdapterSongAge5;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class YoutubeSongs extends YouTubeBaseActivity {
    @BindView(R.id.youtube_view_default_songs)
    YouTubePlayerView myoutubeplayer;


    AdapterSkillAge5 recycler_adapter;
    YouTubePlayer.OnInitializedListener mInitializeListener;

    int uniqueID;
    String IntentFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_songs_act);
        ButterKnife.bind(this);
        Log.d("OnCreate", "Starting ...");

        IntentFrom = getIntent().getExtras().getString("ActivityID");
        uniqueID = getIntent().getExtras().getInt("ID2");




        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 5) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("This Is The Way We Brush Our Teeth Good Habits Song");
                VideosTitle.add("Five Little Speckled Frogs");
                VideosTitle.add("Five Little Ducks");
                VideosTitle.add("Johny Johny Yes Papa Family Song plus");
                VideosTitle.add("10 Little Airplanes ");
                VideosTitle.add("London Bridge is Falling Down Song ");
                VideosTitle.add("No No Yes Yes Go to School Song ");
                VideosTitle.add("Jumping on The Moon Song ");
                AdapterSongAge5 recycler_adapter = new AdapterSongAge5(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }else if (uniqueID == 4){

                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("10 Little Airplanes | Kids Songs ");
                VideosTitle.add("The Skeleton Dance + More | Dance Songs for Kids");
                VideosTitle.add("Phonics Song 2");
                VideosTitle.add("Seasons Song (Animated)");

                AdapterSongAge4 recycler_adapter = new AdapterSongAge4(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }else if (uniqueID == 3){

                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("Music Song | CoCoMelon Nursery Rhymes & Kids Songs");
                VideosTitle.add("The Lunch Song + More Nursery Rhymes & Kids Songs - CoCoMelon");
                VideosTitle.add("Car Wash Song | CoCoMelon Nursery Rhymes & Kids Songs");
                VideosTitle.add("The Boo Boo Song");

                AdapterSongAge3 recycler_adapter = new AdapterSongAge3(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }else if (uniqueID == 2){

                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("The Wheels On The Bus - Cool Songs for Children");
                VideosTitle.add("Johny Johny Yes Papa");
                VideosTitle.add("Popular Kids Sing Along Songs With Lyrics");
                VideosTitle.add("The Potty Song + More Nursery Rhymes & Kids Songs");
                VideosTitle.add("My Daddy Song ");
                VideosTitle.add("Baby is Sick Song + More Nursery Rhymes");
                VideosTitle.add("Yes Yes Bedtime Song");
                VideosTitle.add("I Love My Baby Song");
                VideosTitle.add("Hush Little Baby Lullaby Song for Babies with Lyrics");
                VideosTitle.add("Yes Yes Wake Up Song");

                AdapterSongAge2 recycler_adapter = new AdapterSongAge2(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }else if (uniqueID == 1){

                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("Johny Johny Yes Papa (Parents Version)");
                VideosTitle.add("Five Little Ducks | Childrens Song For Kids");
                VideosTitle.add("SLEEP MUSIC FOR KIDS: Baby Songs to Sleep");
                VideosTitle.add("One Little Finger - Learn English with Songs");
                VideosTitle.add("Baby Shark | + More Kids Songs ");
                VideosTitle.add("LittleBabyBum");
                VideosTitle.add("One Little Finger | featuring Noodle & Pals");
                VideosTitle.add("Mozart for Babies Brain Development");
                VideosTitle.add("Happy Birthday Song");
                VideosTitle.add("Sick Song | CoCoMelon Nursery Rhymes");

                AdapterSongAge1 recycler_adapter = new AdapterSongAge1(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }



                mInitializeListener = new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                        if (uniqueID == 1){
                            youTubePlayer.loadVideo("kzhAvl3wKF8");

                        }else if (uniqueID == 2){
                            youTubePlayer.loadVideo("kzhAvl3wKF8");

                        }else if (uniqueID == 3){
                            youTubePlayer.loadVideo("kzhAvl3wKF8");

                        }else if (uniqueID == 4){
                            youTubePlayer.loadVideo("75p-N9YKqNo");

                        }else if (uniqueID == 5){
                            youTubePlayer.loadVideo("yHZlKFepSSM");

                        }

                        //youTubePlayer.loadVideo("ZzAm13KsBCc");   for single video

                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                     //   Log.d(TAG, "failed to Initializing");

                    }
                };
                myoutubeplayer.initialize(YoutubeConfig.getApiKey(), mInitializeListener);


            }


        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(YoutubeSongs.this,Categories.class));

        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

        finish();
    }
    }
