package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Location cc = (Location) intent.getParcelableExtra("loc");
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        System.out.println("Day: "+ day);
        System.out.println("Hour: "+ hour);
        boolean isOpen = intent.getBooleanExtra("Open", true);
        int slotId = this.getId(this.getSlotIdByTime(day, hour));
        System.out.println("here: "+this.getSlotIdByTime(day, hour));

        if(isOpen){
            System.out.println("isOpen "+isOpen);
            findViewById(slotId).setBackgroundColor(getResources().getColor(R.color.green));
        }
        else{
            System.out.println("isOpen "+isOpen);
            findViewById(slotId).setBackgroundColor(getResources().getColor(R.color.white));
        }

        //tx.setBackgroundColor(255);
        //System.out.println("herehere: "+this.getTimeSlotIdByTime(day, hour));
        Button back = findViewById(R.id.goBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMain = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(goToMain);
            }
        });



    }

    //produces a string id for the
    public String getSlotIdByTime(int day, int hour){
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


    //finds the correct id from a given string id
    public int getId(String strId){
        int id=0;
        if(strId.equals("m_01")){
            id=R.id.m_01;
        }
        else if(strId.equals("t_01")){
            id=R.id.t_01;
        }
        else if(strId.equals("w_01")){
            id=R.id.w_01;
        }
        else if(strId.equals("r_01")){
            id=R.id.r_01;
        }
        else if(strId.equals("f_01")){
            id=R.id.f_01;
        }
        else if(strId.equals("a_01")){
            id=R.id.a_01;
        }
        else if(strId.equals("u_01")){
            id=R.id.u_01;
        }
        else if(strId.equals("m_12")){
            id=R.id.m_12;
        }
        else if(strId.equals("t_12")){
            id=R.id.t_12;
        }
        else if(strId.equals("w_12")){
            id=R.id.w_12;
        }
        else if(strId.equals("r_12")){
            id=R.id.r_12;
        }
        else if(strId.equals("f_12")){
            id=R.id.f_12;
        }
        else if(strId.equals("a_12")){
            id=R.id.a_12;
        }
        else if(strId.equals("u_12")){
            id=R.id.u_12;
        }
        else if(strId.equals("m_67")){
            id=R.id.m_67;
        }
        else if(strId.equals("t_67")){
            id=R.id.t_67;
        }
        else if(strId.equals("w_67")){
            id=R.id.w_67;
        }
        else if(strId.equals("r_67")){
            id=R.id.r_67;
        }
        else if(strId.equals("f_67")){
            id=R.id.f_67;
        }
        else if(strId.equals("a_67")){
            id=R.id.a_67;
        }
        else if(strId.equals("u_67")){
            id=R.id.u_67;
        }
        else if(strId.equals("m_78")){
            id=R.id.m_78;
        }
        else if(strId.equals("t_78")){
            id=R.id.t_78;
        }
        else if(strId.equals("w_78")){
            id=R.id.w_78;
        }
        else if(strId.equals("r_78")){
            id=R.id.r_78;
        }
        else if(strId.equals("f_78")){
            id=R.id.f_78;
        }
        else if(strId.equals("a_78")){
            id=R.id.a_78;
        }
        else if(strId.equals("u_78")){
            id=R.id.u_78;
        }
        else if(strId.equals("m_89")){
            id=R.id.m_89;
        }
        else if(strId.equals("t_89")){
            id=R.id.t_89;
        }
        else if(strId.equals("w_89")){
            id=R.id.w_89;
        }
        else if(strId.equals("r_89")){
            id=R.id.r_89;
        }
        else if(strId.equals("f_89")){
            id=R.id.f_89;
        }
        else if(strId.equals("a_89")){
            id=R.id.a_89;
        }
        else if(strId.equals("u_89")){
            id=R.id.u_89;
        }
        else if(strId.equals("m_910")){
            id=R.id.m_910;
        }
        else if(strId.equals("t_910")){
            id=R.id.t_910;
        }
        else if(strId.equals("w_910")){
            id=R.id.w_910;
        }
        else if(strId.equals("r_910")){
            id=R.id.r_910;
        }
        else if(strId.equals("f_910")){
            id=R.id.f_910;
        }
        else if(strId.equals("a_910")){
            id=R.id.a_910;
        }
        else if(strId.equals("u_910")){
            id=R.id.u_910;
        }
        else if(strId.equals("m_1011")){
            id=R.id.m_1011;
        }
        else if(strId.equals("t_1011")){
            id=R.id.t_1011;
        }
        else if(strId.equals("w_1011")){
            id=R.id.w_1011;
        }
        else if(strId.equals("r_1011")){
            id=R.id.r_1011;
        }
        else if(strId.equals("f_1011")){
            id=R.id.f_1011;
        }
        else if(strId.equals("a_1011")){
            id=R.id.a_1011;
        }
        else if(strId.equals("u_1011")){
            id=R.id.u_1011;
        }
        else{
            id=0;
        }

        return id;

    }

}