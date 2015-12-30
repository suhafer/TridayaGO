package com.tridaya.tridayago;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFRS extends RecyclerView.ViewHolder{

    private final TextView rhhfrs_VItemTitle, rhhfrs_VItemClock;
    private String rhhfrs_ItemTitle, rhhfrs_ItemClock;
    private int rhhfrs_Position;
    private Context rhhfrs_Context;
    private ObjectTransfer ra_oT;

    GridView rhhfrs_GridView;
    RecyclerHolderHFRSGA rhhfrs_gA;
    ArrayList<Bitmap> rhhfrs_reportPicture = new ArrayList<Bitmap>();

    public RecyclerHolderHFRS(final View parent) {
        super(parent);
        rhhfrs_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rhhfrs_VItemClock = (TextView) parent.findViewById(R.id.itemClock);
        rhhfrs_GridView = (GridView) parent.findViewById(R.id.itemhfrd_gv);
        rhhfrs_Context = parent.getContext();
        setGripAdapter();
        /*
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rhhfrs_Context, TaskReportActivity.class);
                detailItem.putExtra("item", rhhfrs_ItemTitle);
                rhhfrs_Context.startActivity(detailItem);
            }
        });*/
    }

    public static RecyclerHolderHFRS newInstance(View parent) {
        return new RecyclerHolderHFRS(parent);
    }

    public void setItemText(CharSequence a,CharSequence b) {
        rhhfrs_ItemTitle = (String) a;
        rhhfrs_ItemClock = (String) b;
        rhhfrs_VItemTitle.setText(rhhfrs_ItemTitle);
        rhhfrs_VItemClock.setText(rhhfrs_ItemClock);
    }

    public void setPosition(int a) {
        rhhfrs_Position = a;
    }

    public void setRa_oT (ObjectTransfer a) {
        ra_oT = a;
    }

    public void setGripAdapter() {
        rhhfrs_gA = new RecyclerHolderHFRSGA(rhhfrs_Context, rhhfrs_reportPicture);
        rhhfrs_GridView.setAdapter(rhhfrs_gA);
    }
}
