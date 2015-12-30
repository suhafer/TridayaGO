package com.tridaya.tridayago.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tridaya.tridayago.ObjectTransfer;
import com.tridaya.tridayago.R;
import com.tridaya.tridayago.RecyclerHolderHFRD;
import com.tridaya.tridayago.RecyclerHolderHFRS;

import java.util.List;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerAdapterHFRS extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> ra_ItemList,ra_ClockList;
    private ObjectTransfer ra_oT;

    public RecyclerAdapterHFRS(ObjectTransfer itemList) {
        ra_oT = itemList;
        ra_ItemList = ra_oT.getListItemReportD();
        ra_ClockList = ra_oT.getListClockReportD();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemhfrs, parent, false);
        return RecyclerHolderHFRS.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerHolderHFRS holder = (RecyclerHolderHFRS) viewHolder;
        String itemText = ra_ItemList.get(position);
        String clockText = ra_ClockList.get(position);
        holder.setPosition(position);
        holder.setRa_oT(ra_oT);
        holder.setItemText(itemText, clockText);
    }

    @Override
    public int getItemCount() {
        if (ra_ItemList == null) {
            return 0;
        }
        else {
            return ra_ItemList.size();
        }
    }
}
