package com.elasdka2.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge2;
import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge3;
import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge4;
import com.elasdka2.myapp.SkillsAdaptes.AdapterSkillAge5;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class YoutubeSkills extends YouTubeBaseActivity {
    @BindView(R.id.youtube_view_default)
    YouTubePlayerView myoutubeplayer;

    Context mcontext;


    YouTubePlayer.OnInitializedListener mInitializeListener;

    int uniqueID;
    String IntentFrom;

    /*@OnClick(R.id.play_video1)
    public void PlayVideo1(){
        Intent one = new Intent(YoutubeSongs.this,YoutubeVideos.class);
        one.putExtra("URL","26k-o8taW_4");
        one.putExtra("Title","This Is The Way We Brush Our Teeth Good Habits Song");
        startActivity(one);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.play_video2)
    public void PlayVideo2(){
        Intent two = new Intent(YoutubeSongs.this,YoutubeVideos.class);
        two.putExtra("URL","VQTVrxj4l6o");
        startActivity(two);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_skills_act);
        ButterKnife.bind(this);
        Log.d("OnCreate", "Starting ...");

        IntentFrom = getIntent().getExtras().getString("ActivityID");
        uniqueID = getIntent().getExtras().getInt("ID2");


        mcontext = YoutubeSkills.this;

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 1) {

            } else if (uniqueID == 2) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("Kids Videos With Play Doh 36");
                VideosTitle.add("Yes Yes Vegetables Song");
                VideosTitle.add("No No Bedtime Song");
                VideosTitle.add("Baby Bath Time | Bath Song");
                VideosTitle.add("Menggambar Dan Mewarnai Macam-macam Es Krim Warna Warni Untuk Anak-anak");
                VideosTitle.add("Vegetables are Good for Health");
                VideosTitle.add("Menggambar Dan Mewarnai Alat Set Kecantikan Warna Warni Glitter Untuk Anak-anak");
                VideosTitle.add("vegetables song | learn vegetables | nursery rhymes ");
                VideosTitle.add("Cara Menggambar dan Mewarnai Mobil");
                VideosTitle.add("Belajar Cara Menggambar dan Mewarnai Tuk-Tuk Auto Rickshaw");

                AdapterSkillAge2 recycler_adapter = new AdapterSkillAge2(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);

            } else if (uniqueID == 3) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("The Tale of the Sun and the Moon");
                VideosTitle.add("English Talking Book - Daytime And Nighttime");
                VideosTitle.add("Different Times of The Day");
                VideosTitle.add("Good Manners | Songs for kids | Kidloom");

                AdapterSkillAge3 recycler_adapter = new AdapterSkillAge3(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            } else if (uniqueID == 4) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("The Same or Different Game 1");
                VideosTitle.add("How Many Fingers? | Kids Songs | Super Simple Songs");
                VideosTitle.add("The Numbers Song - Learn To Count from 1 to 10");
                VideosTitle.add("LittleBabyBum");
                VideosTitle.add("Aprende los Colores ");
                VideosTitle.add("Colors Song - Learn Colors ");
                AdapterSkillAge4 recycler_adapter = new AdapterSkillAge4(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            } else if (uniqueID == 5) {
                ArrayList<String> VideosTitle = new ArrayList<>();
                VideosTitle.add("This Is The Way We Brush Our Teeth Good Habits Song");
                VideosTitle.add("Five Little Speckled Frogs");
                VideosTitle.add("Five Little Ducks");
                VideosTitle.add("Johny Johny Yes Papa Family Song");
                VideosTitle.add("10 Little Airplanes");
                VideosTitle.add("Learn Shapes with Wooden Truck Toy - Colors and Shapes");
                VideosTitle.add("Balloon Boat Race +More Nursery Rhymes & Kids Songs");
                VideosTitle.add("Learning Songs ABCs, Colors, 123s");
                VideosTitle.add("Making 3 Ice Cream out of Play Doh Learn Colors");
                VideosTitle.add("4 Colors Play Doh Ice Cream Cups PJ Masks");

                /*VideosTitle.add("Belajar Cara Menggambar dan Mewarnai Tuk-Tuk Auto Rickshaw");
                VideosTitle.add("Cara Menggambar dan Mewarnai Spongebob dan Patrick");
                VideosTitle.add("Baby Songs and Nursery Rhymes");
                VideosTitle.add("Vegetable Song | Songs for kids");
                VideosTitle.add("This Little Piggy + More ChuChu TV 3D Nursery Rhymes");
                VideosTitle.add("Rain, Rain, Go Away and Many More Videos");
                VideosTitle.add("Learn Farm Animals Names & Sounds For Kids");
                VideosTitle.add("100 Animals for Kids, Toddlers and Babies in English");
                VideosTitle.add("humpty dumpty sat on a wall | nursery rhymes");
                VideosTitle.add("World Animal Adventure, Part 1");
                VideosTitle.add("Swimming Song | +More Nursery Rhymes & Kids Songs");
                VideosTitle.add("Going To the Forest (SINGLE) | Wild Animals for Kids");
                VideosTitle.add("wash Your Hands Song for Kids");
                VideosTitle.add("Five Little Fingers | Parts of the Body Song\n");
                VideosTitle.add("Learn Dinosaur Names with Dino Finger Family\n");
                VideosTitle.add("World Animal Adventure, Part 2");*/


                AdapterSkillAge5 recycler_adapter = new AdapterSkillAge5(this, VideosTitle, this);
                recyclerView.setAdapter(recycler_adapter);
            }


            mInitializeListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    if (uniqueID == 1) {
                        youTubePlayer.loadVideo("kzhAvl3wKF8");

                    } else if (uniqueID == 2) {
                        youTubePlayer.loadVideo("DOT15xaX7-E");

                    } else if (uniqueID == 3) {
                        youTubePlayer.loadVideo("tkpfg-1FJLU");

                    } else if (uniqueID == 4) {
                        youTubePlayer.loadVideo("75p-N9YKqNo");

                    } else if (uniqueID == 5) {
                        youTubePlayer.loadVideo("yHZlKFepSSM");

                    }

                    //youTubePlayer.loadVideo("ZzAm13KsBCc");   for single video

                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.d(TAG, "failed to Initializing");

                }
            };
            myoutubeplayer.initialize(YoutubeConfig.getApiKey(), mInitializeListener);


        }


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(YoutubeSkills.this,Categories.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

}
