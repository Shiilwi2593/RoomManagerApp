package edu.huflit.appphongtro.HoaDon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.huflit.appphongtro.Khach.DetailKhach;
import edu.huflit.appphongtro.Khach.EditKhach;
import edu.huflit.appphongtro.Khach.Khach;
import edu.huflit.appphongtro.PhongTro.PhongTroDB;
import edu.huflit.appphongtro.R;

public class DetailHoaDon extends AppCompatActivity {

    TextView tvidhoadon, tvidphong, tvtenkhach, tvdien, tvnuoc, tvtienphong, tvtongtien;

    Button btnchinhsua, btnxoa;

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hoa_don);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        HoaDonDB hoaDonDB = new HoaDonDB(this);

        HoaDon hoaDon = (HoaDon) bundle.get("hoadon");


        tvidhoadon = findViewById(R.id.tvIDHD_deHD);
        tvidphong = findViewById(R.id.tvIDPhong_deHD);
        tvtenkhach = findViewById(R.id.tvTenKhach_deHD);
        tvdien = findViewById(R.id.tvDien_deHD);
        tvnuoc = findViewById(R.id.tvNuoc_deHD);
        tvtienphong = findViewById(R.id.tvTienPhong_deHD);
        tvtongtien = findViewById(R.id.tvTongTien_deHD);

        btnBack = findViewById(R.id.btnBack_DetailHD);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        tvidhoadon.setText(String.valueOf(hoaDon.getIdHoadon()));
        tvidphong.setText(String.valueOf(hoaDon.getIdPhong()));
        tvtenkhach.setText(hoaDon.getTenKhach());
        tvdien.setText(String.valueOf(hoaDon.getDien()));
        tvnuoc.setText(String.valueOf(hoaDon.getNuoc()));
        tvtienphong.setText(String.valueOf(hoaDon.getTienPhong()));
        tvtongtien.setText(String.valueOf(hoaDon.getTongTien()));

        btnchinhsua = findViewById(R.id.btnEditHD);
        btnxoa = findViewById(R.id.btnXoaHD);

        btnchinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailHoaDon.this, EditHD.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("hoadon", hoaDon);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailHoaDon.this);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa hóa đơn này?");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        hoaDonDB.deleteHoaDon(hoaDon.getIdHoadon());
                        Toast.makeText(DetailHoaDon.this, "Hóa đơn đã được xóa.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailHoaDon.this, ListHoaDon.class);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

}