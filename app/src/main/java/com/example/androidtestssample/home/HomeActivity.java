package com.example.androidtestssample.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtestssample.R;
import com.example.androidtestssample.profile.ProfileActivity;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.home_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new HomeRecyclerAdapter(getCountryNames());
        recyclerView.setAdapter(mAdapter);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);

        // To display icon on overflow menu
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user_details:
                // Red item was selected
                navigateToProfilePage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void navigateToProfilePage() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private String[] getCountryNames() {

        String[] countries = new String[]{
                "India"
                , "Bangladesh", "Srilanka"
                , "Nepal", "Bhutan"
                , "Japan", "Singapore"
                , "Indonesia", "France"
                , "Spain", "Italy"
                , "Germany", "Switzerland"
                , "Mexico", "Canada"
                , "Australia", "New zealand"
                , "Pakistan", "Russia"
                , "Brazil", "Myanmar"
                , "Sweden", "Corotia"
                , "Alaska", "Norway"
                , "USA", "Afghanistan"
                , "Nigeria", "Prague"};
        return countries;
    }
}
