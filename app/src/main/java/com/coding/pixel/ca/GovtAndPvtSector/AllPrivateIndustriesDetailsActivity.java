package com.coding.pixel.ca.GovtAndPvtSector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.coding.pixel.ca.R;

import java.util.Objects;

public class AllPrivateIndustriesDetailsActivity extends AppCompatActivity {

    private WebView indusWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_private_industies_details);

        Toolbar indusToolbar = findViewById(R.id.indus_bar);
        setSupportActionBar(indusToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("UpComing Industries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*indusWeb = findViewById(R.id.indus_web);
        indusWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.businessnewsdaily.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
*/
        WebView indusView = new WebView(this);
        indusView.getSettings().setJavaScriptEnabled(true);
        indusView.loadUrl("https://www.businessnewsdaily.com/");
        setContentView(indusView);

    }
}