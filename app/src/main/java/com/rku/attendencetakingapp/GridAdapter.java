package com.rku.attendencetakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridAdapter extends BaseAdapter {
    private final int image[];
    private final String name[];
    Context context;

    public GridAdapter(int[] image, String[] name, Context context) {
        this.image = image;
        this.name = name;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_card_view,null);
        ImageView img=(ImageView)view.findViewById(R.id.img);
        TextView txt=(TextView)view.findViewById(R.id.txt);
        img.setImageResource(image[position]);
        txt.setText(name[position]);
        return view;
    }

}
