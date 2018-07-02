package com.example.usuario.rickandmorty.presentation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.usuario.rickandmorty.domain.Character;

import com.example.usuario.rickandmorty.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Usuario on 29/06/2018.
 */
public class ActivityDetail extends AppCompatActivity {
    public static final String EXTRA_PARAM_ID = "extra.ID";
    private Character itemDetailed;
    private ImageView imageExtended;
    private ImageView favourite;
    private TextView name;
    private TextView id;
    private TextView status;
    private TextView species;
    private TextView gender;
    private TextView origin;
    private TextView lastLoc;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        useToolbar();
        itemDetailed = Character.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
        favourite = (ImageView) findViewById(R.id.favourite_detail);
        imageExtended = (ImageView) findViewById(R.id.image_extended);
        name = (TextView) findViewById(R.id.name);
        id = (TextView) findViewById(R.id.id);
        status = (TextView) findViewById(R.id.status);
        species = (TextView) findViewById(R.id.species);
        gender = (TextView) findViewById(R.id.gender);
        origin = (TextView) findViewById(R.id.origin);
        lastLoc = (TextView) findViewById(R.id.last_loc);
        if (Character.favourites.contains(itemDetailed.getId())) favourite.setImageResource(R.mipmap.favourite);
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.favourites.contains(itemDetailed.getId())) {
                    if (Character.favourites.indexOf(itemDetailed.getId()) != -1) Character.favourites.remove(Character.favourites.indexOf(itemDetailed.getId()));
                    favourite.setImageResource(R.mipmap.favourite_non_selected);
                } else {
                    favourite.setImageResource(R.mipmap.favourite);
                    Character.favourites.add(itemDetailed.getId());
                }
            }
        });
        chargeData();
        chargeExtendedImage();
    }

    private void chargeExtendedImage() {
        Picasso.with(imageExtended.getContext()).load(itemDetailed.getImage()).into(imageExtended);
    }
    private void chargeData() {
        name.setText(itemDetailed.getName());
        id.setText(String.valueOf(itemDetailed.getId()));
        status.setText(itemDetailed.getStatusString());
        species.setText(itemDetailed.getSpecies());
        gender.setText(itemDetailed.getGenderString());
        origin.setText(itemDetailed.getOrigin());
        lastLoc.setText(itemDetailed.getLocation());
    }

    private void useToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ScrollingActivity.class);
        startActivity(intent);
        finish();
    }




}
