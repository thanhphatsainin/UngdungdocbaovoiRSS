package com.example.ngdngcbovirss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterNews extends BaseAdapter {

    private Context context;
    private int layout;
    private List<News> newsList;

    public AdapterNews(Context context, int layout, List<News> newsList) {
        this.context = context;
        this.layout = layout;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
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

        TextView txtTieude;
        TextView txtNgaydang;
        ImageView imgHinh;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
            //anh xa view

        imgHinh   = convertView.findViewById(R.id.imageViewHinh);
        txtTieude    = convertView.findViewById(R.id.textViewTilte);
        txtNgaydang   = convertView.findViewById(R.id.textViewNgayDang);

        //gan gia tri
        News news = newsList.get(position);
        txtTieude.setText(news.getTieude());
        Glide.with(context)
                .load(news.getHinhanh())
                .into(imgHinh);
        txtNgaydang.setText(news.getNgaydang());

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.animation_dong_news);
        convertView.startAnimation(animation);
        return convertView;
    }
}
