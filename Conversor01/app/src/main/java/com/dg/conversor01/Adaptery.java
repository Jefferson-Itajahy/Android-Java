package com.dg.conversor01;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptery extends BaseAdapter {

    private Context mContext;

    public Adaptery(Context c) {
        mContext = c;
    }

    public int getCount() {
        return vetorImagens.length;
    }

    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Método de manipulação das imagens
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(vetorImagens[position]);

        return imageView;
    }
    //Vetor de Imagens
    public Integer[] vetorImagens = {
            R.drawable.dolaricon, R.drawable.euroicon
    };
}
