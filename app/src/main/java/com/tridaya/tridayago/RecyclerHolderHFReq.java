package com.tridaya.tridayago;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFReq extends RecyclerView.ViewHolder{

    private final TextView rhhfreq_VItemTitle;//, rhhfreq_VItemClock;
    private final ImageView rhhfreq_VItemImage;
    private String rhhfreq_ItemTitle, rhhfreq_ItemClock;
    private int rhhfreq_Position;
    private Context rhhfreq_Context;
    private ObjectTransfer ra_oT;

    public RecyclerHolderHFReq(final View parent) {
        super(parent);
        rhhfreq_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rhhfreq_VItemImage = (ImageView) parent.findViewById(R.id.itemPicture);
        //rhhfreq_VItemClock = (TextView) parent.findViewById(R.id.itemNotes);
        rhhfreq_Context = parent.getContext();
        /*
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rhhfreq_Context, TaskReportActivity.class);
                detailItem.putExtra("item", rhhfreq_ItemTitle);
                rhhfreq_Context.startActivity(detailItem);
            }
        });*/
    }

    public static RecyclerHolderHFReq newInstance(View parent) {
        return new RecyclerHolderHFReq(parent);
    }

    public void setItemText(CharSequence a) {
        rhhfreq_ItemTitle = (String) a;
        //rhhfreq_ItemClock = (String) b;
        rhhfreq_VItemTitle.setText(rhhfreq_ItemTitle);
        int source = ra_oT.getExImageRequest(rhhfreq_Position);
        rhhfreq_VItemImage.setImageResource(source);
        //rhhfreq_VItemClock.setText(rhhfreq_ItemClock);
    }

    public void setRa_oT (ObjectTransfer a) {
        ra_oT = a;
    }

    public void setPosition(int a) {
        rhhfreq_Position = a;
    }

}
