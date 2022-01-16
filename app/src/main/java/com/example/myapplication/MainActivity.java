package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ArrayList<Location> locationEntries = new ArrayList<Location>();

    RadioGroup radioGroup;

    Boolean isOpen;
    int isBusy;

    RadioGroup radioGroupBusy;
    RadioButton radioButton;
    RadioButton radioButtonBusy;
    String input;

    private EditText inputBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group_for_open);
        radioGroupBusy = (RadioGroup) findViewById(R.id.radio_group_for_busy);

        View here = new View(this);
        onRadioButtonClicked(here);
        onRadioButtonClickedBusy(here);

        Button confirmLocationInputButton = (Button)findViewById(R.id.confirmInputButton);
        inputBox = (EditText) findViewById(R.id.input_Box);
        confirmLocationInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = inputBox.getText().toString();
                Toast.makeText(MainActivity.this, "Availability added!", Toast.LENGTH_LONG).show();
                Intent timeTable = new Intent(MainActivity.this, SecondActivity.class);
                int day = Calendar.getInstance().DAY_OF_WEEK;
                int time = Calendar.getInstance().HOUR;
                timeTable.putExtra("Busy", isBusy);
                timeTable.putExtra("Open", isOpen);
                timeTable.putExtra("Day", day);
                timeTable.putExtra("Hour", time);
                startActivity(timeTable);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = (RadioButton) findViewById(radioId);

        //Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();

        if (radioButton.getText().equals("Open")){
            Toast.makeText(this, "is open", Toast.LENGTH_SHORT);
            isOpen = true;
        } else {
            Toast.makeText(this, "is closed", Toast.LENGTH_SHORT);
            isOpen = false;
        }
    }

    public void onRadioButtonClickedBusy(View view) {

        int radioIdBusy = radioGroupBusy.getCheckedRadioButtonId();

        radioButtonBusy = (RadioButton) findViewById(radioIdBusy);


        if (radioButtonBusy.getText().equals("Not Too Busy")) {
            isBusy = 0;
        } else if (radioButtonBusy.getText().equals("Little Busy")) {
            isBusy = 1;
        } else {
            isBusy = 2;
        }

    }


}