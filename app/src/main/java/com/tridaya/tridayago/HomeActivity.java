package com.tridaya.tridayago;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment haNavigationDrawerFragment;
    private DrawerLayout dL;

    private CharSequence haTitle;
    private int section = 0;
    private Toolbar myToolbar;
    private FragmentTabHost myTabHost;
    private ViewPager myPager;
    private LinearLayout myLinearLayout;
    ObjectTransfer homeItem;
    String clockTime,clockDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String a= extras.getString("clockTime");
            String b= extras.getString("clockDate");
            clockTime = a;
            clockDate = b;
        }

        myLinearLayout = (LinearLayout) findViewById(R.id.my_linearL);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbars);
        //myToolbar.setNavigationIcon(R.drawable.icon_navdrawer);
        setSupportActionBar(myToolbar);
        myTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        myTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        Bundle args = new Bundle();
        myTabHost.addTab(myTabHost.newTabSpec("tab1").setIndicator("Daily Task (10)"),
                TesFrag.class, args);
        myTabHost.addTab(myTabHost.newTabSpec("tab2").setIndicator("Special Task"),
                TesFrag.class, args);

        ha_SetBar();

        Log.e("TG", "MuatUlang");

        dL = (DrawerLayout) findViewById(R.id.drawer_layout);

        haNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        haTitle = getTitle();
        setObject();

        handleIntent(getIntent());
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        //getSupportActionBar().hide();
        switch (position) {
            case 0:
                // update the main content by replacing fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragmentTask.newInstance(position + 1))
                        .commit();
                break;
            case 1:
                // update the main content by replacing fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragmentReport.newInstance(position + 1))
                        .commit();
                break;
            case 2:
                // update the main content by replacing fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragmentNotif.newInstance(position + 1))
                        .commit();
                break;
            case 3:
                // update the main content by replacing fragments
                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragmentRequest.newInstance(position + 1))
                        .commit();
                break;
            default:
                break;
        }
    }

    public void onSectionAttached(int number) {
        //haTitle = getString(R.string.app_name);
        switch (number) {
            case 1:
                haTitle = getString(R.string.hello_world);
                section = 0;
                break;
            case 2:
                haTitle = getString(R.string.hello_world);
                section = 1;
                break;
            case 3:
                haTitle = getString(R.string.hello_world);
                section = 2;
                break;
            case 4:
                haTitle = getString(R.string.hello_world);
                section = 3;
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        //actionBar.setTitle(haTitle);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            // Set up the drawer.
            haNavigationDrawerFragment.setUp(
                    R.id.navigation_drawer, dL, homeItem, 2);

            String query = intent.getStringExtra(SearchManager.QUERY);
            this.homeItem.setSortItem(query);
            this.homeItem.setMark(1);
            this.haNavigationDrawerFragment.selectSpecial(2);
            Log.e("tes", "sampe");
            //use the query to search your data somehow
        }
        else {
            // Set up the drawer.
            haNavigationDrawerFragment.setUp(
                    R.id.navigation_drawer, dL, homeItem, 0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!haNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            if (section==2) {
                getMenuInflater().inflate(R.menu.menu_notif, menu);

                // Associate searchable configuration with the SearchView
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                searchView.setBackgroundColor(getResources().getColor(R.color.green));
            }
            else {
                getMenuInflater().inflate(R.menu.home, menu);
            }
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setObject () {
        homeItem = new ObjectTransfer();
        homeItem.setCheckInDate(clockDate);
        homeItem.setCheckInClock(clockTime);
    }

    public ObjectTransfer getObject() {
        return homeItem;
    }

    public void setMyToolbar (Toolbar a) {
        myToolbar = a;
    }

    public Toolbar getMyToolbar () {
        return this.myToolbar;
    }

    public void setMyTabHost (FragmentTabHost a) {
        myTabHost = a;
    }

    public FragmentTabHost getMyTabHost () {
        return this.myTabHost;
    }

    public void setMyPager (ViewPager a) {
        myPager = a;
    }

    public ViewPager getMyPager () {
        return myPager;
    }

    public void setMyLinearLayout (LinearLayout a) {
        myLinearLayout = a;
    }

    public LinearLayout getMyLinearLayout () {
        return this.myLinearLayout;
    }

    public void ha_SetBar() {
        for (int i = 0; i < myTabHost.getTabWidget().getChildCount(); i++) {
            //hfr_TabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#C0C0C0"));
            TextView tv = (TextView) myTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#808080"));
        }

        //hfr_TabHost.getTabWidget().getChildAt(hfr_TabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFF"));
        TextView tv = (TextView) myTabHost.getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#008000"));
    }
}
