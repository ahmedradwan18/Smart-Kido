package com.elasdka2.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationInstruction extends AppCompatActivity {
    @BindView(R.id.notification_instruction_title)
    TextView instruction_title;
    @BindView(R.id.notification_instruction_description)
    TextView instruction_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_instruction_act);
        ButterKnife.bind(this);

        instruction_title.setVisibility(View.GONE);
        instruction_description.setText(getIntent().getExtras().getString("InstructionDescription"));
    }
}
