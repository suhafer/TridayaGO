package com.tridaya.tridayago;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Suhafer on 13/11/2015.
 */
public class HomeFragmentReport extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int HFR_NUM_PAGES = 2;

    ViewPager hfr_Pager;

    PagerAdapter hfr_PagerAdapter;
    FragmentTabHost hfr_TabHost;
    ActionBar hfr_ActionBar;
    Toolbar hfr_ToolBar;

    public static HomeFragmentReport newInstance(int sectionNumber) {
        HomeFragmentReport fragment = new HomeFragmentReport();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragmentReport() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homereport, container, false);
        Context context = rootView.getContext();

        hfr_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();


        hfr_TabHost = ((HomeActivity)getActivity()).getMyTabHost();
        hfr_TabHost.setVisibility(View.VISIBLE);

        hfr_Pager =(ViewPager)rootView.findViewById(R.id.pager);
        ((HomeActivity)getActivity()).setMyPager(hfr_Pager);

        hfr_PagerAdapter = new HFR_ScreenSlidePagerAdapter(getChildFragmentManager());
        hfr_Pager.setAdapter(hfr_PagerAdapter);

        hfr_TabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("tab1")) {
                    hfr_Pager.setCurrentItem(0);
                } else if (tabId.equalsIgnoreCase("tab2")) {
                    hfr_Pager.setCurrentItem(1);
                }
                ((HomeActivity)getActivity()).ha_SetBar();
            }
        });

        hfr_Pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                hfr_TabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    private class HFR_ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public HFR_ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new HomeFragmentReportD();
            }
            else if (position==1) {
                return new HomeFragmentReportS();
            }
            else {
                return new HomeFragmentReportS();
            }
        }

        @Override
        public int getCount() {
            return HFR_NUM_PAGES;
        }
    }
}
