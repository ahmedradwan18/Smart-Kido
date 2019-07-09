package com.elasdka2.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Parents extends AppCompatActivity {
    @BindView(R.id.oneBtn)
    Button one;
    @BindView(R.id.twoBtn)
    Button two;
    @BindView(R.id.threeBtn)
    Button three;
    @BindView(R.id.fourBtn)
    Button four;
    @BindView(R.id.fiveBtn)
    Button five;

    Animation animation;

    private DatabaseReference Users_Ref;
    private FirebaseAuth mAuth;

    @OnClick(R.id.oneBtn)
    public void GoToAgeOne(){
        Intent one = new Intent(Parents.this, Age_One.class);
        startActivity(one);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.twoBtn)
    public void GoToAgeTwo(){
        Intent two = new Intent(Parents.this, Age_Two.class);
        startActivity(two);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.threeBtn)
    public void GoToAgeThree(){
        Intent three = new Intent(Parents.this, Age_Three.class);
        startActivity(three);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.fourBtn)
    public void GoToAgeFour(){
        Intent four = new Intent(Parents.this, Age_Four.class);
        startActivity(four);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.fiveBtn)
    public void GoToAgeFive(){
        Intent five = new Intent(Parents.this, Age_Five.class);
        startActivity(five);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parents_act);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));

        mAuth = FirebaseAuth.getInstance();
        Users_Ref = FirebaseDatabase.getInstance().getReference("Users");

        animation = AnimationUtils.loadAnimation(this,R.anim.stb);

        two.setAlpha(0);
        three.setAlpha(0);
        four.setAlpha(0);
        five.setAlpha(0);

        five.setTranslationY(400);

        two.setTranslationX(800);
        three.setTranslationX(800);
        four.setTranslationX(800);

        two.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        three.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        four.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();

        five.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        one.startAnimation(animation);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Parents.this, Categories.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
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
