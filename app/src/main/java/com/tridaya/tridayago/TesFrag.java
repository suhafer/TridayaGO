package com.tridaya.tridayago;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Suhafer on 19/11/2015.
 */
public class TesFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.layout_tes, container, false);
        TextView a = (TextView) rootView.findViewById(R.id.aaa);
        a.setText("TESAAAAAA");
        //a.setVisibility(View.GONE);
        return rootView;
    }
}
