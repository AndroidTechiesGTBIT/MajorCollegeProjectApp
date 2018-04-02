package com.example.androidtechies.majorproject.Data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT COUNT(*) from project_table")
    int countProjects();

    @Insert
    void insertAll(Project... users);

    @Delete
    void delete(Project user);

    @Query("SELECT * FROM project_table where branch = :branchName ")
    List<Project> getBranchAllData(String branchName);


}
