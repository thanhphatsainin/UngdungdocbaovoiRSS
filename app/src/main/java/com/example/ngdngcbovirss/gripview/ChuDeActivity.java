package com.example.ngdngcbovirss.gripview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ngdngcbovirss.MainActivity;
import com.example.ngdngcbovirss.R;

import java.util.ArrayList;

public class ChuDeActivity extends AppCompatActivity {

    private GridView gridViewHinhAnh;
    private ArrayList<ChuDe> arrayChude;
    private ChuDeAdapter chuDeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_de);
        intivity();

        chuDeAdapter = new ChuDeAdapter(this,R.layout.dong_gripview,arrayChude);
        gridViewHinhAnh.setAdapter(chuDeAdapter);
        action();
    }

    public void intivity (){
        gridViewHinhAnh = findViewById(R.id.gridViewChuDe);
        arrayChude = new ArrayList<>();

        arrayChude.add(new ChuDe(R.drawable.thoisu,"Thời sự"));
        arrayChude.add(new ChuDe(R.drawable.kinhdoanh,"Kinh Doanh"));
        arrayChude.add(new ChuDe(R.drawable.thitruong,"Thị trường"));
        arrayChude.add(new ChuDe(R.drawable.congnghe,"Công nghệ"));
        arrayChude.add(new ChuDe(R.drawable.hinhsu,"Hình sự"));
        arrayChude.add(new ChuDe(R.drawable.thethao,"Thể thao"));
        arrayChude.add(new ChuDe(R.drawable.bongda,"Bóng đá"));
        arrayChude.add(new ChuDe(R.drawable.thoitrang,"Thời trang"));
        arrayChude.add(new ChuDe(R.drawable.lamdep,"Làm đẹp"));
        arrayChude.add(new ChuDe(R.drawable.giaoduc1,"Giáo dục"));
        arrayChude.add(new ChuDe(R.drawable.dulich,"Du lịch"));
        arrayChude.add(new ChuDe(R.drawable.amthuc,"Ẩm thực"));
        arrayChude.add(new ChuDe(R.drawable.suckhoe,"Sức khỏe"));
        arrayChude.add(new ChuDe(R.drawable.xe,"Xe"));
        arrayChude.add(new ChuDe(R.drawable.canhac,"Ca nhạc"));
        arrayChude.add(new ChuDe(R.drawable.phim,"Phim"));
        arrayChude.add(new ChuDe(R.drawable.cuoi,"Cười"));
    }

    public void action(){
        gridViewHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String tenChude = arrayChude.get(position).getChuDe();
                Intent intent = new Intent(ChuDeActivity.this, MainActivity.class);
                intent.putExtra("tenchude",tenChude);
                startActivity(intent);
            }
        });
    }
}
