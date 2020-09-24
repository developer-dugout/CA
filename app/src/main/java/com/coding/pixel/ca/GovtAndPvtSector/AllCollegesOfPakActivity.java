package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class AllCollegesOfPakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_colleges_of_pak);

        Toolbar collegeToolbar = findViewById(R.id.institute_clg_bar);
        setSupportActionBar(collegeToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("College Institutes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView uniView = new WebView(this);
        uniView.getSettings().setJavaScriptEnabled(true);
        uniView.loadUrl("https://en.wikipedia.org/wiki/List_of_colleges_in_Pakistan#Public_sector");
        setContentView(uniView);
    }
}