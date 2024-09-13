package edu.huflit.appphongtro.HoaDon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import edu.huflit.appphongtro.Khach.Khach;
import edu.huflit.appphongtro.R;

public class EditHD extends AppCompatActivity {

    HoaDon hoadon;

    EditText  edtDien, edtNuoc, edtTienPhong;

    Button btnxong;

    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hd);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            hoadon = (HoaDon) bundle.getSerializable("hoadon");
        }
        btnBack = findViewById(R.id.btnBack_editHD);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        edtDien = findViewById(R.id.edtDien_editHD);
        edtNuoc = findViewById(R.id.edtNuoc_editHD);
        edtTienPhong = findViewById(R.id.edtTienPhong_editHD);

        edtDien.setText(String.valueOf(hoadon.getDien()));
        edtNuoc.setText(String.valueOf(hoadon.getNuoc()));
        edtTienPhong.setText(String.valueOf(hoadon.getTienPhong()));


        btnxong = findViewById(R.id.btnEditHD_editHD);
        btnxong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnxong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        String dienStr = edtDien.getText().toString();
                        String nuocStr = edtNuoc.getText().toString();
                        String tienPhongStr = edtTienPhong.getText().toString();

                        if ( dienStr.isEmpty() || nuocStr.isEmpty() || tienPhongStr.isEmpty()) {
                            Toast.makeText(EditHD.this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                        } else if (!isNumeric(dienStr) || !isNumeric(nuocStr) || !isNumeric(tienPhongStr)) {
                            Toast.makeText(EditHD.this, "Thông tin không hợp lệ. Vui lòng nhập số.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Cập nhật hóa đơn
                            int dien = Integer.parseInt(dienStr);
                            int nuoc = Integer.parseInt(nuocStr);
                            int tienPhong = Integer.parseInt(tienPhongStr);
                            int tongTien = dien + nuoc + tienPhong; // Tính tổng tiền

                            HoaDonDB hoaDonDB = new HoaDonDB(EditHD.this);

                            hoaDonDB.updateHoaDon(hoadon.getIdHoadon(), hoadon.getIdPhong(), hoadon.getTenKhach(), dien, nuoc, tienPhong, tongTien);

                            Toast.makeText(EditHD.this, "Cập nhật hóa đơn thành công.", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(EditHD.this, ListHoaDon.class);
                            startActivity(i);
                        }
                    }
                });

            }
            private boolean isNumeric(String str) {
                return str.matches("-?\\d+(\\.\\d+)?");
            }
        });


    }
}