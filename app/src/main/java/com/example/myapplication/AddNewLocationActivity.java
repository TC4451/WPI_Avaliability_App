package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.db.AppDatabase;
import com.example.myapplication.db.LocationEntity;

public class AddNewLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_location);

        EditText locationInput = findViewById(R.id.locationInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveNewUser(locationInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String loc){
        AppDatabase db = AppDatabase.getDBInstance(this.getApplicationContext());

        LocationEntity location = new LocationEntity();
        location.locName = loc;
        db.locationDao().insertLocation(location);
    }
}