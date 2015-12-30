package com.tridaya.tridayago;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Suhafer on 16/11/2015.
 */
public class RecyclerAdapterHFTD extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> ra_ItemList,ra_ClockList;
    private ObjectTransfer ra_oT;

    public RecyclerAdapterHFTD(ObjectTransfer itemList) {
        ra_oT = itemList;
        ra_ItemList = ra_oT.getListItemTaskD();
        ra_ClockList = ra_oT.getListClockTaskD();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemhftd, parent, false);
        return RecyclerHolderHFTD.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerHolderHFTD holder = (RecyclerHolderHFTD) viewHolder;
        String itemText = ra_ItemList.get(position);
        String clockText = ra_ClockList.get(position);
        holder.setPosition(position);
        holder.setoT(ra_oT);
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
        //return ra_ItemList == null ? 0 : ra_ItemList.size();
    }

}
