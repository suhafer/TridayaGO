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
 * Created by Suhafer on 19/11/2015.
 */
public class HomeFragmentTask extends Fragment {

    private static final String HFT_ARG_SECTION_NUMBER = "section_number";
    private static final int HFT_NUM_PAGES = 2;
    ViewPager hft_Pager;

    PagerAdapter hft_PagerAdapter;
    FragmentTabHost hft_TabHost;
    Toolbar hft_ToolBar;

    public static HomeFragmentTask newInstance(int sectionNumber) {
        HomeFragmentTask fragment = new HomeFragmentTask();
        Bundle args = new Bundle();
        args.putInt(HFT_ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragmentTask() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hometask, container, false);
        Context context = rootView.getContext();

        hft_ToolBar = ((HomeActivity)getActivity()).getMyToolbar();

        hft_TabHost = ((HomeActivity)getActivity()).getMyTabHost();
        hft_TabHost.setVisibility(View.VISIBLE);

        hft_Pager =(ViewPager)rootView.findViewById(R.id.pager);
        ((HomeActivity) getActivity()).setMyPager(hft_Pager);

        hft_PagerAdapter = new HFT_ScreenSlidePagerAdapter(getChildFragmentManager());
        hft_Pager.setAdapter(hft_PagerAdapter);


        hft_TabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("tab1")) {
                    hft_Pager.setCurrentItem(0);
                } else if (tabId.equalsIgnoreCase("tab2")) {
                    hft_Pager.setCurrentItem(1);
                }
                ((HomeActivity)getActivity()).ha_SetBar();
            }
        });

        hft_Pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                hft_TabHost = ((HomeActivity)getActivity()).getMyTabHost();
                hft_TabHost.setCurrentTab(position);
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
                getArguments().getInt(HFT_ARG_SECTION_NUMBER));
    }

    private class HFT_ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public HFT_ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new HomeFragmentTaskD();
            }
            else if (position==1) {
                return new HomeFragmentTaskS();
            }
            else {
                return new HomeFragmentTaskS();
            }
        }

        @Override
        public int getCount() {
            return HFT_NUM_PAGES;
        }
    }
}
