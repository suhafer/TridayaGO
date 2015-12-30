package com.tridaya.tridayago;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Suhafer on 25/11/2015.
 */
public class RecyclerAdapterHFTS extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> rahfts_ItemList,rahfts_ClockList;
    private ObjectTransfer rahfts_oT;

    public RecyclerAdapterHFTS(ObjectTransfer itemList) {
        rahfts_oT = itemList;
        rahfts_ItemList = rahfts_oT.getListItemTaskD();
        rahfts_ClockList = rahfts_oT.getListClockTaskD();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemhfts, parent, false);
        return RecyclerHolderHFTS.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerHolderHFTS holder = (RecyclerHolderHFTS) viewHolder;
        String itemText = rahfts_ItemList.get(position);
        String clockText = rahfts_ClockList.get(position);
        holder.setPosition(position);
        holder.setoT(rahfts_oT);
        holder.setItemText(itemText, clockText);
    }

    @Override
    public int getItemCount() {
        if (rahfts_ItemList == null) {
            return 0;
        }
        else {
            return rahfts_ItemList.size();
        }
        //return rahfts_ItemList == null ? 0 : rahfts_ItemList.size();
    }
}
