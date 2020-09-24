package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class GovtSectorActivity extends AppCompatActivity {

    private VideoView govtVideoView;
    private Toolbar govtToolbar;
    private CardView uniCard, collegeCard, schoolCard, privateCard;
    private TextView coursesView, mediaView, eventsView, upcomingView;
    private ImageView educatorView, outlineView, ptbView, alertsView, badgesView, historyView, libView, sectorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_sector);

        govtToolbar = findViewById(R.id.media_appbar);
        setSupportActionBar(govtToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Commercial Sector");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        uniCard = findViewById(R.id.uni_card);
        uniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uniCardIntent = new Intent(GovtSectorActivity.this, Educational_institutes_info.class);
                startActivity(uniCardIntent);
            }
        });
        collegeCard = findViewById(R.id.college_card);
        collegeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collegeCardIntent = new Intent(GovtSectorActivity.this, AllCollegesOfPakActivity.class);
                startActivity(collegeCardIntent);
            }
        });
        schoolCard = findViewById(R.id.school_card);
        schoolCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent schoolCardIntent = new Intent(GovtSectorActivity.this, AllSchoolsOfPakActivity.class);
                startActivity(schoolCardIntent);
            }
        });
        privateCard = findViewById(R.id.private_card);
        privateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pvtCardIntent = new Intent(GovtSectorActivity.this, PvtEducationPakActivity.class);
                startActivity(pvtCardIntent);
            }
        });

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

        coursesView = findViewById(R.id.current_courses);
        coursesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://gotest.pk/careers/best-computer-courses-list-in-pakistan/#:~:text=%20Computer%20Courses%20in%20Pakistan%20%201%20Diploma,UNIX%2019%20Visual%20Basic%2020%20Windows%20More%20");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        mediaView = findViewById(R.id.media_elaborations);
        mediaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.news18.com/newstopics/pakistan-media.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        eventsView = findViewById(R.id.events_pak);
        eventsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.trtworld.com/asia/timeline-of-major-political-events-in-pakistan-19015");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        upcomingView = findViewById(R.id.upcoming_events);
        upcomingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.timeanddate.com/holidays/pakistan/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        educatorView = findViewById(R.id.educator);
        educatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://wenr.wes.org/2020/02/education-in-pakistan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        outlineView = findViewById(R.id.outlines);
        outlineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.unicef.org/pakistan/education");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ptbView = findViewById(R.id.ptb);
        ptbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.kitabain.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        alertsView = findViewById(R.id.alerts);
        alertsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://alertpakistan.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        badgesView = findViewById(R.id.badges);
        badgesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.ebay.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        historyView = findViewById(R.id.history);
        historyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://en.wikipedia.org/wiki/Pakistan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        libView = findViewById(R.id.library);
        libView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.pakistan.web.pk/portal/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        sectorView = findViewById(R.id.sectors);
        sectorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.researchsnipers.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
