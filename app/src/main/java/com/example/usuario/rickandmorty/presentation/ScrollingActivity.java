package com.example.usuario.rickandmorty.presentation;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.usuario.rickandmorty.R;
import com.example.usuario.rickandmorty.domain.Character;
import com.example.usuario.rickandmorty.presentation.adapters.adaptadorElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class ScrollingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private GridView gridView;
    private adaptadorElement adaptador;
    public static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = (GridView) findViewById(R.id.grid);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int numberFavourites = settings.getInt("numFav", 0);
        if (Character.first) {
            for (int i = 0; i < numberFavourites; i++) {
                Character.favourites.add(settings.getInt(String.valueOf(i), 1));
            }
            for (int i = 1; i <= 25; ++i) {
                String newURL = "https://rickandmortyapi.com/api/character/?page=" + i;
                RequestQueue requestQueue2 = Volley.newRequestQueue(this);
                JsonObjectRequest objectRequest2 = new JsonObjectRequest(
                        Request.Method.GET,
                        newURL,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray json = response.getJSONArray("results");
                                    for (int i = 0; i < json.length(); i++) {
                                        JSONObject character = json.getJSONObject(i);
                                        String name = character.getString("name");
                                        String image = character.getString("image");
                                        int id = character.getInt("id");
                                        String species = character.getString("species");
                                        String gender = character.getString("gender");
                                        String status = character.getString("status");
                                        String type = character.getString("type");
                                        String url = character.getString("url");
                                        String created = character.getString("created");
                                        JSONObject location = character.getJSONObject("location");
                                        String loc = location.getString("name");
                                        JSONObject origin = character.getJSONObject("origin");
                                        String org = origin.getString("name");
                                        Character.allGenders gen;
                                        switch (gender) {
                                            case "Female":
                                                gen = Character.allGenders.Female;
                                                break;
                                            case "Male":
                                                gen = Character.allGenders.Male;
                                                break;
                                            case "Genderless":
                                                gen = Character.allGenders.Genderless;
                                                break;
                                            default:
                                                gen = Character.allGenders.unknown;
                                                break;
                                        }
                                        Character.allStatus stat;
                                        switch (status) {
                                            case "Alive":
                                                stat = Character.allStatus.Alive;
                                                break;
                                            case "Dead":
                                                stat = Character.allStatus.Dead;
                                                break;
                                            default:
                                                stat = Character.allStatus.unknown;
                                                break;
                                        }
                                        Character.ITEMS.add(new Character(id, name, gen, species, type, stat, org, loc, image, url, created));
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Character.ITEMS.add(new Character(3, "name", Character.allGenders.Female, "species", "type", Character.allStatus.Alive, "origin", "location", "https://rickandmortyapi.com/api/character/avatar/3.jpeg", "url", "created"));
                            }
                        }
                );
                requestQueue2.add(objectRequest2);
            }
            Character.first = false;
        }



        adaptador = new adaptadorElement(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reset_favourites) {
            Character.favourites.clear();
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("numFav",0);
            editor.apply();
            Intent intent = new Intent(this, ScrollingActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.putInt("numFav",Character.favourites.size());
        for (int i = 0; i < Character.favourites.size(); i++) {
            editor.putInt(String.valueOf(i), Character.favourites.get(i));
        }
        editor.apply();
        Character item = (Character) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, ActivityDetail.class);
        intent.putExtra(ActivityDetail.EXTRA_PARAM_ID, item.getId());
        startActivity(intent);
        finish();
    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        finish();

    }
    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("numFav",Character.favourites.size());
        for (int i = 0; i < Character.favourites.size(); i++) {
            editor.putInt(String.valueOf(i), Character.favourites.get(i));
        }
        editor.apply();
    }

}
