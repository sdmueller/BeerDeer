package com.beerdeer.activity;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beerdeer.R;

/**
 * Created by tim on 13.12.15.
 */
public class BeerFragment extends Fragment {

    public BeerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beer, container, false);
        ImageView beerImg = (ImageView)rootView.findViewById(R.id.beer_img);
        beerImg.setImageResource(savedInstanceState.getInt("beer_img"));
        TextView beerName = (TextView)rootView.findViewById(R.id.beer_name);
        beerName.setText(savedInstanceState.getString("beer_name"));

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
