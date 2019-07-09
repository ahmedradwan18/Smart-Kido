package com.elasdka2.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {
    ProgressDialog LoginProgressDialog;
    Context context;
    Animation animation;

    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef;

    @BindView(R.id.login_email_edt)
    EditText Mail;
    @BindView(R.id.login_password_edt)
    EditText Password;
    @BindView(R.id.login_login_btn)
    Button Login;
    @BindView(R.id.login_signup_btn)
    Button SignUp;
    @BindView(R.id.login_now_txt)
    ImageView Login_Now;
    @BindView(R.id.login_forgot_password)
    TextView Forgot_Password;

    @OnClick(R.id.login_forgot_password)
    public void ForgotPassword(){
        Toast.makeText(context, "It will done soon isa ...", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login_signup_btn)
    public void GoToSignUp(){
        startActivity(new Intent(Login.this, SignUp.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.login_login_btn)
    public void Login(){
        CheckDataAndLogin();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        ButterKnife.bind(this);
        context = Login.this;

        mAuth = FirebaseAuth.getInstance();
        UsersRef = FirebaseDatabase.getInstance().getReference("Users");

        LoginProgressDialog = new ProgressDialog(this);
        LoginProgressDialog.setCanceledOnTouchOutside(false);
        LoginProgressDialog.setCancelable(false);
        LoginProgressDialog.setMessage("Logging To Your Account ...");

        animation = AnimationUtils.loadAnimation(this,R.anim.stb);

        Mail.setAlpha(0);
        Password.setAlpha(0);
        Login.setAlpha(0);
        SignUp.setAlpha(0);

        Login.setTranslationY(400);
        SignUp.setTranslationY(600);

        Mail.setTranslationX(800);
        Password.setTranslationX(800);
        Forgot_Password.setTranslationX(800);

        Login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        SignUp.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        Mail.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        Password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        Forgot_Password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        Login_Now.startAnimation(animation);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
    private void CheckDataAndLogin() {
        String str_email = Mail.getText().toString().trim();
        String str_pass = Password.getText().toString().trim();
        if (str_email.isEmpty()){
            Mail.setError("Insert Your Mail Please");
            Mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches()){
            Mail.setError("Invalid Email !");
            Mail.requestFocus();
            return;
        }
        if (str_pass.isEmpty()){
            Password.setError("Insert Your Password Please");
            Password.requestFocus();
            return;
        }
        if (str_pass.length() < 6){
            Password.setError("Required 6 char at least");
            Password.requestFocus();
            return;
        }
        //-------------------------------------------
        Query query = UsersRef.orderByChild("e-mail").equalTo(Mail.getText().toString());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    LoginWithUser(Mail,Password);
                }else{
                    Toast.makeText(getApplicationContext(),"This Email doesn't exist !",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //-------------------------------------------
    }

    private void LoginWithUser(EditText mail, EditText password) {
        LoginProgressDialog.show();

        mAuth.signInWithEmailAndPassword(mail.getText().toString(), password.getText().toString())
                .addOnCompleteListener(Login.this, task -> {
                    if (task.isSuccessful()) {

                        String token_id = FirebaseInstanceId.getInstance().getToken();
                        String user_id = mAuth.getCurrentUser().getUid();

                        UsersRef.child(user_id).child("token_id").setValue(token_id).addOnSuccessListener(aVoid -> {

                            Intent intent = new Intent(Login.this, Categories.class);
                            intent.putExtra("email", mail.getText().toString());
                            LoginProgressDialog.dismiss();
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                            finish();
                            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();

                            mail.setText("");
                            password.setText("");

                        }).addOnFailureListener(e -> {
                            LoginProgressDialog.dismiss();
                            Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                        });

                    } else {
                        LoginProgressDialog.dismiss();
                        Toast.makeText(Login.this, "Authentication failed because " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
