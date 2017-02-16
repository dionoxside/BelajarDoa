package com.kosanworks.belajardoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Panduan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_panduan);
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startService(new Intent(this, AudioService.class));
    }
}
