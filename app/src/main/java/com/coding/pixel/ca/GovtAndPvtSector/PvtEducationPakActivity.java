package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class PvtEducationPakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_education_pak);


        Toolbar pvtToolbar = findViewById(R.id.institute_pvt_bar);
        setSupportActionBar(pvtToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Private Institutes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView uniView = new WebView(this);
        uniView.getSettings().setJavaScriptEnabled(true);
        uniView.loadUrl("https://www.4icu.org/pk/private/");
        setContentView(uniView);
    }
}