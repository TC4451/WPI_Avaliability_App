package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public Location cc = new Location("Campus Center");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Boolean isOpen = intent.getBooleanExtra("Open", false);
        int isBusy = intent.getIntExtra("Busy", 0);
        int day = intent.getIntExtra("Day", 1);
        int hour = intent.getIntExtra("Hour", 1);
        cc.adjustOpenSlot(day, hour, isOpen);
        //System.out.println("here: "+R.id.a_12);
        String timeId = "@+id/" + this.getTimeSlotIdByTime(day, hour);
        //tx.setBackgroundColor(255);
        //System.out.println("herehere: "+this.getTimeSlotIdByTime(day, hour));
        boolean test = true;
    }

    //
    public String getTimeSlotIdByTime(int day, int hour){
        String id = "";
        String[] weekLetters = {"u", "m", "t", "w", "r", "f", "a"};
        id+=(weekLetters[day-1]+"_");
        //finding hour inter
        if(hour >= 0 && hour < 1){
            id+= "01";
        }
        else if((hour >= 1) && (hour <= 2)){
            id+= "12";
        }else if((hour >= 6) && (hour < 7)){
            id+= "67";
        }else if((hour >= 7) && (hour < 8)){
            id+= "78";
        }else if((hour >= 8) && (hour < 9)){
            id+= "89";
        }else if((hour >= 9) && (hour < 10)){
            id+= "910";
        }else if((hour >= 10) && (hour < 11)){
            id+= "1011";
        }
        else if((hour >= 11) && (hour < 12)){
            id+= "1112";
        }else if((hour >= 12) && (hour < 13)){
            id+= "1213";
        }else if((hour >= 13) && (hour < 14)){
            id+= "1314";
        }else if( (hour >= 14) && (hour < 15)){
            id+= "1415";
        }else if((hour >= 15) && (hour < 16)){
            id+= "1516";
        }else if((hour >= 16) && (hour < 17)){
            id+= "1617";
        }else if((hour >= 17) && (hour < 18)){
            id+= "1718";
        }else if((hour >= 18) && (hour < 19)){
            id+= "1819";
        }else if((hour >= 19) && (hour < 20)){
            id+= "1920";
        }else if((hour >= 20) && (hour < 21)){
            id+= "2021";
        }else if((hour >= 21) && (hour < 22)){
            id+= "2122";
        }else if((hour >= 22) && (hour < 23)){
            id+= "2223";
        }else if((hour >= 23)){
            id+= "2324";
        }
        else{
            id+= "notValid";
        }

        return id;
    }
}