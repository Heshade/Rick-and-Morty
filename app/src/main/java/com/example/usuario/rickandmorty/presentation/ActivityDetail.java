package com.example.usuario.rickandmorty.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.usuario.rickandmorty.domain.Character;

import com.example.usuario.rickandmorty.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Usuario on 29/06/2018.
 */
public class ActivityDetail extends AppCompatActivity {
    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Character itemDetailed;
    private ImageView imageExtended;
    private TextView name;
    private TextView id;
    private TextView status;
    private TextView species;
    private TextView gender;
    private TextView origin;
    private TextView lastLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        useToolbar();
        itemDetailed = Character.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        imageExtended = (ImageView) findViewById(R.id.image_extended);
        name = (TextView) findViewById(R.id.name);
        id = (TextView) findViewById(R.id.id);
        status = (TextView) findViewById(R.id.status);
        species = (TextView) findViewById(R.id.species);
        gender = (TextView) findViewById(R.id.gender);
        origin = (TextView) findViewById(R.id.origin);
        lastLoc = (TextView) findViewById(R.id.last_loc);
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


}
