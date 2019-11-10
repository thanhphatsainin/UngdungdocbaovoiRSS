package com.example.ngdngcbovirss.gripview;

import android.widget.ImageView;

public class ChuDe {
    private int hinhanhChuDe;
    private String ChuDe;

    public ChuDe(){}

    public ChuDe(int hinhanhChuDe, String chuDe) {
        this.hinhanhChuDe = hinhanhChuDe;
        ChuDe = chuDe;
    }

    public int getHinhanhChuDe() {
        return hinhanhChuDe;
    }

    public void setHinhanhChuDe(int hinhanhChuDe) {
        this.hinhanhChuDe = hinhanhChuDe;
    }

    public String getChuDe() {
        return ChuDe;
    }

    public void setChuDe(String chuDe) {
        ChuDe = chuDe;
    }
}
