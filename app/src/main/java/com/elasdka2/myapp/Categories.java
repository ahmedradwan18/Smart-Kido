package com.elasdka2.myapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.elasdka2.myapp.BroadCastReceiver.AlarmReceiver;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Categories extends AppCompatActivity {
    @BindView(R.id.pregnancyBtn)
    Button pregnancy;
    @BindView(R.id.Child)
    Button child;
    @BindView(R.id.Parents)
    Button parent;
    @BindView(R.id.welcomeTxt)
    TextView welcomeUser;

    private DatabaseReference Users_Ref;
    private FirebaseAuth mAuth;

    @OnClick(R.id.pregnancyBtn)
    public void GoToPregnancy(){
        Intent i = new Intent(Categories.this, Pregnancy.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    @OnClick(R.id.Parents)
    public void GoToParents(){
        Intent i = new Intent(Categories.this, Parents.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.Child)
    public void GoToChild(){
        Intent i = new Intent(Categories.this, ChildAges.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_act);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));
        mAuth = FirebaseAuth.getInstance();
        Users_Ref = FirebaseDatabase.getInstance().getReference("Users");
        RegisterAlarm();

    }

    private void RegisterAlarm(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,38);
        calendar.set(Calendar.SECOND,0);

        Intent intent = new Intent(Categories.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Categories.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
