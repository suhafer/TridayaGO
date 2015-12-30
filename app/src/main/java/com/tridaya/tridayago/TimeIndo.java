package com.tridaya.tridayago;

/**
 * Created by Suhafer on 12/11/2015.
 */
public class TimeIndo {

    public TimeIndo(){

    }

    public String timeIndo(String a){
        if(a.equalsIgnoreCase("Western Indonesia Time")) {
            return "WIB";
        }
        else if (a.equalsIgnoreCase("Central Indonesia Time")) {
            return "WITA";
        }
        else if (a.equalsIgnoreCase("Eastern Indonesia Time")) {
            return "WIT";
        }
        if(a.equalsIgnoreCase("Waktu Indonesia Barat")) {
            return "WIB";
        }
        else if (a.equalsIgnoreCase("Waktu Indonesia Tengah")) {
            return "WITA";
        }
        else if (a.equalsIgnoreCase("Waktu Indonesia Timur")) {
            return "WIT";
        }
        else {
            return a;
        }
    }
}
