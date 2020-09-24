package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.VideoView;

import com.coding.pixel.ca.R;
import java.util.Objects;

public class Educational_institutes_info extends AppCompatActivity {

    private VideoView govtVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_institutes_info);

        Toolbar instituteToolbar = findViewById(R.id.institute_bar);
        setSupportActionBar(instituteToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("University Institutes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView uniView = new WebView(this);
        uniView.getSettings().setJavaScriptEnabled(true);
        uniView.loadUrl("https://pkadmissions.com/list-of-all-universities-in-Pakistan#:~:text=%28CUSIT%29%20City%20University%20of%20Science%20and%20Information%20Technology,%28NCBA%26E%29%20National%20College%20of%20Business%20Administration%20and%20Economics");
        setContentView(uniView);


    }
}