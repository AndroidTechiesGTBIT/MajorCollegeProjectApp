package com.example.androidtechies.majorproject.RoomSample;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM project_table")
    List<Project> getAll();


    @Query("SELECT COUNT(*) from project_table")
    int countProjects();

    @Insert
    void insertAll(Project... users);

    @Delete
    void delete(Project user);

}
