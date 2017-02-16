package com.kosanworks.belajardoa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//    MediaPlayer player;
//    ImageView suara;
//    private PowerManager.WakeLock wl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        Intent svc=new Intent(this, AudioService.class);
        startService(svc);
        Button doa = (Button) findViewById(R.id.doa);
        doa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BelajarDoa.class);
                stop();
                startActivity(i);
            }
        });
        Intent k = new Intent(MainActivity.this, Tentang.class);
        startService(k);

        Button tantangan = (Button) findViewById(R.id.tantangan);
        tantangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, QuizActivity.class);
                stop();
                startActivity(i);
            }
        });

        Button panduan = (Button) findViewById(R.id.panduan);
        panduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Panduan.class);
                stop();
                startActivity(i);
            }
        });

        Button tentang = (Button) findViewById(R.id.tentang);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Tentang.class);
                startActivity(i);
                stop();
            }
        });

        final Button keluar = (Button) findViewById(R.id.keluar);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keluarGame();
            }
        });
    }

    private void keluarGame() {
        AlertDialog.Builder exit = new AlertDialog.Builder(MainActivity.this);
        exit.setMessage
                ("Apakah kamu ingin keluar dari aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                                stop();
                                finish();
                            }
                        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = exit.create();
        dialog.setTitle("Keluar");
        dialog.show();
    }
    @Override
    public void onBackPressed() {
        keluarGame();
    }
    public void stop() {
        stopService(new Intent(this, AudioService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(this,AudioService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }
}
