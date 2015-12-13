package com.beerdeer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beerdeer.R;
import com.beerdeer.adapter.BeerRowAdapter;
import com.beerdeer.model.BeerRowItem;

import java.util.ArrayList;
import java.util.List;

public class MyBeersFragment extends Fragment {

    public MyBeersFragment() {
        // Required empty public constructor
    }

    public static List<BeerRowItem> getData() {
        List<BeerRowItem> data = new ArrayList<>();

        BeerRowItem pilsnerUrquell = new BeerRowItem("Pilsner Urquell", R.drawable.pilsnerurquell);
        BeerRowItem budweiserDark = new BeerRowItem(("Budweiser Dark"), R.drawable.budweiserdark);
        BeerRowItem duvel = new BeerRowItem("Duvel", R.drawable.duvel);

        data.add(pilsnerUrquell);
        data.add(budweiserDark);
        data.add(duvel);

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_beers, container, false);

        RecyclerView beerList = (RecyclerView)rootView.findViewById(R.id.beer_list);
        BeerRowAdapter adapter = new BeerRowAdapter(getActivity(), getData());
        beerList.setAdapter(adapter);
        beerList.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
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