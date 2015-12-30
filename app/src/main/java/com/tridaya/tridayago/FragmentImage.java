package com.tridaya.tridayago;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Suhafer on 26/11/2015.
 */
public class FragmentImage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_image, container, false);
        ImageView b = (ImageView) rootView.findViewById(R.id.image);
        b.setImageResource(R.drawable.contohimage_5);
        //a.setVisibility(View.GONE);
        return rootView;
    }
}
