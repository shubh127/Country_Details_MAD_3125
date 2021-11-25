package com.example.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<String> countryNames = new ArrayList<>();
    List<Country> countriesList = new ArrayList<>();

    private Spinner spCountries;
    private ImageView ivFlag;
    private ImageView ivSymbol;
    private Button btnSeeMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();
        initViews();
        configViews();
    }

    private void populateData() {
        countriesList.add(new Country("China", R.drawable.flag_china,
                R.drawable.symbol_china, 9706961, 1433783686, "Beijing"));
        countriesList.add(new Country("India", R.drawable.flag_india,
                R.drawable.symbol_india, 3287590, 1366417754,
                "New Delhi"));
        countriesList.add(new Country("United States", R.drawable.flag_us,
                R.drawable.symbol_us, 9372610, 329064917,
                "Washington, D.C."));
        countriesList.add(new Country("Indonesia", R.drawable.flag_indonesia,
                R.drawable.symbol_indonesia, 1904569, 270625568,
                "Jakarta"));
        countriesList.add(new Country("Pakistan", R.drawable.flag_pak,
                R.drawable.symbol_pak, 881912, 216565318, "Islamabad"));
        countriesList.add(new Country("Brazil", R.drawable.flag_brazil,
                R.drawable.symbol_brazil, 8515767, 211049527, "Brasília"));
        countriesList.add(new Country("Nigeria", R.drawable.flag_nigeria,
                R.drawable.symbol_nigeria, 923768, 200963599, "Abuja"));
        countriesList.add(new Country("Mexico", R.drawable.flag_mex,
                R.drawable.symbol_mex, 1964375, 127575529, "Mexico City"));
        countriesList.add(new Country("Russia", R.drawable.flag_russia,
                R.drawable.symbol_russia, 17098242, 145872256, "Moscow"));
        countriesList.add(new Country("Canada", R.drawable.flag_canada,
                R.drawable.symbol_canada, 9984670, 37411047, "Ottawa"));

        for (Country country : countriesList) {
            countryNames.add(country.getName());
        }
    }

    private void initViews() {
        spCountries = findViewById(R.id.sp_countries);
        ivFlag = findViewById(R.id.iv_flag);
        ivSymbol = findViewById(R.id.iv_symbol);
        btnSeeMore = findViewById(R.id.btn_see_more);
    }

    private void configViews() {
        spCountries.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countryNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountries.setAdapter(aa);

        ivFlag.setImageDrawable(ContextCompat.getDrawable(this,
                countriesList.get(0).getFlagImgId()));
        ivSymbol.setImageDrawable(ContextCompat.getDrawable(this,
                countriesList.get(0).getSymbolImgId()));

        btnSeeMore.setOnClickListener(view -> navigateToDetailsPage());
    }

    private void navigateToDetailsPage() {
        Intent detailsActivity = new Intent(this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("COUNTRY_DETAILS",
                countriesList.get(spCountries.getSelectedItemPosition()));
        detailsActivity.putExtras(bundle);
        startActivity(detailsActivity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ivFlag.setImageDrawable(ContextCompat.getDrawable(this,
                countriesList.get(i).getFlagImgId()));
        ivSymbol.setImageDrawable(ContextCompat.getDrawable(this,
                countriesList.get(i).getSymbolImgId()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //no op
    }
}