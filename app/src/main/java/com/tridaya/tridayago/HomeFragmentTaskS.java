package com.tridaya.tridayago;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

/**
 * Created by Suhafer on 13/11/2015.
 */
public class HomeFragmentTaskS extends Fragment {

    Context hfts_context;

    Toolbar hfts_ToolBar;
    LinearLayout hfts_LinearLayout;
    FragmentTabHost hfts_TabHost;


    RecyclerView hfts_RecyclerView;
    LayoutManagerType hfts_CurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
    }

    public HomeFragmentTaskS () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View screen = inflater.inflate(R.layout.fragment_htasks, container, false);
        hfts_context = screen.getContext();

        hfts_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfts_LinearLayout = ((HomeActivity)getActivity()).getMyLinearLayout();
        hfts_TabHost = ((HomeActivity)getActivity()).getMyTabHost();

        hfts_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);

        setPadding();

        hfts_RecyclerView.setLayoutManager(new LinearLayoutManager(hfts_context));
        hfts_CurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            hfts_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hfts_RecyclerView.addOnScrollListener(new HideListener() {

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

    private void initRecyclerView() {
        ObjectTransfer a = ((HomeActivity) getActivity()).getObject();
        RecyclerAdapterHFTS recyclerAdapters = new RecyclerAdapterHFTS(a);
        hfts_RecyclerView.setAdapter(recyclerAdapters);
    }

    private void hideViews() {
        hfts_LinearLayout.animate().translationY(-hfts_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfts_LinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void setPadding () {
        int a = 0 ;
        double heights = hfts_TabHost.getTabWidget().getChildAt(0).getLayoutParams().height;
        int h = (int) heights;
        TypedValue tv = new TypedValue();
        if (hfts_context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            a = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        int paddingTop = a + h;
        hfts_RecyclerView.setPadding(0, paddingTop, 0, 0);

    }

}
