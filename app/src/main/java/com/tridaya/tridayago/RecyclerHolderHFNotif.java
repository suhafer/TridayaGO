package com.tridaya.tridayago;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerHolderHFNotif extends RecyclerView.ViewHolder{

    private final TextView rhhfreq_VItemTitle, rhhfreq_VItemClock, rhhfreq_VItemNotes;
    private final ImageView rhhfnotif_Check;
    private String rhhfreq_ItemTitle, rhhfreq_ItemClock, rhhfreq_ItemNotes;
    private int rhhfreq_Position;
    private Context rhhfreq_Context;
    private ObjectTransfer ra_oT;

    public RecyclerHolderHFNotif(final View parent) {
        super(parent);
        rhhfreq_VItemTitle = (TextView) parent.findViewById(R.id.itemTitle);
        rhhfreq_VItemClock = (TextView) parent.findViewById(R.id.itemClock);
        rhhfreq_VItemNotes = (TextView) parent.findViewById(R.id.itemNotes);
        rhhfnotif_Check = (ImageView) parent.findViewById(R.id.itemPicture);
        rhhfreq_Context = parent.getContext();

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailItem = new Intent(rhhfreq_Context, Notif_Detail_Activity.class);
                detailItem.putExtra("item", rhhfreq_ItemTitle);
                detailItem.putExtra("clock", rhhfreq_ItemClock);
                detailItem.putExtra("notes", rhhfreq_ItemNotes);
                rhhfreq_Context.startActivity(detailItem);
            }
        });
    }

    public static RecyclerHolderHFNotif newInstance(View parent) {
        return new RecyclerHolderHFNotif(parent);
    }

    public void setItemText(CharSequence a,CharSequence b) {
        rhhfreq_ItemTitle = (String) a;
        rhhfreq_ItemClock = (String) b;
        String[] c = ra_oT.getDummyNotif();
        rhhfreq_ItemNotes = c[rhhfreq_Position];

        setRhhfnotif_Check();

        rhhfreq_VItemTitle.setText(rhhfreq_ItemTitle);
        rhhfreq_VItemClock.setText(rhhfreq_ItemClock);
        rhhfreq_VItemNotes.setText(rhhfreq_ItemNotes);
    }

    public void setRhhfnotif_Check () {
        if (rhhfreq_ItemTitle.equalsIgnoreCase("Admin")) {
            rhhfnotif_Check.setVisibility(View.INVISIBLE);
            rhhfreq_VItemTitle.setTextColor(Color.parseColor("#C0C0C0"));
        }
        else {
            rhhfnotif_Check.setVisibility(View.VISIBLE);
            rhhfreq_VItemTitle.setTextColor(Color.parseColor("#008000"));
        }
    }

    public void setPosition(int a) {
        rhhfreq_Position = a;
    }

    public void setRa_oT (ObjectTransfer a) {
        ra_oT = a;
    }

}
