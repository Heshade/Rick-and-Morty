package com.example.usuario.rickandmorty.presentation;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.usuario.rickandmorty.R;
import com.example.usuario.rickandmorty.presentation.adapters.adaptadorElement;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.key;

public class ScrollingActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GridView gridView;
    private adaptadorElement adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new adaptadorElement(this);
        gridView.setAdapter(adaptador);

        /*
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://rickandmortyapi.com/api/");
                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) url.openConnection();
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject();
                        while(jsonReader.hasNext()) {
                            String name = jsonReader.nextName();
                            if (name.equals("characters")) {
                                readCharacters(jsonReader.nextString());
                            } else if (name.equals("locations")) {
                                readLocations(jsonReader.nextString());
                            } else if (name.equals("episodes")) {
                                readEpisodes(jsonReader.nextString());
                            }
                        }

                    } else {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER, , );
                        toast1.show();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void readEpisodes(String s) {
            }

            private void readLocations(String s) {
            }

            private void readCharacters(String s) throws IOException {
                String next = "primera";
                URL url = new URL("https://rickandmortyapi.com/api/character/");
                HttpsURLConnection myConnection =
                        (HttpsURLConnection) url.openConnection();
                if (myConnection.getResponseCode() == 200) {
                    InputStream responseBody = myConnection.getInputStream();
                    InputStreamReader responseBodyReader =
                            new InputStreamReader(responseBody, "UTF-8");
                    JsonReader jsonReader = new JsonReader(responseBodyReader);
                    jsonReader.beginObject();
                    while(jsonReader.hasNext()) {
                        String name = jsonReader.nextName();
                        if (name.equals("info")) {
                            readCharacters(jsonReader.nextString());
                        } else if (name.equals("locations")) {
                            readLocations(jsonReader.nextString());
                        } else if (name.equals("episodes")) {
                            readEpisodes(jsonReader.nextString());
                        }
                    }

                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER, , );
                    toast1.show();
                }

            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
