package com.kosanworks.belajardoa;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class AudioService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
//        Log.e("t","jalan");
        player = MediaPlayer.create(this, R.raw.belajar_doa);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return flags;
    }

    public void onStart(Intent intent, int startId) {
//        player.start();
//        Log.e("t","jalan");

    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

//    public void onStop() {
//
//    }
//    public void onPause() {
////      player.pause();
//    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}