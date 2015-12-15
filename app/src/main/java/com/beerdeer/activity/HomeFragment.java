package com.beerdeer.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beerdeer.R;

public class HomeFragment extends Fragment {

    private int beerOfTheDayImageId = R.drawable.kingfisher;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final ImageView beerImg = (ImageView)rootView.findViewById(R.id.beer_img);

        beerImg.setImageResource(beerOfTheDayImageId);

        beerImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment singleBeer = new BeerFragment();
                Bundle bundle = new Bundle();
                TextView beerName = (TextView)rootView.findViewById(R.id.beer_name);
                String name = beerName.getText().toString();

                bundle.putInt("beer_img", beerOfTheDayImageId);
                bundle.putString("beer_name", name);

                singleBeer.setArguments(bundle);

                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container_body, singleBeer);
                ft.addToBackStack(null);

                // Commit the transaction
                ft.commit();
            }
        });

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