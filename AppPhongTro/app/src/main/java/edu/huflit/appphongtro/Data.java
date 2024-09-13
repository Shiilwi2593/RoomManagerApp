package edu.huflit.appphongtro;

import android.app.Application;

import java.util.ArrayList;

import edu.huflit.appphongtro.HoaDon.HoaDon;
import edu.huflit.appphongtro.HoaDon.HoaDonDB;
import edu.huflit.appphongtro.Khach.KhachDB;
import edu.huflit.appphongtro.PhongTro.PhongTro;
import edu.huflit.appphongtro.PhongTro.PhongTroDB;
import edu.huflit.appphongtro.ThuePhong.ThuePhongDB;

public class Data extends Application {
    PhongTroDB phongTroDB;
    KhachDB khachDB;
    HoaDonDB hoaDonDB;
    ThuePhongDB thuePhongDB;
    ArrayList<PhongTro> lstPhong;

    @Override
    public void onCreate() {
        super.onCreate();
        phongTroDB = new PhongTroDB(this);
        phongTroDB.createTable();
        if(phongTroDB.countPhong() == 0){
            phongTroDB.insertPhong(30,3000000,"Phòng đẹp, thoáng mát, có ban công, có cửa sổ","https://timescityminhkhai.com/wp-content/uploads/sites/4/2020/10/phong-tro-cho-thue.jpg",1);
            phongTroDB.insertPhong(30,3000000,"Phòng đẹp, thoáng mát, có ban công, có cửa sổ","https://storage.googleapis.com/digital-platform/hinh_anh_nam_long_kinh_nghiem_thue_phong_tro_danh_cho_sinh_vien_so_1_ec29cfda91/hinh_anh_nam_long_kinh_nghiem_thue_phong_tro_danh_cho_sinh_vien_so_1_ec29cfda91.png",1);
            phongTroDB.insertPhong(30,3000000,"Phòng đẹp, thoáng mát, có ban công, có cửa sổ","https://mogi.vn/news/wp-content/uploads/2020/07/phongtrochothue0001.jpg",1);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://toancanhbatdongsan.com.vn/uploads/images/blog/hoangvy/2022/06/02/cho-thue-phong-tro-1654136735.jpeg",1);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://www.studytienganh.vn/upload/2021/06/106951.jpg",1);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://vanphongchothue.vn/uploads/noidung/images/phong%201.jpg",0);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://xaydungthuanphuoc.com/wp-content/uploads/2022/09/mau-phong-tro-co-gac-lung-dep2022-4.jpg",1);
            phongTroDB.insertPhong(30,3000000,"Phòng đẹp, thoáng mát, có ban công, có cửa sổ","https://mogi.vn/news/wp-content/uploads/2020/07/phongtrochothue0001.jpg",0);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://toancanhbatdongsan.com.vn/uploads/images/blog/hoangvy/2022/06/02/cho-thue-phong-tro-1654136735.jpeg",1);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://www.studytienganh.vn/upload/2021/06/106951.jpg",1);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://vanphongchothue.vn/uploads/noidung/images/phong%201.jpg",0);
            phongTroDB.insertPhong(32,3500000,"Phòng đẹp,full nội thất, rộng, thoáng mát, có ban công, có cửa sổ","https://xaydungthuanphuoc.com/wp-content/uploads/2022/09/mau-phong-tro-co-gac-lung-dep2022-4.jpg",1);
        }


        khachDB = new KhachDB(this);
        khachDB.createTableKhach();
        if(khachDB.countKhach() == 0){
            khachDB.insertKhach("Trịnh Kiết Tường",20,"Đắk Lắk", "0967402772","https://scontent.fsgn13-4.fna.fbcdn.net/v/t39.30808-6/335437924_925008325204554_7277823175007244788_n.jpg?_nc_cat=110&cb=99be929b-59f725be&ccb=1-7&_nc_sid=be3454&_nc_ohc=STF73WeG-UIAX-DCKWf&_nc_oc=AQkspI-v-wCovMaGLCKUqvhQFXwno0BbCxVO7XkVpbonwGawo8PVKxr7MJGNgiDxGiA&_nc_ht=scontent.fsgn13-4.fna&oh=00_AfDabWRqW4olnk2IWXqrLgqg175BclqTdz25aBAti5sSNw&oe=64D86E34");
            khachDB.insertKhach("Dương Văn Đức",20,"Biên Hòa, Đồng Nai", "0853535353","https://scontent.fsgn5-8.fna.fbcdn.net/v/t1.6435-9/118664749_392522491717471_3032720511942260065_n.jpg?_nc_cat=109&cb=99be929b-59f725be&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=AAMWG2oMJl4AX_Wgb8n&_nc_ht=scontent.fsgn5-8.fna&oh=00_AfDoMNSiTtMgK9aDSw-DmOf4IQqjZKkD6J9PyEyrdpcR5A&oe=64EEEEA4");
            khachDB.insertKhach("Lê Long Tân",20,"Nha Trang", "0912345678","https://scontent.fsgn13-2.fna.fbcdn.net/v/t1.6435-9/107564700_843298662864145_9042840666318385018_n.jpg?_nc_cat=109&cb=99be929b-59f725be&ccb=1-7&_nc_sid=174925&_nc_ohc=CWMZ2KmAIegAX_ElxDp&_nc_ht=scontent.fsgn13-2.fna&oh=00_AfCuXPje8kN_dEnthYCIiDEhHgwJSIaVcCFXGVpRmJHE8g&oe=64FBC069");
            khachDB.insertKhach("Nguyễn Hoàng Anh",20,"Tp.Hồ Chí Minh", "0987696969","https://scontent.fsgn4-1.fna.fbcdn.net/v/t39.30808-6/352305813_589080429873713_4330786141501844593_n.jpg?_nc_cat=105&cb=99be929b-59f725be&ccb=1-7&_nc_sid=be3454&_nc_ohc=dj1TazRZ2EUAX-mcWKK&_nc_ht=scontent.fsgn4-1.fna&oh=00_AfC3ATKIi65zi1J4e2iZmZYishl2_KzPhtdvcwOW70tvOQ&oe=64D8D0BF");
            khachDB.insertKhach("Phạm Công Thịnh",20,"Tp.Hồ Chí Minh", "0987654321","https://scontent.fsgn5-8.fna.fbcdn.net/v/t1.6435-9/118664749_392522491717471_3032720511942260065_n.jpg?_nc_cat=109&cb=99be929b-59f725be&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=AAMWG2oMJl4AX_Wgb8n&_nc_ht=scontent.fsgn5-8.fna&oh=00_AfDoMNSiTtMgK9aDSw-DmOf4IQqjZKkD6J9PyEyrdpcR5A&oe=64EEEEA4");
            khachDB.insertKhach("Spider Test",20,"XXXX","XXXXXX","https://scontent.fsgn13-2.fna.fbcdn.net/v/t39.30808-6/326520959_5745422032201522_8078326902348683559_n.jpg?_nc_cat=109&cb=99be929b-59f725be&ccb=1-7&_nc_sid=be3454&_nc_ohc=DT89lZd43SYAX-FYce4&_nc_ht=scontent.fsgn13-2.fna&oh=00_AfBldNjHjRPaoiyP3cEGJJK0on7K_5N52fVSM7Df0ZwJZg&oe=64DA2FBD");
        }

        thuePhongDB = new ThuePhongDB(this);
        thuePhongDB.createTableThuePhong();
        if(thuePhongDB.countThuePhong() == 0){
            thuePhongDB.insertThuePhong(1,1);
            thuePhongDB.insertThuePhong(1,2);
            thuePhongDB.insertThuePhong(2,3);
            thuePhongDB.insertThuePhong(3,4);
            thuePhongDB.insertThuePhong(4,5);
            thuePhongDB.insertThuePhong(5,7);
        }


        hoaDonDB = new HoaDonDB(this);
        hoaDonDB.createTableHoaDon();
        if(hoaDonDB.countHoaDon() == 0){
            hoaDonDB.insertHoaDon(1,"Trịnh Kiết Tường",312000,100000,3000000,3412000);
            hoaDonDB.insertHoaDon(2,"Trịnh Kiết Tường",450000,100000,3000000,3550000);
            hoaDonDB.insertHoaDon(3,"Dương Văn Đức",150000,100000,3000000,3250000);
        }



    }


}
