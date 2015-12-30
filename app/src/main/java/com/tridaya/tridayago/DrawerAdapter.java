package com.tridaya.tridayago;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suhafer on 18/11/2015.
 */
public class DrawerAdapter extends ArrayAdapter<Drawer_Item> {

    private final Context context;
    private final ArrayList<Drawer_Item> dList;
    private int myDrawPosition;

    public DrawerAdapter(Context context, ArrayList<Drawer_Item> values, int a) {
        super(context, R.layout.row_drawer, values);
        this.context = context;
        this.dList = values;
        this.myDrawPosition = a;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(parent.getContext());
            view = vi.inflate(R.layout.row_drawer, parent, false);
        }

        ImageView img=(ImageView)view.findViewById(R.id.drawerIcon);
        TextView name=(TextView)view.findViewById(R.id.drawerItemName);
        LinearLayout bg = (LinearLayout) view.findViewById(R.id.drawerLayout);
        name.setText(dList.get(position).getItemName());
        //img.setImageResource(dList.get(position).getItemImage1());
        if (position==myDrawPosition) {
            bg.setBackgroundColor(view.getResources().getColor(R.color.selectBar));
            img.setImageResource(dList.get(position).getItemImage2());
        }
        else {
            img.setImageResource(dList.get(position).getItemImage1());
        }
        return view;
    }
}
