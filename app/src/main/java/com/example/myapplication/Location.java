package com.example.myapplication;
import java.util.*;
import java.time.*;

public class Location {

    String _name;
    public boolean[] listForOpen = new boolean[140];
    public int[] listForBusy = new int[140];

    public Location(String name){
        _name = name;
    }

    public void adjustOpenSlot(int day, int hour, boolean isOpen){

        if (2 < hour && hour < 6){
            isOpen = false;
        }else{
            if (hour >= 2) {
                int slot = 20 * (day - 1) + hour - 4;
                listForOpen[slot] = isOpen;
            } else{
                int slot = 20 * (day - 1) + hour;
                listForOpen[slot] = isOpen;
            }
        }
    }

    public void adjustBusySlot(int n){
        Calendar now = Calendar.getInstance();  // current time
        int day = now.get(Calendar.DAY_OF_WEEK);
        int hour = now.get(Calendar.HOUR_OF_DAY);     // gets the current hour

        if (2 < hour && hour < 6){
            return;
        }else{
            if (hour >= 2) {
                int pos = 20 * (day - 1) + hour - 4;
                listForBusy[pos] = n;
            } else {
                int pos = 20 * (day - 1) + hour;
                listForBusy[pos] = n;
            }
        }
    }

    public String getName(){
        return _name;
    }

}
