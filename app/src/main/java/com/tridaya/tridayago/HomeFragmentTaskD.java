package com.tridaya.tridayago;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TabHost;
import android.widget.TextView;


/**
 * Created by Suhafer on 13/11/2015.
 */
public class HomeFragmentTaskD extends Fragment{

    Context hftd_context;

    Toolbar hftd_ToolBar;
    LinearLayout hfts_LinearLayout;
    FragmentTabHost hftd_TabHost;

    RecyclerView hftd_RecyclerView;
    RecyclerView.LayoutManager hftd_LayoutManager;
    LayoutManagerType hftd_CurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public HomeFragmentTaskD (){

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
        View screen = inflater.inflate(R.layout.fragment_htaskd, container, false);
        hftd_context = screen.getContext();

        hftd_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfts_LinearLayout = ((HomeActivity)getActivity()).getMyLinearLayout();
        hftd_TabHost = ((HomeActivity)getActivity()).getMyTabHost();

        hftd_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);

        setPadding();

        hftd_RecyclerView.setLayoutManager(new LinearLayoutManager(hftd_context));
        hftd_CurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            hftd_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hftd_RecyclerView.addOnScrollListener(new HideListener() {

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
        RecyclerAdapterHFTD recyclerAdapterHFTD = new RecyclerAdapterHFTD(a);
        hftd_RecyclerView.setAdapter(recyclerAdapterHFTD);
    }

    private void hideViews() {
        hfts_LinearLayout.animate().translationY(-hftd_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfts_LinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void setPadding () {
        int a = 0 ;
        double heights = hftd_TabHost.getTabWidget().getChildAt(0).getLayoutParams().height;
        int h = (int) heights;
        TypedValue tv = new TypedValue();
        if (hftd_context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            a = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        int paddingTop = a + h;
        hftd_RecyclerView.setPadding(0,paddingTop,0,0);

    }
}
