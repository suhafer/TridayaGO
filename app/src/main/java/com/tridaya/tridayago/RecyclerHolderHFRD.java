package com.tridaya.tridayago;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFRD extends RecyclerView.ViewHolder{

    private final TextView rhhfrd_VItemTitle, rhhfrd_VItemClock;
    private String rhhfrd_ItemTitle, rhhfrd_ItemClock;
    private int rhhfrd_Position;
    private Context rhhfrd_Context;
    private ObjectTransfer ra_oT;

    GridView rhhfrd_GridView;
    RecyclerHolderHFRDGA rhhfrd_gA;
    ArrayList<Bitmap> rhhfrd_reportPicture = new ArrayList<Bitmap>();

    public RecyclerHolderHFRD(final View parent) {
        super(parent);
        rhhfrd_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rhhfrd_VItemClock = (TextView) parent.findViewById(R.id.itemClock);
        rhhfrd_GridView = (GridView) parent.findViewById(R.id.itemhfrd_gv);
        rhhfrd_Context = parent.getContext();
        setGripAdapter();
        /*
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rhhfrd_Context, TaskReportActivity.class);
                detailItem.putExtra("item", rhhfrd_ItemTitle);
                rhhfrd_Context.startActivity(detailItem);
            }
        });*/
    }

    public static RecyclerHolderHFRD newInstance(View parent) {
        return new RecyclerHolderHFRD(parent);
    }

    public void setItemText(CharSequence a,CharSequence b) {
        rhhfrd_ItemTitle = (String) a;
        rhhfrd_ItemClock = (String) b;
        rhhfrd_VItemTitle.setText(rhhfrd_ItemTitle);
        rhhfrd_VItemClock.setText(rhhfrd_ItemClock);
    }

    public void setPosition(int a) {
        rhhfrd_Position = a;
    }

    public void setRa_oT (ObjectTransfer a) {
        ra_oT = a;
    }

    public void setGripAdapter() {
        rhhfrd_gA = new RecyclerHolderHFRDGA(rhhfrd_Context, rhhfrd_reportPicture);
        rhhfrd_GridView.setAdapter(rhhfrd_gA);
    }
}
