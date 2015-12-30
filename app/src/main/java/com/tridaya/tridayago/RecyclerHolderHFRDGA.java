package com.tridaya.tridayago;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFRDGA extends BaseAdapter {
    private Context tdga_Context;
    public Integer[] exImage = {R.drawable.contohimage_1, R.drawable.contohimage_2, R.drawable.contohimage_3};
    ArrayList<Bitmap> tdga_reportPicture;
    static final int TDA_REQUEST_IMAGE_CAPTURE = 1;
    private boolean tdga_ImgFull = false;

    public RecyclerHolderHFRDGA(Context a, ArrayList<Bitmap> b) {
        tdga_Context = a;
        tdga_reportPicture = b;

    }

    public int getCount () {
        return exImage.length;
        //return rsga_reportPicture.size();
    }

    public Object getItem(int position) {
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

        image.setImageResource(exImage[position]);
        return image;
    }
}
