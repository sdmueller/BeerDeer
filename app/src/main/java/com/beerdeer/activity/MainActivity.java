package com.beerdeer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.beerdeer.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_title);

        ImageView logo = (ImageView)getSupportActionBar().getCustomView().findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        //display the first navigation drawer view on app launch
        displayView(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        if(id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search beeeeeeer", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        System.out.println(position);
        switch(position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new MyBeersFragment();
                title = getString(R.string.title_mybeers);
                break;
            case 2:
                fragment = new EventsFragment();
                title = getString(R.string.title_events);
                break;
            case 3:
                fragment = new ShopsFragment();
                title = getString(R.string.title_shops);
                break;
            default:
                break;
        }

        if(fragment != null) {
            System.out.println("Fragment not null");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            if(position == 0) {
                //set logo instead of title for home fragment
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                getSupportActionBar().setDisplayUseLogoEnabled(false);

                // Remove text from title
                TextView titleView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.title);
                titleView.setText("");

                // Set logo
                ImageView logo = (ImageView)getSupportActionBar().getCustomView().findViewById(R.id.logo);
                logo.setImageResource(R.drawable.logo);
            } else {
                //set the toolbar title
                getSupportActionBar().setDisplayShowTitleEnabled(true);

                // Remove the logo from action bar
                ImageView logo = (ImageView)getSupportActionBar().getCustomView().findViewById(R.id.logo);
                logo.setImageResource(0);

                // Replace the logo with the title of the fragment
                TextView titleView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.title);
                titleView.setText(title);

                // would also work instead of disabling logo
                // getSupportActionBar().setLogo(android.R.color.transparent);
            }
        }
    }
}
