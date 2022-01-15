package com.example.myapplication.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {

    @Query("SELECT * FROM locationentity")
    List<LocationEntity> getAllLocation();

    @Insert
    void insertLocation(LocationEntity... locations);

    @Delete
    void delete(LocationEntity location);
}
