package com.kosanworks.belajardoa.doa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.kosanworks.belajardoa.R;

public class SebelumTidur extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sebelum_tidur);

        final Button play = (Button) findViewById(R.id.suara);
        mp = MediaPlayer.create(this, R.raw.doa_sebelum_tidur);
        mp.setLooping(false);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                    play.setText("Mainkan");
                } else {
                    mp.start();
                    play.setText("Jeda");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }
}