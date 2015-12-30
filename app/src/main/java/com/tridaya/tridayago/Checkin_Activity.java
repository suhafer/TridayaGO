package com.tridaya.tridayago;

import android.Manifest;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Checkin_Activity extends AppCompatActivity {

    private static final int CA_MY_LOCATION_REQUEST_CODE = 1;
    private GoogleMap ca_Map;
    ScrollView scrollView;
    Geocoder ca_geocoder;
    List<Address> ca_addresses;

    TextView ca_Date, ca_Time, ca_ProfilName, ca_ProfilLocation,ca_Id;
    String clockTime,clockDate,clockPDate;
    Button ca_CheckIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin_);

        scrollView = (ScrollView) findViewById(R.id.scrollId);

        setActionBar();
        checkLocation();
        setUpMapIfNeeded();

        ca_Date = (TextView) findViewById(R.id.ca_date);
        ca_Time = (TextView) findViewById(R.id.ca_time);
        ca_ProfilName = (TextView) findViewById(R.id.ca_profilName);
        ca_Id = (TextView) findViewById(R.id.ca_profilId);
        ca_ProfilLocation = (TextView) findViewById(R.id.ca_profilLocation);
        ca_CheckIn = (Button) findViewById(R.id.ca_checkin);

        setData();
        setUpDate();
        setUpTime();

        ca_CheckIn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate();
                setUpTime();
                Intent i = new Intent(Checkin_Activity.this, HomeActivity.class);
                i.putExtra("clockTime", clockTime);
                i.putExtra("clockDate", clockPDate);
                startActivity(i);
                finish();
            }
        });

        ((CheckIn_MapControl) getSupportFragmentManager().findFragmentById(R.id.ca_map))
                .setListener(new CheckIn_MapControl.OnTouchListener() {
                    @Override
                    public void onTouch() {
                        scrollView.requestDisallowInterceptTouchEvent(true);
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkLocation();
        setUpMapIfNeeded();
        setUpDate();
        setUpTime();
    }

    private void setData () {
        ObjectTransfer a = new ObjectTransfer();
        String[] b = a.getDummyPerson();
        ca_ProfilName.setText(b[0]);
        ca_Id.setText("ID : "+b[1]);
    }

    private void setUpTime(){
        Date d=new Date();
        TimeIndo tI = new TimeIndo();

        SimpleDateFormat dCT=new SimpleDateFormat("kk:mm", Locale.getDefault());
        SimpleDateFormat dTZ=new SimpleDateFormat("zzzz", Locale.getDefault());

        String currentTimeZone = dTZ.format(d);
        String currentDateTimeString = dCT.format(d);

        currentTimeZone = tI.timeIndo(currentTimeZone);
        clockTime = currentDateTimeString + " " + currentTimeZone;
        ca_Time.setText(currentDateTimeString + " " + currentTimeZone);
    }

    private void setUpDate(){
        Date d = new Date();
        SimpleDateFormat dates = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault());
        String dateToday = dates.format(d);
        clockDate = dateToday;
        ca_Date.setText(dateToday);
        dates = new SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault());
        dateToday = dates.format(d);
        clockPDate = dateToday;
    }



    private void setUpMapIfNeeded() {
        if (ca_Map == null) {
            ca_Map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.ca_map))
                    .getMap();

            if (ca_Map != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            ca_Map.setMyLocationEnabled(true);
            ca_Map.getUiSettings().setZoomControlsEnabled(false);
            ca_Map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                @Override
                public void onMyLocationChange(Location arg0) {
                    //checkLocation();
                    ca_Map.clear();
                    ca_Map.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("Your Position"));
                    setLocation(arg0.getLatitude(), arg0.getLongitude());
                    ca_Map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            new LatLng(arg0.getLatitude(), arg0.getLongitude()), 13));

                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(arg0.getLatitude(), arg0.getLongitude()))
                            .zoom(13)
                            .build();
                    ca_Map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            });
        }
        else {
            // Show rationale and request permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    CA_MY_LOCATION_REQUEST_CODE);
        }

    }

    private void setLocation(double a, double b){
        ca_geocoder = new Geocoder(this, Locale.getDefault());
        try {
            ca_addresses = ca_geocoder.getFromLocation(a, b, 1);
            String address = ca_addresses.get(0).getAddressLine(0);
            String city = ca_addresses.get(0).getLocality();
            ca_ProfilLocation.setText(address + " " + city);
        } catch (IOException e) {
            e.printStackTrace();
            ca_ProfilLocation.setText("Unknown");
        }
    }

    public void checkLocation() {
        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }
        catch(Exception ex) {
            Log.d("Error", "gps error");
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }
        catch(Exception ex) {
            Log.d("Error", "network error");
        }

        if(!gps_enabled || !network_enabled) {
            // notify user
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(this.getResources().getString(R.string.notif1));
            dialog.setPositiveButton(this.getResources().getString(R.string.notifyes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // TODO Auto-generated method stub
                    Intent myIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                    //get gps
                }
            });
            dialog.setNegativeButton(this.getString(R.string.notifno), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // TODO Auto-generated method stub

                }
            });
            dialog.show();
        }
    }

    private void setActionBar () {
        ActionBar bar = getSupportActionBar();
        bar.setTitle(R.string.hello_world);
        bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bar));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //super.onCreateOptionsMenu(menu, getMenuInflater().inflate(R.menu.menu_checkin_, menu));
        getMenuInflater().inflate(R.menu.menu_checkin_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
