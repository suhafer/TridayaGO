package com.tridaya.tridayago;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class RecyclerAdapterHFReq extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> rahfreq_ItemList;
    private ObjectTransfer ra_oT;

    public RecyclerAdapterHFReq(ObjectTransfer itemList) {
        ra_oT = itemList;
        rahfreq_ItemList = ra_oT.getListItemRequest();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemhfreq, parent, false);
        return RecyclerHolderHFReq.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerHolderHFReq holder = (RecyclerHolderHFReq) viewHolder;
        String itemText = rahfreq_ItemList.get(position);
        holder.setPosition(position);
        holder.setRa_oT(ra_oT);
        holder.setItemText(itemText);
    }

    @Override
    public int getItemCount() {
        if (rahfreq_ItemList == null) {
            return 0;
        }
        else {
            return rahfreq_ItemList.size();
        }
    }
}
