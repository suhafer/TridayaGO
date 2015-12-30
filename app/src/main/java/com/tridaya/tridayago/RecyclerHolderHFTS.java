package com.tridaya.tridayago;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Suhafer on 25/11/2015.
 */
public class RecyclerHolderHFTS extends RecyclerView.ViewHolder{

    private final TextView rhhfts_VItemTitle, rhhfts_VItemClock;
    private String rhhfts_ItemTitle, rhhfts_ItemClock;
    private int rhhfts_Position;
    private Context rhhfts_Context;
    private ImageView rhhfts_checkList;
    private ObjectTransfer oT;

    public RecyclerHolderHFTS(final View parent) {
        super(parent);
        rhhfts_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rhhfts_VItemClock = (TextView) parent.findViewById(R.id.itemClock);
        rhhfts_checkList = (ImageView) parent.findViewById(R.id.itemCheck);
        rhhfts_Context = parent.getContext();
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rhhfts_Context, DetailTaskActivity.class);
                detailItem.putExtra("item", rhhfts_ItemTitle);
                detailItem.putExtra("position", rhhfts_Position);
                detailItem.putExtra("object", oT);
                rhhfts_Context.startActivity(detailItem);
            }
        });
    }

    public static RecyclerHolderHFTS newInstance(View parent) {
        return new RecyclerHolderHFTS(parent);
    }

    public void setItemText(CharSequence a,CharSequence b) {
        rhhfts_ItemTitle = (String) a;
        rhhfts_ItemClock = (String) b;
        rhhfts_VItemTitle.setText(rhhfts_ItemTitle);
        rhhfts_VItemClock.setText(rhhfts_ItemClock);
        if (rhhfts_ItemClock.equalsIgnoreCase("Not yet")) {
            rhhfts_checkList.setVisibility(View.INVISIBLE);
            rhhfts_VItemTitle.setTextColor(Color.parseColor("#008000"));
        }
        else {
            rhhfts_VItemTitle.setTextColor(Color.parseColor("#C0C0C0"));
            rhhfts_checkList.setVisibility(View.VISIBLE);
        }
    }

    public void setoT (ObjectTransfer a) {
        oT = a;
    }

    public void setPosition(int a) {
        rhhfts_Position = a;
    }

}
