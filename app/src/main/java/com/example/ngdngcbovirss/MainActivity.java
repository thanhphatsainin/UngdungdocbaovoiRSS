package com.example.ngdngcbovirss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected ListView listViewTieuDe;
    public static ArrayList<News> arrayNews;
    public static ArrayList<String> arrayLink;
    protected static AdapterNews adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTieuDe = findViewById(R.id.ListViewTieuDe);
        arrayNews = new ArrayList<News>();
        arrayLink = new ArrayList<>();
        adapter = new AdapterNews(this,R.layout.dong_news,arrayNews);
        listViewTieuDe.setAdapter(adapter);
        AsyncTaskDocBao asyncTaskDocBao = new AsyncTaskDocBao(MainActivity.this);
        Intent intent = getIntent();
        String s = intent.getStringExtra("tenchude");
        if (s.equalsIgnoreCase("Ẩm thực")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/amthuc.rss");
        }
        else if (s.equalsIgnoreCase("Kinh Doanh")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/taichinhbatdongsan.rss");
        }
        else if (s.equalsIgnoreCase("Giáo dục")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/giaoducduhoc.rss");
        }
        else if (s.equalsIgnoreCase("Thể thao")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/thethao.rss");
        }
        else if (s.equalsIgnoreCase("Thời sự")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/tintuctrongngay.rss");
        }
        else if (s.equalsIgnoreCase("Công nghệ")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/congnghethongtin.rss");
        }
        else if (s.equalsIgnoreCase("Du lịch")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/dulich.rss");
        }
        else if (s.equalsIgnoreCase("Sức khỏe")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/suckhoedoisong.rss");
        }
        else if (s.equalsIgnoreCase("Xe")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/oto.rss");
        }
        else if (s.equalsIgnoreCase("Cười")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/cuoi24h.rss");
        }
        else if (s.equalsIgnoreCase("Ca nhạc")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/canhacmtv.rss");
        }
        else if (s.equalsIgnoreCase("Làm đẹp")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/lamdep.rss");
        }
        else if (s.equalsIgnoreCase("Thời trang")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/thoitrang.rss");
        }
        else if (s.equalsIgnoreCase("Hình sự")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/anninhhinhsu.rss");
        }
        else if (s.equalsIgnoreCase("Phim")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/phim.rss");
        }

        else if (s.equalsIgnoreCase("Thị trường")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/thitruongtieudung.rss");
        }
        else if (s.equalsIgnoreCase("Bóng đá")){
            asyncTaskDocBao.execute("https://24h.com.vn/upload/rss/bongda.rss");
        }


        listViewTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = arrayLink.get(position);

//                Intent intent = new Intent();              dua toi link cu atrinh duyet
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(s));
//                startActivity(intent);

                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                intent.putExtra("linktintuc",s);
                startActivity(intent);

            }
        });
    }
}
