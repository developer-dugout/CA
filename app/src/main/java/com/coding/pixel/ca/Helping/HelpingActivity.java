package com.coding.pixel.ca.Helping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.coding.pixel.ca.R;
import com.coding.pixel.ca.WebLinks.AppInfoActivity;
import com.coding.pixel.ca.WebLinks.WebContactUsActivity;
import com.coding.pixel.ca.WebLinks.WebFaqActivity;
import com.coding.pixel.ca.WebLinks.WebTermsConditionsActivity;

public class HelpingActivity extends AppCompatActivity {

    private CardView one, two, three, four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helping);

        Toolbar mToolbar = findViewById(R.id.help_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Help");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        one = findViewById(R.id.help_one);
        two = findViewById(R.id.help_two);
        three = findViewById(R.id.help_three);
        four = findViewById(R.id.help_four);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faqIntent = new Intent(HelpingActivity.this, WebFaqActivity.class);
                startActivity(faqIntent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactUsIntent = new Intent(HelpingActivity.this, WebContactUsActivity.class);
                startActivity(contactUsIntent);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent termsConditionsIntent = new Intent(HelpingActivity.this, WebTermsConditionsActivity.class);
                startActivity(termsConditionsIntent);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appInfoIntent = new Intent(HelpingActivity.this, AppInfoActivity.class);
                startActivity(appInfoIntent);
            }
        });
    }
}
