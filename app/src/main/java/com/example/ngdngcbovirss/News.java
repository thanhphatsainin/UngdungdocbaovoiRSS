package com.example.ngdngcbovirss;

import android.widget.ImageView;

public class News {
    private String hinhanh;
    private String tieude;
    private String ngaydang;

    public News() {
    }

    public News(String hinhanh, String tieude, String ngaydang) {
        this.hinhanh = hinhanh;
        this.tieude = tieude;
        this.ngaydang = ngaydang;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }
}
