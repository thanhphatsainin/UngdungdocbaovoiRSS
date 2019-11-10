package com.example.ngdngcbovirss.gripview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ngdngcbovirss.R;

import java.util.List;

public class ChuDeAdapter  extends BaseAdapter {


    private Context context;
    private int layout;
    private List<ChuDe> chuDeList;

    public ChuDeAdapter(Context context, int layout, List<ChuDe> chuDeList) {
        this.context = context;
        this.layout = layout;
        this.chuDeList = chuDeList;
    }

    @Override
    public int getCount() {
        return chuDeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHoled{
        ImageView imageChuDe;
        TextView textViewChuDe;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoled holed;
        if (convertView==null){
            holed = new ViewHoled();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holed.imageChuDe    = convertView.findViewById(R.id.imageViewChuDe);
            holed.textViewChuDe = convertView.findViewById(R.id.textViewChuDe);
            convertView.setTag(holed);
        }
        else {
            holed = (ViewHoled) convertView.getTag();
        }
        ChuDe chuDe =  chuDeList.get(position);
        holed.imageChuDe.setImageResource(chuDe.getHinhanhChuDe());
        holed.textViewChuDe.setText(chuDe.getChuDe());
        return convertView;
    }
}
