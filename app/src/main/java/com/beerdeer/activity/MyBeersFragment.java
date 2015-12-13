package com.beerdeer.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beerdeer.R;
import com.beerdeer.adapter.BeerRowAdapter;
import com.beerdeer.model.BeerRowItem;
import com.beerdeer.support.ItemClickSupport;

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


        ItemClickSupport.addTo(beerList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
                Context context = getActivity();
                Fragment singleBeer = new BeerFragment();
                Bundle bundle = new Bundle();

                switch(position){
                    case 0:
                        bundle.putInt("beer_img", R.drawable.pilsnerurquell);
                        bundle.putString("beer_name", "Pilsner Urquell");
                        break;
                    case 1:
                        bundle.putInt("beer_img", R.drawable.budweiserdark);
                        bundle.putString("beer_name", "Budweiser Dark");
                        break;
                    case 2:
                        bundle.putInt("beer_img", R.drawable.duvel);
                        bundle.putString("beer_name", "Duvel");
                        break;
                    default:
                        break;
                }

                singleBeer.setArguments(bundle);

                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container_body, singleBeer);
                ft.addToBackStack(null);

                // Commit the transaction
                ft.commit();


            }
        });

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