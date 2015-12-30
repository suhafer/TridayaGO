package com.tridaya.tridayago;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerAdapterHFNotif extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> rahfnotif_ItemList,rahfnotif_ClockList;
    private ObjectTransfer ra_oT;

    public RecyclerAdapterHFNotif(List<String> itemList, ObjectTransfer a) {
        rahfnotif_ItemList = itemList;
        ra_oT = a;
        rahfnotif_ClockList = ra_oT.getListClockNotif();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemhfnotif, parent, false);
        return RecyclerHolderHFNotif.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerHolderHFNotif holder = (RecyclerHolderHFNotif) viewHolder;
        String itemText = rahfnotif_ItemList.get(position);
        String itemClock = rahfnotif_ClockList.get(position);
        holder.setPosition(position);
        holder.setRa_oT(ra_oT);
        holder.setItemText(itemText, itemClock);
    }

    @Override
    public int getItemCount() {
        if (rahfnotif_ItemList == null) {
            return 0;
        }
        else {
            return rahfnotif_ItemList.size();
        }
    }
}
