package com.example.assignment4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        if (getIntent().getExtras() != null &&
                getIntent().getExtras().getParcelable("COUNTRY_DETAILS") != null) {
            Country details = getIntent().getExtras().getParcelable("COUNTRY_DETAILS");
            setUpToolbar(details);
            setDataToViews(details);
        }
    }

    private void setUpToolbar(Country details) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(details.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setDataToViews(Country details) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        ((TextView) findViewById(R.id.tv_area)).setText(String.format("Total area: %s",
                formatter.format(details.getArea())));
        ((TextView) findViewById(R.id.tv_population)).setText(String.format("Total population: %s",
                formatter.format(details.getPopulation())));
        ((TextView) findViewById(R.id.tv_capital)).setText(String.format("Capital City: %s",
                details.getCapitalCity()));
    }
}