package com.tridaya.tridayago;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

/**
 * Created by Suhafer on 25/11/2015.
 */
public class HomeFragmentRequest extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    Context hfreq_context;

    Toolbar hfreq_ToolBar;
    FragmentTabHost hfreq_TabHost;
    LinearLayout hfreq_lL;
    RecyclerView hfreq_RecyclerView;
    RecyclerView.LayoutManager hfreq_LayoutManager;
    LayoutManagerType hfreq_CurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public static HomeFragmentRequest newInstance(int sectionNumber) {
        HomeFragmentRequest fragment = new HomeFragmentRequest();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragmentRequest(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View screen = inflater.inflate(R.layout.fragment_homerequest, container, false);
        hfreq_context = screen.getContext();

        hfreq_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();
        hfreq_TabHost = ((HomeActivity)getActivity()).getMyTabHost();
        hfreq_lL = ((HomeActivity)getActivity()).getMyLinearLayout();
        hfreq_TabHost.setVisibility(View.GONE);

        hfreq_RecyclerView = (RecyclerView) screen.findViewById(R.id.recyclerView);
        hfreq_RecyclerView.setHasFixedSize(true);

        hfreq_LayoutManager = new GridLayoutManager(hfreq_context,2);
        hfreq_RecyclerView.setLayoutManager(hfreq_LayoutManager);
        hfreq_CurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
        if (savedInstanceState != null) {
            hfreq_CurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable("layoutmanager");
        }

        initRecyclerView();

        hfreq_RecyclerView.addOnScrollListener(new HideListener() {
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
        ObjectTransfer a = ((HomeActivity) getActivity()).getObject();
        RecyclerAdapterHFReq recyclerAdapter = new RecyclerAdapterHFReq(a);
        hfreq_RecyclerView.setAdapter(recyclerAdapter);
    }

    private void hideViews() {
        hfreq_lL.animate().translationY(-hfreq_ToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        hfreq_lL.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }
}
