package com.elasdka2.myapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class painting extends AppCompatActivity {
    @BindView(R.id.myCanvas)
    CanvasView canvasview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painting_act);
        ButterKnife.bind(this);

    }

    public void clearCanvas(View v){
        canvasview.clearCanvas();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(painting.this,ChildCategories.class);
        i.putExtra("ID",3);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}
