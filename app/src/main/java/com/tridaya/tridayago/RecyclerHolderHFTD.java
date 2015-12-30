package com.tridaya.tridayago;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Suhafer on 16/11/2015.
 */
public class RecyclerHolderHFTD extends RecyclerView.ViewHolder{

    private final TextView rivh_VItemTitle, rivh_VItemClock;
    private String rivh_ItemTitle, rivh_ItemClock;
    private int rivh_Position;
    private Context rivh_Context;
    private ImageView rivh_checkList;
    private ObjectTransfer oT;

    public RecyclerHolderHFTD(final View parent) {
        super(parent);
        rivh_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rivh_VItemClock = (TextView) parent.findViewById(R.id.itemClock);
        rivh_checkList = (ImageView) parent.findViewById(R.id.itemCheck);
        rivh_Context = parent.getContext();
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rivh_Context, TaskReportActivity.class);
                detailItem.putExtra("item", rivh_ItemTitle);
                detailItem.putExtra("position", rivh_Position);
                detailItem.putExtra("object", oT);
                detailItem.putExtra("job", 0);
                rivh_Context.startActivity(detailItem);
            }
        });
    }

    public static RecyclerHolderHFTD newInstance(View parent) {
        return new RecyclerHolderHFTD(parent);
    }

    public void setItemText(CharSequence a,CharSequence b) {
        rivh_ItemTitle = (String) a;
        rivh_ItemClock = (String) b;
        rivh_VItemTitle.setText(rivh_ItemTitle);
        rivh_VItemClock.setText(rivh_ItemClock);

        if (rivh_ItemClock.equalsIgnoreCase("Not yet")) {
            rivh_checkList.setVisibility(View.INVISIBLE);
            rivh_VItemTitle.setTextColor(Color.parseColor("#008000"));
        }
        else {
            rivh_VItemTitle.setTextColor(Color.parseColor("#C0C0C0"));
            rivh_checkList.setVisibility(View.VISIBLE);
        }
    }

    public void setoT (ObjectTransfer a) {
        oT=a;
    }

    public void setPosition(int a) {
        rivh_Position = a;
    }

}