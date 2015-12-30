package com.tridaya.tridayago;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 20/11/2015.
 */
public class TaskReportGridAdapter extends BaseAdapter {
    private Context tdga_Context;
    //public Integer[] exImage = {R.drawable.splash, R.drawable.splash, R.drawable.splash};
    ArrayList<Bitmap> tdga_reportPicture;
    static final int TDA_REQUEST_IMAGE_CAPTURE = 1;
    private boolean tdga_ImgFull = false;
    private int MAX_HEIGHT = 250;
    private int MAX_WIDTH = 250;

    public TaskReportGridAdapter(Context a, ArrayList<Bitmap> b) {
        tdga_Context = a;
        tdga_reportPicture = b;

        if (tdga_reportPicture.size()==3) {
            tdga_ImgFull = true;
        }
        else {
            Bitmap plus = BitmapFactory.decodeResource(tdga_Context.getResources(),
                    R.drawable.captureimage);
            tdga_reportPicture.add(plus);
        }

    }

    public int getCount () {
        //return exImage.length;
        return tdga_reportPicture.size();
    }

    public Bitmap getItem(int position) {
        //return exImage[position];
        return tdga_reportPicture.get(position);
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView image;
        if (convertView == null) {
            image = new ImageView(tdga_Context);
        } else {
            image = (ImageView) convertView;
        }

        //image.setLayoutParams(new ViewGroup.LayoutParams(120 , 120 ));
        if (getCount()==1) {
            //image.setImageBitmap(getItem(position));
            image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchTakePictureIntent();
                    tdga_reportPicture.remove(position);
                }
            });
        }
        else if (getCount() == 2) {
            //image.setImageBitmap(getItem(position));
            if (position==1) {
                image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dispatchTakePictureIntent();
                        tdga_reportPicture.remove(position);
                    }
                });
            }
            else {
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
            }
        }
        else if (getCount()==3) {
            if (!tdga_ImgFull) {
                //image.setImageBitmap(getItem(position));
                if (position==2) {
                    image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dispatchTakePictureIntent();
                            tdga_reportPicture.remove(position);
                        }
                    });
                }
                else {
                    image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
                }
            }
            else {
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
            }
        }
        else {
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setImageBitmap(Bitmap.createScaledBitmap(getItem(position), MAX_WIDTH, MAX_HEIGHT, false));
        }
        //image.setImageResource(exImage[position]);
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(tdga_Context.getPackageManager()) != null) {
            ((Activity)tdga_Context).startActivityForResult(takePictureIntent, TDA_REQUEST_IMAGE_CAPTURE);
        }
    }

    /*
    public void onActivityResult(Bitmap a) {

    }*/
}
