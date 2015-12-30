package com.tridaya.tridayago;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFRSGA extends BaseAdapter {
    private Context rsga_Context;
    public Integer[] exImage = {R.drawable.contohimage_1, R.drawable.contohimage_2, R.drawable.contohimage_3};
    ArrayList<Bitmap> rsga_reportPicture;

    public RecyclerHolderHFRSGA(Context a, ArrayList<Bitmap> b) {
        rsga_Context = a;
        rsga_reportPicture = b;

    }

    public int getCount () {
        return exImage.length;
        //return rsga_reportPicture.size();
    }

    public Object getItem(int position) {
        //return exImage[position];
        return rsga_reportPicture.get(position);
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView image;
        if (convertView == null) {
            image = new ImageView(rsga_Context);
        } else {
            image = (ImageView) convertView;
        }

        image.setImageResource(exImage[position]);
        return image;
    }
}
