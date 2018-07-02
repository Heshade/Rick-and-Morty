package com.example.usuario.rickandmorty.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.rickandmorty.R;
import com.example.usuario.rickandmorty.domain.Character;
import com.example.usuario.rickandmorty.presentation.ScrollingActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Usuario on 29/06/2018.
 */

public class adaptadorElement extends BaseAdapter{
    private Context context;

    public adaptadorElement(ScrollingActivity scrollingActivity) {
        context = scrollingActivity.getApplicationContext();
    }

    @Override
    public int getCount() {
        return Character.ITEMS.size();
    }

    @Override
    public Character getItem(int position) {
        return Character.ITEMS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ImageView imageCharacter = (ImageView) view.findViewById(R.id.imagen_coche);
        ImageView favourite = (ImageView) view.findViewById(R.id.favourite);
        TextView nameCharacter = (TextView) view.findViewById(R.id.nombre_coche);
        final Character item = getItem(position);
        Picasso.with(view.getContext()).load(item.getImage()).into(imageCharacter);
        if (Character.favourites.contains(item.getId())) favourite.setImageResource(R.mipmap.favourite);
        else favourite.setImageResource(R.mipmap.favourite_non_selected);
        nameCharacter.setText(item.getName());
        return view;
    }
}
