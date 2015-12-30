package com.tridaya.tridayago;

import android.support.v4.app.FragmentTabHost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suhafer on 16/11/2015.
 */
public class ObjectTransfer implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> listItemTaskD = new ArrayList<String>();
    private List<String> listClockTaskD = new ArrayList<String>();
    private List<String> listCategoryTaskD = new ArrayList<String>();
    private List<String> listItemNotif = new ArrayList<String>();
    private List<String> listClockNotif = new ArrayList<String>();
    private List<String> listItemReportD = new ArrayList<String>();
    private List<String> listClockReportD = new ArrayList<String>();
    private List<String> listItemReportS = new ArrayList<String>();
    private List<String> listItemRequest = new ArrayList<String>();


    private String result;
    private List<String> listItemSearch = new ArrayList<String>();

    private int[] exImageRequest = {
            R.drawable.button_atk,
            R.drawable.button_garden,
            R.drawable.button_brt,
            R.drawable.button_pantry,
            R.drawable.button_cleaningservice,
            R.drawable.button_chemical
    };

    private String[] dummyPerson = new String[] {
            "Abdul Angga Ajah",
            "456321789",
            "Cleaning Service"
    };
    private int[] dummyBackground = {
            R.drawable.example_1,
            R.drawable.contohimage_4,
            R.drawable.contohimage_5
    };

    private String detailTaskNotes = "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.";

    private String notesReport = "Lorem Ipsum adalah contoh teks atau dummy " +
            "dalam industri percetakan dan penataan huruf atau typesetting. " +
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an,";

    private String[] dummyNotif = new String[] {
            "Lorem Ipsum adalah contoh teks atau dummy dalam industri percetakan dan penataan huruf atau typesetting.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun.",
            "Lorem Ipsum telah menjadi standar contoh teks sejak tahun 1500an, saat seorang tukang cetak yang tidak dikenal mengambil sebuah kumpulan teks dan mengacaknya untuk menjadi sebuah buku contoh huruf.",
            "Ia tidak hanya bertahan selama 5 abad, tapi juga telah beralih ke penataan huruf elektronik, tanpa ada perubahan apapun."
    };

    private String checkInDate,checkInClock;

    private int mark = 0;

    public ObjectTransfer () {
        itemListD();
        clockListD();
        categoryListD();
        notifList();
        clockListNotif();
        reportListD();
        clockListReportD();
        requestList();
    }

    private void itemListD() {
        String[] values = new String[] {
                "Bersihkan Ruang Rapat",
                "Bersihkan Ruang Makan",
                "Bersihkan Toilet Lantai 3",
                "Bersihkan Ruang HRD",
                "Bersihkan Ruang Technical Support",
                "Bersihkan Toilet Lantai 5",
                "Sapu Lantai 7",
                "Bersihkan Ruang Admininstrasi",
                "Bersihkan Gudang",
                "Bersihkan Ruang Admininstrasi",
                "Bersihkan Gudang",
                "Bersihkan Lobby",
                "Bersihkan Ruang Admininstrasi",
                "Bersihkan Gudang",
                "Bersihkan Lobby"
        };

        for(int i=0;i<values.length;i++) {
            listItemTaskD.add(values[i]);
        }
    }

    private void clockListD() {
        String[] values = new String[] {
                "08:00",
                "08:15",
                "09:20",
                "10:00",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet",
                "Not yet"
        };

        for(int i=0;i<values.length;i++) {
            listClockTaskD.add(values[i]);
        }
    }

    private void categoryListD() {
        String[] values = new String[] {
                "Gardening",
                "ATK",
                "CCTV",
                "Gardening",
                "ATK",
                "CCTV",
                "Gardening",
                "ATK",
                "CCTV",
                "Gardening",
                "ATK",
                "CCTV",
                "Gardening",
                "ATK",
                "CCTV"
        };

        for(int i=0;i<values.length;i++) {
            listCategoryTaskD.add(values[i]);
        }
    }

    private void notifList() {
        String[] values = new String[] {
                "Admin",
                "Beng",
                "Asda",
                "Hupo",
                "Hupo",
                "Hupo",
                "Hupo",
                "Admin",
                "Admin",
                "Admin",
                "Hupo",
                "Hupo",
                "Kila`"
        };

        for(int i=0;i<values.length;i++) {
            listItemNotif.add(values[i]);
        }
    }

    private void clockListNotif() {
        String[] values = new String[] {
                "08:00",
                "08:15",
                "09:20",
                "10:00",
                "11:00",
                "12:15",
                "13:20",
                "14:00",
                "15:00",
                "16:15",
                "17:20",
                "18:00",
                "18:50"
        };

        for(int i=0;i<values.length;i++) {
            listClockNotif.add(values[i]);
        }
    }

    private void reportListD() {
        String[] values = new String[] {
                "Bersihkan Ruang Admininstrasi",
                "Bersihkan Gudang",
                "Bersihkan Ruang Admininstrasi",
                "Bersihkan Gudang",
                "Bersihkan Lobby"
        };

        for(int i=0;i<values.length;i++) {
            listItemReportD.add(values[i]);
        }
    }

    private void clockListReportD() {
        String[] values = new String[] {
                "08:00",
                "08:15",
                "08:15",
                "09:40",
                "10:20"
        };

        for(int i=0;i<values.length;i++) {
            listClockReportD.add(values[i]);
        }
    }

    private void requestList() {
        String[] values = new String[] {
                "BAS",
                "CCTV",
                "BRT",
                "Pantry",
                "Cleaning Service",
                "Chemical"
        };

        for(int i=0;i<values.length;i++) {
            listItemRequest.add(values[i]);
        }
    }

    public void setSortItem (String a) {
        String b = "not found";
        for(int i=0;i< listItemNotif.size();i++) {
            if (a.equalsIgnoreCase(listItemNotif.get(i))) {
                //b = listItemNotif.get(i);
                listItemSearch.add(listItemNotif.get(i));
                result = "found";
            }
            else {
                result = b;
            }
        }
    }

    public void setMark (int a) {
        mark = a;
    }

    public void setCheckInDate (String a) {
        this.checkInDate = a;
    }

    public void setCheckInClock (String a) {
        this.checkInClock = a;
    }

    public int getMark () {
        return mark;
    }

    public String getResult () {
        return result;
    }

    public String getCheckInDate () {
        return this.checkInDate;
    }

    public String getCheckInClock () {
        return this.checkInClock;
    }

    public List<String> getListItemTaskD () {
        return listItemTaskD;
    }

    public List<String> getListClockTaskD () {
        return listClockTaskD;
    }

    public List<String> getListCategoryTaskD () {
        return listCategoryTaskD;
    }

    public List<String> getListItemNotif () {
        return listItemNotif;
    }

    public List<String> getListClockNotif () {
        return listClockNotif;
    }

    public List<String> getListItemReportD () {
        return listItemReportD;
    }

    public List<String> getListClockReportD () {
        return listClockReportD;
    }

    public List<String> getListItemRequest () {
        return listItemRequest;
    }

    public List<String> getListItemSearch () {
        return listItemSearch;
    }

    public String[] getDummyPerson () {
        return dummyPerson;
    }

    public String[] getDummyNotif () {
        return dummyNotif;
    }

    public int getExImageRequest (int position) {
        return exImageRequest[position];
    }

    public int getDummyBackground (int position) {
        return dummyBackground[position];
    }

    public String getDetailTaskNotes () {
        return detailTaskNotes;
    }
}
