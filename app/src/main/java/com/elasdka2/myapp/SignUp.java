package com.elasdka2.myapp;

import androidx.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference UsersRef;

    Map<String, String> UsersMap = new HashMap<>();
    ProgressDialog SignUpProgressDialog;
    Context context;
    Animation animation;

    @BindView(R.id.signup_firstname_edt)
    EditText FirstName;
    @BindView(R.id.signup_lastname_edt)
    EditText LastName;
    @BindView(R.id.signup_email_edt)
    EditText Mail;
    @BindView(R.id.signup_password_edt)
    EditText Password;
    @BindView(R.id.signup_sign_btn)
    Button SignUp;
    @BindView(R.id.signup_now_txt)
    TextView SignUp_Now_Txt;
    @BindView(R.id.signup_login_txt)
    TextView SignIn_Txt;

    @OnClick(R.id.signup_login_txt)
    public void GoToLogin(){
        startActivity(new Intent(SignUp.this, Login.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        finish();
    }
    @OnClick(R.id.signup_sign_btn)
    public void SignUp(){
        CheckDataAndCreateNewUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_act);
        ButterKnife.bind(this);
        context = com.elasdka2.myapp.SignUp.this;
        FirebaseApp.initializeApp(context);

        FirstName.clearFocus();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        UsersRef = database.getReference("Users");

        SignUpProgressDialog = new ProgressDialog(this);
        SignUpProgressDialog.setCanceledOnTouchOutside(false);
        SignUpProgressDialog.setCancelable(false);
        SignUpProgressDialog.setMessage("Creating Your Account ...");

        animation = AnimationUtils.loadAnimation(this,R.anim.stb);


        FirstName.setAlpha(0);
        LastName.setAlpha(0);
        Mail.setAlpha(0);
        Password.setAlpha(0);
        SignUp.setAlpha(0);
        SignIn_Txt.setAlpha(0);

        SignUp.setTranslationY(400);
        SignIn_Txt.setTranslationY(600);

        FirstName.setTranslationX(800);
        LastName.setTranslationX(800);
        Mail.setTranslationX(800);
        Password.setTranslationX(800);

        SignUp.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        SignIn_Txt.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        FirstName.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        LastName.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        Mail.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        Password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        SignUp_Now_Txt.startAnimation(animation);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    private void CheckDataAndCreateNewUser() {
        String str_first_name = FirstName.getText().toString().trim();
        String str_last_name = LastName.getText().toString().trim();
        String str_mail = Mail.getText().toString().trim();
        String str_pass = Password.getText().toString().trim();

        if (str_first_name.isEmpty()){
            FirstName.setError("Insert Your First Name Please");
            FirstName.requestFocus();
            return;
        }
        if (str_last_name.isEmpty()){
            LastName.setError("Insert Your Last Name Please");
            LastName.requestFocus();
            return;
        }
        if (str_mail.isEmpty()){
            Mail.setError("Insert Your Mail Please");
            Mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str_mail).matches()){
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

        CreateNewUser(Mail,Password);

    }

    private void CreateNewUser(EditText mail, EditText password) {
        SignUpProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(mail.getText().toString(), password.getText().toString())
                .addOnCompleteListener(SignUp.this, task -> {

                    if (!task.isSuccessful()) {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(getApplicationContext(), "This Email already exists", Toast.LENGTH_SHORT).show();
                            Mail.requestFocus();
                            SignUpProgressDialog.dismiss();
                            return;
                        }
                    } else {

                        FirebaseUser user = mAuth.getCurrentUser();
                        String token_id = FirebaseInstanceId.getInstance().getToken();

                        //*************************************************************
                        UsersMap.put("FirstName", FirstName.getText().toString());
                        UsersMap.put("LastName", LastName.getText().toString());
                        UsersMap.put("e-mail", mail.getText().toString());
                        UsersMap.put("Password", password.getText().toString());
                        UsersMap.put("User_ID", user.getUid());
                        UsersMap.put("token_id", token_id);

                        UsersRef.child(user.getUid()).setValue(UsersMap).addOnCompleteListener(task1 -> {
                            Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_LONG).show();
                            //Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                            SignUpProgressDialog.dismiss();
                            Intent intent = new Intent(SignUp.this, Login.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();

                            ClearTools();


                        }).addOnFailureListener(e -> {
                            SignUpProgressDialog.dismiss();
                            Toast.makeText(SignUp.this, "exception is " + e.toString(), Toast.LENGTH_LONG).show();
                            //Toast.makeText(SignUp.this, "exception is " + e.toString(), Toast.LENGTH_SHORT).show();

                        });

                    }
                });


    }
    private void ClearTools() {
        Mail.setText("");
        Password.setText("");
        FirstName.setText("");
        LastName.setText("");
    }
}
