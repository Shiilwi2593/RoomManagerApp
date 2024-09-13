package edu.huflit.appphongtro.HoaDon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import edu.huflit.appphongtro.PhongTro.PhongTro;
import edu.huflit.appphongtro.PhongTro.PhongTroDB;
import edu.huflit.appphongtro.R;
import edu.huflit.appphongtro.ThuePhong.ThuePhongDB;

public class ThemHoaDon extends AppCompatActivity {


    HoaDonDB hoaDonDB;

    Context context = this;

    EditText sophong, dien, nuoc, tienphong;
    Button btnXong;

    ImageButton btnBack;

    PhongTroDB phongTroDB = new PhongTroDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);

        hoaDonDB = new HoaDonDB(this);

        sophong = findViewById(R.id.edtSoPhong_addHD);
        dien = findViewById(R.id.edtDien_addHD);
        nuoc = findViewById(R.id.edtNuoc_addHD);
        tienphong = findViewById(R.id.edtTienPhong_addHD);


        btnBack = findViewById(R.id.btnBack_themHD);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnXong = findViewById(R.id.btnAddHD);
        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemHD();
            }
        });



    }
    public void ThemHD(){
        String soPhongText = sophong.getText().toString();
        String dienText = dien.getText().toString();
        String nuocText = nuoc.getText().toString();
        String tienPhongText = tienphong.getText().toString();

        if (soPhongText.isEmpty() || dienText.isEmpty() || nuocText.isEmpty() || tienPhongText.isEmpty()) {
            Toast.makeText(context,"Vui lòng nhập đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra số phòng
        if (soPhongText.isEmpty() || !soPhongText.matches("\\d+")) {
            sophong.setError("Số phòng không hợp lệ");
            return;
        }

        int soPhong = Integer.parseInt(soPhongText);

        // Kiểm tra điện, nước, và tổng tiền
        if (!dienText.matches("\\d+") || !nuocText.matches("\\d+") || !tienPhongText.matches("\\d+")) {
            Toast.makeText(ThemHoaDon.this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        int dienSo = Integer.parseInt(dienText);
        int nuocSo = Integer.parseInt(nuocText);
        int tienPhongSo = Integer.parseInt(tienPhongText);

        // Tính tổng tiền
        double tongTien = dienSo + nuocSo + tienPhongSo;

        ThuePhongDB thuePhongDB = new ThuePhongDB(context);
        String tenKhach = thuePhongDB.getTenKhachThuePhong(soPhong);

        // Thêm hóa đơn vào cơ sở dữ liệu
        hoaDonDB.insertHoaDon(soPhong, tenKhach, dienSo, nuocSo, tienPhongSo, tongTien);

        Toast.makeText(context, "Thêm thành công!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ThemHoaDon.this, ListHoaDon.class);
        startActivity(i);
    }
}