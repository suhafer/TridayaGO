package com.tridaya.tridayago;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

public class DetailTaskActivity extends AppCompatActivity {

    private static final int DTA_NUM_PAGES = 3;
    ViewPager dta_Pager;

    PagerAdapter dta_PagerAdapter;
    ActionBar dta_ActionBar;
    String dta_ProfilName;
    int dta_Position;
    TextView dta_VTaskClientName, dta_VTaskClientId, dta_VTaskCategory, dta_VTaskTitle,dta_VTaskClock,dta_VTaskNotes;
    Button report;
    ObjectTransfer oT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dta_ProfilName = extras.getString("item");
            dta_Position = extras.getInt("position");
            oT = (ObjectTransfer) extras.getSerializable("object");
        }

        setActionBar();

        dta_Pager =(ViewPager) findViewById(R.id.pager);
        dta_VTaskClientName = (TextView) findViewById(R.id.tda_Clientname);
        dta_VTaskClientId = (TextView) findViewById(R.id.tda_ClientId);
        dta_VTaskCategory = (TextView) findViewById(R.id.tda_Category);
        dta_VTaskTitle = (TextView) findViewById(R.id.taskTitle);
        dta_VTaskClock = (TextView) findViewById(R.id.taskClock);
        dta_VTaskNotes = (TextView) findViewById(R.id.taskNotes);

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        report = (Button) findViewById(R.id.taskButton);

        dta_PagerAdapter = new DTA_ScreenSlidePagerAdapter(getSupportFragmentManager());
        dta_Pager.setAdapter(dta_PagerAdapter);
        setObject();

        indicator.setViewPager(dta_Pager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void nextActivity() {
        Intent detailItem = new Intent(this, TaskReportActivity.class);
        detailItem.putExtra("item", dta_ProfilName);
        detailItem.putExtra("position", dta_Position);
        detailItem.putExtra("object", oT);
        detailItem.putExtra("job", 3);
        startActivity(detailItem);
    }

    private class DTA_ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public DTA_ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new FragmentImage();
            }
            else if (position==1) {
                return new FragmentImage();
            }
            else {
                return new FragmentImage();
            }
        }

        @Override
        public int getCount() {
            return DTA_NUM_PAGES;
        }
    }

    private void setActionBar () {
        dta_ActionBar = getSupportActionBar();
        dta_ActionBar.setDisplayHomeAsUpEnabled(true);
        dta_ActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#008000")));
    }

    private void setObject () {
        List<String> b = oT.getListClockTaskD();
        List<String> c = oT.getListCategoryTaskD();
        String a = oT.getDetailTaskNotes();
        String[] d = oT.getDummyPerson();
        dta_VTaskClientName.setText("Client : "+d[0]);
        dta_VTaskClientId.setText("ID : "+d[1]);
        dta_VTaskCategory.setText("Category : "+c.get(dta_Position));
        dta_VTaskTitle.setText(dta_ProfilName);
        dta_VTaskClock.setText(b.get(dta_Position));
        dta_VTaskNotes.setText(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
