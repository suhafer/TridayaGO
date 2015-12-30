package com.tridaya.tridayago;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskReportActivity extends AppCompatActivity {

    static final int TDA_REQUEST_IMAGE_CAPTURE = 1;
    ArrayList<Bitmap> tda_reportPicture = new ArrayList<Bitmap>();

    String tda_ProfilName;
    int tda_Position;
    TextView tda_VProfilName, tda_VProfilID, tda_VprofilJob, tda_VCheckin, tda_VJob, tda_VJobDesc;
    ActionBar tda_ActionBar;
    GridView tda_GridView;
    Button tda_SendButton;
    TaskReportGridAdapter tda_gA;
    ObjectTransfer oT;
    int mark = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_report);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tda_ProfilName = extras.getString("item");
            tda_Position = extras.getInt("position");
            oT = (ObjectTransfer) extras.getSerializable("object");
            mark = extras.getInt("job");
        }

        setActionBar();

        tda_VProfilName = (TextView) findViewById(R.id.tda_Username);
        tda_VProfilID = (TextView) findViewById(R.id.tda_Id);
        tda_VprofilJob = (TextView) findViewById(R.id.tda_Role);
        tda_VCheckin = (TextView) findViewById(R.id.tda_Checkin);
        tda_VJob = (TextView) findViewById(R.id.tda_Job);
        tda_VJobDesc = (TextView) findViewById(R.id.tda_JobDesc);

        tda_GridView = (GridView) findViewById(R.id.tda_gv);
        tda_SendButton = (Button) findViewById(R.id.tda_send);

        setObject();
        setGripAdapter();
    }

    private void setActionBar () {
        tda_ActionBar = getSupportActionBar();
        tda_ActionBar.setDisplayHomeAsUpEnabled(true);
        tda_ActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#008000")));
        if (mark==3) {
            tda_ActionBar.setTitle("Special Task");
        }
        else {
            tda_ActionBar.setTitle("Daily Task");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_detail, menu);
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

    private void setObject () {
        String[] c = oT.getDummyPerson();
        tda_VProfilName.setText("Name : "+c[0]);
        tda_VProfilID.setText("ID : "+c[1]);
        tda_VprofilJob.setText("Duty : "+c[2]);
        tda_VCheckin.setText("Check In : "+oT.getCheckInDate()+"   "+oT.getCheckInClock());
        if (mark==3) {
            tda_VJob.setText("job type : Special Task");
        }
        else {
            tda_VJob.setText("job type : Daily Task");
        }
        tda_VJobDesc.setText(tda_ProfilName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TDA_REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            tda_reportPicture.add(imageBitmap);
            setGripAdapter();
            //tda_gA.onActivityResult(imageBitmap);
        }
    }

    public void setGripAdapter() {
        tda_gA = new TaskReportGridAdapter(this, tda_reportPicture);
        tda_GridView.setAdapter(tda_gA);
    }


}
