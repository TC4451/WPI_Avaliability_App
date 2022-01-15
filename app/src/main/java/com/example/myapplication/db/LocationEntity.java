package com.example.myapplication.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "location_database")
public class LocationEntity {

    @PrimaryKey
    public int lid;

    @ColumnInfo(name = "location_name")
    public String locName;

}
