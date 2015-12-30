package com.tridaya.tridayago;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Suhafer on 20/11/2015.
 */
public abstract class HideListener extends RecyclerView.OnScrollListener {
    private static final int HL_HIDE_THRESHOLD = 20;
    private int hl_ScrolledDistance = 0;
    private boolean hl_controlsVisible = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (hl_ScrolledDistance > HL_HIDE_THRESHOLD && hl_controlsVisible) {
            onHide();
            hl_controlsVisible = false;
            hl_ScrolledDistance = 0;
        } else if (hl_ScrolledDistance < -HL_HIDE_THRESHOLD && !hl_controlsVisible) {
            onShow();
            hl_controlsVisible = true;
            hl_ScrolledDistance = 0;
        }

        if((hl_controlsVisible && dy>0) || (!hl_controlsVisible && dy<0)) {
            hl_ScrolledDistance += dy;
        }
    }

    public abstract void onHide();
    public abstract void onShow();
}
