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
            int slot = 20 * (day-1) + hour - 4;
            listForOpen[slot] = isOpen;
        }
    }

    public boolean getOpenById(String id){
        String day = id.substring(0 , 1);
        int timeSlot = Integer.parseInt(id.substring(2));
        int slot = 0;
        int hours = 0;
        //
        if(day=="m"){
            slot+=20*2;
        }
        else if(day=="t"){
            slot+=20*3;
        }
        else if(day=="w"){
            slot+=20*4;
        }
        else if(day=="r"){
            slot+=20*5;
        }
        else if(day=="f"){
            slot+=20*6;
        }
        else if(day=="a"){
            slot+=20*7;
        }
        else if(day=="u"){
            slot+=20;
        }

        //hourslot
        if(timeSlot == 01){
            hours = 0;
        }
        else if(timeSlot == 12){
            hours = 1;
        }
        else if(timeSlot == 67){
            hours = 6;
        }
        else if(timeSlot == 78){
            hours = 7;
        }
        else if(timeSlot == 89){
            hours = 8;
        }
        else if(timeSlot == 910){
            hours = 9;
        }
        else if(timeSlot == 1011){
            hours = 10;
        }
        else if(timeSlot == 1112){
            hours = 11;
        }else if(timeSlot == 1213){
            hours = 12;
        }else if(timeSlot == 1314){
            hours = 13;
        }else if(timeSlot == 1415){
            hours = 14;
        }else if(timeSlot == 1516){
            hours = 15;
        }else if(timeSlot == 1617){
            hours = 16;
        }else if(timeSlot == 1718){
            hours = 17;
        }else if(timeSlot == 1819){
            hours = 18;
        }else if(timeSlot == 1920){
            hours = 19;
        }else if(timeSlot == 2021){
            hours = 20;
        }else if(timeSlot == 2122){
            hours = 21;
        }else if(timeSlot == 2223){
            hours = 22;
        }else if(timeSlot == 2324){
            hours = 23;
        }
        slot+=(hours-4);
        return listForOpen[slot];
    }

    public void adjustBusySlot(int n){
        Calendar now = Calendar.getInstance();  // current time
        int day = now.get(Calendar.DAY_OF_WEEK);
        int hour = now.get(Calendar.HOUR_OF_DAY);     // gets the current hour

        if (2 < hour && hour < 6){
            return;
        }else{
            if (n == 1 || n == 2 || n == 3){
                int slot = 20 * (day-1) + hour - 4;
                listForBusy[slot] = n;
            }
        }
    }

    public String getName(){
        return _name;
    }

}
