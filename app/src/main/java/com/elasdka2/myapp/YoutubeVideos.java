package com.elasdka2.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class YoutubeVideos extends YouTubeBaseActivity {
    Context context;
    String URL, TITLE;

    @BindView(R.id.youtube_view_clicked)
    YouTubePlayerView myoutubeplayer;

    YouTubePlayer.OnInitializedListener mInitializeListner;
    int age;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_videos_act);
        ButterKnife.bind(this);
        context = YoutubeVideos.this;

        intent = getIntent();
        URL = intent.getExtras().getString("Video_URL");
        age = intent.getExtras().getInt("Age");
        mInitializeListner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!TextUtils.isEmpty(URL)){
                    youTubePlayer.loadVideo(URL);

                }else {
                    Toast.makeText(context,"Video Url is not available",Toast.LENGTH_LONG).show();
                    return;
                }


                //youTubePlayer.loadVideo("ZzAm13KsBCc");   for single video
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "failed to Initializing");

            }
        };
        myoutubeplayer.initialize(YoutubeConfig.getApiKey(), mInitializeListner);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (age == 1) {
            Intent i = new Intent(YoutubeVideos.this, ChildAges.class);
            i.putExtra("ID", age);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        } else {
            Intent i = new Intent(YoutubeVideos.this, ChildCategories.class);
            i.putExtra("ID", age);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }
    }
}
