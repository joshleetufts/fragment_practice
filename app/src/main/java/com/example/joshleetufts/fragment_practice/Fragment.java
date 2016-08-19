package com.example.joshleetufts.fragment_practice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ActionBar supportActionBar;
    private Activity curr_activity;

    private final Fragment self = this;

    private View mHomeIcon = null;
    private DrawerLayout mDrawer = null;
    private NavigationView nvDrawer = null;
    private ImageButton settingCancel = null;
    public Toolbar toolbar = null;

    Typeface custom_font = null;
    Typeface regular_font = null;
    Typeface medium_font = null;
    Typeface bold_font = null;

//     private InterProcessCommunicator.Client client = null;

    private ActionBarDrawerToggle drawerToggle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //     GoogleAnalyticsUtil.setScreenName(this, getString(R.string.screen_name_activity_setting));
        setContentView(R.layout.activity_fragment);

        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        settingCancel = (ImageButton) findViewById(R.id.setting_cancel);
        mHomeIcon = findViewById(R.id.ll_toolbar_home);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, mDrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {

            }


            /* Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {

                settingCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mDrawer != null) {
                            mDrawer.closeDrawers();
                        }
                    }
                });
            }
        };

        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_setting:
                if(checked) {
                    System.out.print("setting worked");
                } else {
                    System.out.print("setting didn't work");
                }
            case R.id.checkbox_alarm:
                if(checked) {
                    System.out.print("alarm worked");
                } else {
                    System.out.print("alarm didn't work");
                }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
              getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer
        int id = item.getItemId();
        if (id == R.id.menuLeft) {
            if(mDrawer.isDrawerOpen(Gravity.LEFT)) {
                mDrawer.closeDrawer(Gravity.LEFT);
            } else {
                mDrawer.openDrawer(Gravity.LEFT);
            }
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.cancel) {
            mDrawer.closeDrawer(nvDrawer);
        }
        mDrawer.closeDrawer(nvDrawer);
        return true;
    }

    // 'onPostCreate' called when activity start-up is complete after 'onStart()'
    // NOTE! Make sure to override the method with only a single 'Bundle' argument
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}
