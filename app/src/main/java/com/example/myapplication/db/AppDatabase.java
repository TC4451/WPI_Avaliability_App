package com.example.myapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.*;
import androidx.room.migration.AutoMigrationSpec;

import android.content.*;


@Database(entities = {LocationEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract  LocationDao locationDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDBInstance;
    public static AppDatabase getDBInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "loc_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }




}
