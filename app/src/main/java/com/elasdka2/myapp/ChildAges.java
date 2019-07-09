package com.elasdka2.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChildAges extends AppCompatActivity {
    @BindView(R.id.child_age_one_btn)
    Button btn_one;
    @BindView(R.id.child_age_two_btn)
    Button btn_two;
    @BindView(R.id.child_age_three_btn)
    Button btn_three;
    @BindView(R.id.child_age_four_btn)
    Button btn_four;
    @BindView(R.id.child_age_five_btn)
    Button btn_five;

    Animation animation;

    private DatabaseReference Users_Ref;
    private FirebaseAuth mAuth;

    @OnClick(R.id.child_age_one_btn)
    public void GoToOne(){
        Intent one = new Intent(ChildAges.this,YoutubeSongs.class);
        one.putExtra("ID2",1);
        startActivity(one);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }


    @OnClick(R.id.child_age_two_btn)
    public void GoToTwo(){
        Intent two = new Intent(ChildAges.this,ChildCategories.class);
        two.putExtra("ID",2);
        startActivity(two);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.child_age_three_btn)
    public void GoToThree(){
        Intent three = new Intent(ChildAges.this,ChildCategories.class);
        three.putExtra("ID",3);
        startActivity(three);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.child_age_four_btn)
    public void GoToFour(){
        Intent four = new Intent(ChildAges.this,ChildCategories.class);
        four.putExtra("ID",4);
        startActivity(four);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.child_age_five_btn)
    public void GoToFive(){
        Intent five = new Intent(ChildAges.this,ChildCategories.class);
        five.putExtra("ID",5);
        startActivity(five);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_ages_act);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));

        mAuth = FirebaseAuth.getInstance();
        Users_Ref = FirebaseDatabase.getInstance().getReference("Users");

        animation = AnimationUtils.loadAnimation(this,R.anim.stb);

        btn_two.setAlpha(0);
        btn_three.setAlpha(0);
        btn_four.setAlpha(0);
        btn_five.setAlpha(0);

        btn_five.setTranslationY(400);

        btn_two.setTranslationX(800);
        btn_three.setTranslationX(800);
        btn_four.setTranslationX(800);

        btn_two.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        btn_three.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        btn_four.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();

        btn_five.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        btn_one.startAnimation(animation);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChildAges.this,Categories.class));
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
