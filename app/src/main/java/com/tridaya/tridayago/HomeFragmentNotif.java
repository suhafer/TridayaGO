package com.tridaya.tridayago;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suhafer on 25/11/2015.
 */
public class HomeFragmentNotif extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    Context hfnotif_context;

    FragmentTabHost hfnotif_TabHost;
    Toolbar hfnotif_ToolBar;
    LinearLayout hfnotif_lL;
    RecyclerView hfnotif_RecyclerView;
    LayoutManagerType hfnotif_CurrentLayoutManagerType;

    ObjectTransfer oItem;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public static HomeFragmentNotif newInstance(int sectionNumber) {
        HomeFragmentNotif fragment = new HomeFragmentNotif();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragmentNotif(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View screen = inflater.inflate(R.layout.fragment_homenotif, container, false);
        hfnotif_context = screen.getContext();

        hfnotif_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfnotif_TabHost = ((HomeActivity)getActivity()).getMyTabHost();
        hfnotif_lL = ((HomeActivity)getActivity()).getMyLinearLayout();
        hfnotif_TabHost.setVisibility(View.GONE);

        hfnotif_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);
        hfnotif_RecyclerView.setHasFixedSize(true);

        hfnotif_RecyclerView.setLayoutManager(new LinearLayoutManager(hfnotif_context));
        hfnotif_CurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            hfnotif_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hfnotif_RecyclerView.addOnScrollListener(new HideListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });

        return screen;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    private void initRecyclerView() {
        oItem = ((HomeActivity) getActivity()).getObject();
        List<String> list;
        int a = oItem.getMark();
        if (a==1) {
            list = oItem.getListItemSearch();
            oItem.setMark(0);
        }
        else {
            list = oItem.getListItemNotif();
        }
        //RecyclerAdapterHFNotif recyclerAdapter = new RecyclerAdapterHFNotif(itemList());
        RecyclerAdapterHFNotif recyclerAdapter = new RecyclerAdapterHFNotif(list,oItem);
        hfnotif_RecyclerView.setAdapter(recyclerAdapter);
    }

    private void hideViews() {
        hfnotif_lL.animate().translationY(-hfnotif_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfnotif_lL.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }
}
