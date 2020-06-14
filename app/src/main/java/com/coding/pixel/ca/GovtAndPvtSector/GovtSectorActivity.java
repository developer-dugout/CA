package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class GovtSectorActivity extends AppCompatActivity {

    private VideoView govtVideoView;
    private Toolbar govtToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_sector);

        govtToolbar = findViewById(R.id.govt_toolbar);
        setSupportActionBar(govtToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Govt Sector");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        govtVideoView = (VideoView)findViewById(R.id.govt_video);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.job_video);
        govtVideoView.setVideoURI(uri);
        govtVideoView.seekTo(1);
        govtVideoView.start();

        govtVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setVolume(0, 0);
            }
        });
    }
}
