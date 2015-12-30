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

/**
 * Created by Suhafer on 23/11/2015.
 */
public class HomeFragmentReportD extends Fragment {
    Context hfrd_context;

    Toolbar hfrd_ToolBar;
    LinearLayout hfrd_LinearLayout;
    FragmentTabHost hfrd_TabHost;

    RecyclerView hfrd_RecyclerView;
    LayoutManagerType hfrd_CurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public HomeFragmentReportD(){

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
        View screen = inflater.inflate(R.layout.fragment_hreportd, container, false);
        hfrd_context = screen.getContext();

        hfrd_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfrd_LinearLayout = ((HomeActivity)getActivity()).getMyLinearLayout();
        hfrd_TabHost = ((HomeActivity)getActivity()).getMyTabHost();

        hfrd_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);

        setPadding();

        hfrd_RecyclerView.setHasFixedSize(true);

        hfrd_RecyclerView.setLayoutManager(new LinearLayoutManager(hfrd_context));
        hfrd_CurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            hfrd_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hfrd_RecyclerView.addOnScrollListener(new HideListener() {
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
        RecyclerAdapterHFRD recyclerAdapter = new RecyclerAdapterHFRD(a);
        hfrd_RecyclerView.setAdapter(recyclerAdapter);
    }

    private void hideViews() {
        hfrd_LinearLayout.animate().translationY(-hfrd_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfrd_LinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void setPadding () {
        int a = 0 ;
        double heights = hfrd_TabHost.getTabWidget().getChildAt(0).getLayoutParams().height;
        int h = (int) heights;
        TypedValue tv = new TypedValue();
        if (hfrd_context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            a = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        int paddingTop = a + h;
        hfrd_RecyclerView.setPadding(0, paddingTop, 0, 0);

    }
}
