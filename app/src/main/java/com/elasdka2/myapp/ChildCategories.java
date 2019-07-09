package com.elasdka2.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChildCategories extends AppCompatActivity {
    private DatabaseReference Users_Ref;
    private FirebaseAuth mAuth;
    @BindView(R.id.songs_category)
    Button sound;
    @BindView(R.id.paint)
    Button paint;
    Intent intent;
    int uniqueID;

    @BindView(R.id.skills_category)
    Button skills;
    @BindView(R.id.stories_category)
    Button stories;


@OnClick(R.id.paint)
public void goToPaint(){
    Intent i=new Intent(ChildCategories.this, painting.class);
    startActivity(i);
    finish();
}

    @OnClick(R.id.songs_category)
    public void Songs(){
        Intent i = new Intent(ChildCategories.this, YoutubeSongs.class);
        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 1){
                i.putExtra("ID2", 1);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 2){
                i.putExtra("ID2", 2);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 3){
                i.putExtra("ID2", 3);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 4){
                i.putExtra("ID2", 4);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);

            }else if (uniqueID == 5){
                i.putExtra("ID2", 5);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }


        } else
        {
            Toast.makeText(ChildCategories.this, "id is null", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @OnClick(R.id.stories_category)
    public void Stories(){
        Intent i = new Intent(ChildCategories.this, YoutubeStories.class);
        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 1){
                i.putExtra("ID2", 1);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 2){
                i.putExtra("ID2", 2);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 3){
                i.putExtra("ID2", 3);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 4){
                i.putExtra("ID2", 4);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);

            }else if (uniqueID == 5){
                i.putExtra("ID2", 5);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }


        } else
        {
            Toast.makeText(ChildCategories.this, "id is null", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @OnClick(R.id.skills_category)
    public void Skills(){
        Intent i = new Intent(ChildCategories.this, YoutubeSkills.class);
        if (!TextUtils.isEmpty(String.valueOf(uniqueID))) {
            if (uniqueID == 1){
                i.putExtra("ID2", 1);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 2){
                i.putExtra("ID2", 2);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 3){
                i.putExtra("ID2", 3);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }else if (uniqueID == 4){
                i.putExtra("ID2", 4);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);

            }else if (uniqueID == 5){
                i.putExtra("ID2", 5);
                i.putExtra("ActivityID", "child_categories");
                startActivity(i);
            }


        } else
        {
            Toast.makeText(ChildCategories.this, "id is null", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_categories_act);
        ButterKnife.bind(this);
        intent = getIntent();
        uniqueID = intent.getExtras().getInt("ID");

        if (uniqueID == 3){
            paint.setVisibility(View.VISIBLE);

        }

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));
        mAuth = FirebaseAuth.getInstance();
        Users_Ref = FirebaseDatabase.getInstance().getReference("Users");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChildCategories.this,ChildAges.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.logOut){
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
            reference.child(mAuth.getCurrentUser().getUid()).removeValue();
            Users_Ref.child(mAuth.getCurrentUser().getUid()).child("token_id").removeValue().addOnSuccessListener(aVoid -> {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
