package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.coding.pixel.ca.R;

public class PrivateSectorActivity extends AppCompatActivity {

    private VideoView pvtVideoView;
    private Toolbar pvtToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_sector);

        pvtToolbar = findViewById(R.id.pvt_toolbar);
        setSupportActionBar(pvtToolbar);
        getSupportActionBar().setTitle("Private Sector");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pvtVideoView = (VideoView)findViewById(R.id.pvt_video);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.job_video);
        pvtVideoView.setVideoURI(uri);
        pvtVideoView.seekTo(1);
        pvtVideoView.start();

        pvtVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setVolume(0, 0);
            }
        });
    }
}
