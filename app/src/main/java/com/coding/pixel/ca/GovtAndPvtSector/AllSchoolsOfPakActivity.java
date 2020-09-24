package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class AllSchoolsOfPakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_schools_of_pak);

        Toolbar schoolToolbar = findViewById(R.id.institute_school_bar);
        setSupportActionBar(schoolToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("School Institutes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WebView uniView = new WebView(this);
        uniView.getSettings().setJavaScriptEnabled(true);
        uniView.loadUrl("https://www.urdupoint.com/education/schools.html");
        setContentView(uniView);

    }
}