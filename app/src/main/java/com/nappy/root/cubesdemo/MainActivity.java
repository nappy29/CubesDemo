package com.nappy.root.cubesdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;

    private List<Transaction> listitems = new ArrayList<Transaction>();
    private LinearLayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rv = (RecyclerView) findViewById(R.id.rv);

        // Item Decorator:
        rv.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider)));
//        rv.setItemAnimator(new FadeInLeftAnimator());

        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(lm);

        mAdapter = new MyAdapter(MainActivity.this, listitems);
        ((MyAdapter) mAdapter).setMode(Attributes.Mode.Single);
        rv.setAdapter(mAdapter);
    }

    private void populateList() {
            Transaction tr = new Transaction("$300", "request", "Request from mike","pending","mike","piza delivery", "Tz02sa");
            Transaction tr1 = new Transaction("$460", "send", "Send to bond","completed","Isreal","Bills payment", "a102sa");
            Transaction tr2 = new Transaction("$43", "send", "Send to bond","completed","Isreal","Bills payment", "a102sa");
            Transaction tr3 = new Transaction("$120", "request", "Request from duke","pending","Dubai market","Sipping fee", "jao9aj");
            Transaction tr4 = new Transaction("$230", "send", "Send to bond","completed","Isreal","Bills payment", "a102sa");
            Transaction tr5 = new Transaction("$630", "request", "Request from larry","pending","larry","wage payment", "a102sa");
            Transaction tr6 = new Transaction("$460", "request", "Request from bond","pending","Bond","Bills payment", "a102sa");
            Transaction tr7 = new Transaction("$460", "request", "Request from dstv","pending","Dstv","Bills payment", "a102sa");
            Transaction tr8 = new Transaction("$460", "request", "Request from google","pending","Google","wage payment", "a102sa");
            Transaction tr9 = new Transaction("$460", "request", "Request from Mary","pending","Mary","Bills payment", "a102sa");
            Transaction tr10 = new Transaction("$460", "send", "Send to bond","completed","Isreal","Bills payment", "a102sa");
            Transaction tr11 = new Transaction("$460", "request", "Request from nappy","Pending","Isreal","Bills payment", "a102sa");
            Transaction tr12 = new Transaction("$460", "send", "Send to bond","completed","Isreal","Bills payment", "a102sa");
            Transaction tr13 = new Transaction("$460", "request", "Request from bond","pending","Isreal","Bills payment", "a102sa");

        listitems.add(tr);
        listitems.add(tr1);
        listitems.add(tr2);
        listitems.add(tr3);
        listitems.add(tr4);
        listitems.add(tr5);
        listitems.add(tr6);
        listitems.add(tr7);
        listitems.add(tr8);
        listitems.add(tr9);
        listitems.add(tr10);
        listitems.add(tr11);
        listitems.add(tr12);
        listitems.add(tr13);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
