package com.tridaya.tridayago;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.tridaya.tridayago.util.RecyclerAdapterHFRS;

/**
 * Created by Suhafer on 23/11/2015.
 */
public class HomeFragmentReportS extends Fragment {
    Context hfrs_context;

    Toolbar hfrs_ToolBar;
    LinearLayout hfrs_LinearLayout;
    FragmentTabHost hfrs_TabHost;

    RecyclerView hfrs_RecyclerView;
    LayoutManagerType hfrs_CurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public HomeFragmentReportS(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View screen = inflater.inflate(R.layout.fragment_hreports, container, false);
        hfrs_context = screen.getContext();

        hfrs_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfrs_LinearLayout = ((HomeActivity)getActivity()).getMyLinearLayout();
        hfrs_TabHost = ((HomeActivity)getActivity()).getMyTabHost();

        hfrs_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);

        setPadding();

        hfrs_RecyclerView.setHasFixedSize(true);

        hfrs_RecyclerView.setLayoutManager(new LinearLayoutManager(hfrs_context));
        hfrs_CurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            hfrs_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hfrs_RecyclerView.addOnScrollListener(new HideListener() {
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
        RecyclerAdapterHFRS recyclerAdapter = new RecyclerAdapterHFRS(a);
        hfrs_RecyclerView.setAdapter(recyclerAdapter);
    }

    private void hideViews() {
        hfrs_LinearLayout.animate().translationY(-hfrs_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfrs_LinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void setPadding () {
        int a = 0 ;
        double heights = hfrs_TabHost.getTabWidget().getChildAt(0).getLayoutParams().height;
        int h = (int) heights;
        TypedValue tv = new TypedValue();
        if (hfrs_context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            a = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        int paddingTop = a + h;
        hfrs_RecyclerView.setPadding(0, paddingTop, 0, 0);

    }
}
