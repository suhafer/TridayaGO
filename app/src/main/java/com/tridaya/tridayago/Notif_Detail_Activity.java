package com.tridaya.tridayago;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notif_Detail_Activity extends AppCompatActivity {


    ActionBar nda_ActionBar;
    String nda_SenderName, nda_SenderClock, nda_SenderNotes;
    TextView nda_VSenderName, nda_VSenderClock, nda_VSenderNotes;
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif__detail_);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nda_SenderName = extras.getString("item");
            nda_SenderClock = extras.getString("clock");
            nda_SenderNotes = extras.getString("notes");
        }

        setActionBar();

        nda_VSenderName = (TextView) findViewById(R.id.senderName);
        nda_VSenderClock = (TextView) findViewById(R.id.senderClock);
        nda_VSenderNotes = (TextView) findViewById(R.id.senderMessage);

        nda_VSenderName.setText(nda_SenderName);
        nda_VSenderClock.setText(nda_SenderClock);
        nda_VSenderNotes.setText(nda_SenderNotes);

    }

    private void setActionBar () {
        nda_ActionBar = getSupportActionBar();
        nda_ActionBar.setDisplayHomeAsUpEnabled(true);
        nda_ActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#008000")));
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notif__detail_, menu);
        return true;
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
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
