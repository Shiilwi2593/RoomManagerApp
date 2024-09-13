package edu.huflit.appphongtro.HoaDon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.huflit.appphongtro.Khach.Khach;

public class HoaDonDB {
    String dbName = "PhongTro.db";
    Context context;
    SQLiteDatabase db;

    public HoaDonDB(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDB(){
        return context.openOrCreateDatabase(dbName,context.MODE_PRIVATE, null);
    }

    public void createTableHoaDon() {
        String sql = "CREATE TABLE IF NOT EXISTS tblHoaDon(" +
                "idHoaDon INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idPhong INTEGER," +
                "tenKhach TEXT," +
                "Dien INTEGER," +
                "Nuoc INTEGER," +
                "TienPhong INTEGER," +
                "TongTien Integer)";

        db = openDB();
        db.execSQL(sql);
        db.close();
    }

    public int countHoaDon(){
        String sql = "SELECT * FROM tblHoaDon";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        return count;
    }

    public String getTenKhachThuePhong(int idPhong) {
        db = openDB();
        String tenKhach = null;
        String idroom = String.valueOf(idPhong);
        String sql = "SELECT idKhach FROM tblThuePhong WHERE idPhong = " + idroom;

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            int idKhach = cursor.getInt(0);
            String idCus = String.valueOf(idKhach);

            Cursor khachCursor = db.rawQuery("SELECT tenKhach FROM tblHoaDon WHERE idPhong = " + idCus, null);
            if (khachCursor.moveToFirst()) {
                tenKhach = khachCursor.getString(0);
            }
            khachCursor.close();
        }

        cursor.close();
        db.close();

        return tenKhach;
    }


    public ArrayList<HoaDon> getHoaDon() {
        ArrayList<HoaDon> tmp = new ArrayList<>();
        String sql = "SELECT * FROM tblHoaDon";
        db = openDB();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int idhoadon = cursor.getInt(0);
            int idPhong = cursor.getInt(1);
            String tenKhach = cursor.getString(2);
            int dien = cursor.getInt(3);
            int nuoc = cursor.getInt(4);
            int tienPhong = cursor.getInt(5);
            int tongtien = cursor.getInt(6);
            HoaDon hoaDon = new HoaDon(idhoadon,idPhong,tenKhach,dien,nuoc,tienPhong,tongtien);
            tmp.add(hoaDon);
        }
        cursor.close();
        db.close();
        return tmp;
    }

    public void insertHoaDon(int idPhong, String tenKhach, int Dien, int Nuoc, int TienPhong, double tongTien ) {
        db = openDB();
        ContentValues values = new ContentValues();
        values.put("idPhong", idPhong);
        values.put("tenKhach",tenKhach);
        values.put("Dien", Dien);
        values.put("Nuoc", Nuoc);
        values.put("TienPhong", TienPhong);
        values.put("TongTien", tongTien);
        db.insert("tblHoaDon", null, values);
        db.close();
    }

    public void updateHoaDon(int idHoaDon, int idPhong, String tenKhach, int Dien, int Nuoc, int TienPhong, int tongTien) {
        db = openDB();
        ContentValues values = new ContentValues();
        values.put("idPhong", idPhong);
        values.put("tenKhach", tenKhach); // Cập nhật tên khách hàng
        values.put("Dien", Dien);
        values.put("Nuoc", Nuoc);
        values.put("TienPhong", TienPhong);
        values.put("TongTien", tongTien);

        String whereClause = "idHoaDon = ?";
        String[] whereArgs = {String.valueOf(idHoaDon)};

        db.update("tblHoaDon", values, whereClause, whereArgs);
        db.close();
    }

    public void deleteHoaDon(int idHoaDon) {
        db = openDB();

        String whereClause = "idHoaDon = ?";
        String[] whereArgs = {String.valueOf(idHoaDon)};

        db.delete("tblHoaDon", whereClause, whereArgs);
        db.close();
    }






}
