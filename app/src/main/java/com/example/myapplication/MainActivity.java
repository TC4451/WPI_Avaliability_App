package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public Location cc = new Location("Campus Center");
    public Location library = new Location ("Gordon Library");
    public Location sport_rec = new Location("WPI Sports & Recreation Center");

    RadioGroup radioGroup;
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
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = (RadioButton) findViewById(radioId);

        //Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();

        if (radioButton.getText().equals("Open")){
            Toast.makeText(this, "is open", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, "is closed", Toast.LENGTH_SHORT);
        }
    }

    public void onRadioButtonClickedBusy(View view) {

        int radioIdBusy = radioGroupBusy.getCheckedRadioButtonId();

        radioButtonBusy = (RadioButton) findViewById(radioIdBusy);

        /*
        if (radioButtonBusy.getText().equals("Not Too Busy")) {
            if (input.equals(cc.getName().toLowerCase(Locale.ROOT).trim())) {
                cc.adjustBusySlot(1);
            }
        } else if (radioButtonBusy.getText().equals("Little Busy")) {
            if (input.equals(cc.getName().toLowerCase(Locale.ROOT).trim())) {
                cc.adjustBusySlot(2);
            }
        } else {
            if (input.equals(cc.getName().toLowerCase(Locale.ROOT).trim())) {
                cc.adjustBusySlot(3);
            }
        }
        */
    }
}