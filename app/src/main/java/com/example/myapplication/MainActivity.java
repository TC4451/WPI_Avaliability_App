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

    public Location cc = new Location("Rubin Campus Center");
    public Location library = new Location ("George C. Gordon Library");
    public Location sport_rec = new Location("WPI Sports & Recreation Center");


    public Location auditorium = new Location("Harrington Auditorium");
    public Location foisie = new Location("Innovation Studio");
    public Location careerCenter = new Location("WPI Career Development Center");
    public Location healthCenter = new Location("WPI Student Health Center");
    public Location daka = new Location("Morgan Dining Hall");
    public Location goatsHead = new Location("Goat's Head");
    public Location campusCenterFood = new Location ("Campus Center Food Court");

    RadioGroup radioGroup;
    RadioGroup radioGroupBusy;
    RadioButton radioButtonOpen;
    RadioButton radioButtonFree;
    RadioButton radioButtonMedium;
    RadioButton radioButtonBusy;
    String input = "";

    private EditText inputBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmLocationInputButton = (Button)findViewById(R.id.confirmInputButton);
        inputBox = (EditText) findViewById(R.id.input_Box);
        confirmLocationInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = inputBox.getText().toString();
                Toast.makeText(MainActivity.this, "Location Confirmed!", Toast.LENGTH_LONG).show();
            }
        });

        //to update open time
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_for_open);
        radioButtonOpen = (RadioButton) findViewById(R.id.radio_open);
        radioButtonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.equals(cc.getName().trim().toLowerCase())){
                    cc.adjustOpenSlot();
                }
                if (input.equals(library.getName().trim().toLowerCase())){
                    library.adjustOpenSlot();
                }
                if (input.equals(sport_rec.getName().trim().toLowerCase())){
                    sport_rec.adjustOpenSlot();
                }

            }
        });

        //to update busyness of location
        radioGroupBusy = (RadioGroup) findViewById(R.id.radio_group_for_busy);
        radioButtonFree = (RadioButton) findViewById(R.id.radio_free);
        radioButtonFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.equals(cc.getName().trim().toLowerCase())){
                    cc.adjustBusySlot(0);
                }
                if (input.equals(library.getName().trim().toLowerCase())){
                    library.adjustBusySlot(0);
                }
                if (input.equals(sport_rec.getName().trim().toLowerCase())){
                    sport_rec.adjustBusySlot(0);
                }
            }
        });

        radioButtonMedium = (RadioButton) findViewById(R.id.radio_medium);
        radioButtonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.equals(cc.getName().trim().toLowerCase())){
                    cc.adjustBusySlot(1);
                }
                if (input.equals(library.getName().trim().toLowerCase())){
                    library.adjustBusySlot(1);
                }
                if (input.equals(sport_rec.getName().trim().toLowerCase())){
                    sport_rec.adjustBusySlot(1);
                }
            }
        });

        radioButtonBusy = (RadioButton) findViewById(R.id.radio_busy);
        radioButtonBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.equals(cc.getName().trim().toLowerCase())){
                    cc.adjustBusySlot(2);
                }
                if (input.equals(library.getName().trim().toLowerCase())){
                    library.adjustBusySlot(2);
                }
                if (input.equals(sport_rec.getName().trim().toLowerCase())){
                    sport_rec.adjustBusySlot(2);
                }
            }
        });
    }
}