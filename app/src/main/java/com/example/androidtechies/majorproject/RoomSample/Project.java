package com.example.androidtechies.majorproject.RoomSample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "project_table")
public class Project {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "branch")
    private String projectBranch;

    @ColumnInfo(name = "title_project")
    private String titleOfProject;

    @ColumnInfo(name = "intro_project")
    private String introOfProject;

    @ColumnInfo(name = "technology_used")
    private String technologyUsed;

    @ColumnInfo(name = "modules")
    private String modulesOfProject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectBranch() {
        return projectBranch;
    }

    public void setProjectBranch(String projectBranch) {
        this.projectBranch = projectBranch;
    }

    public String getTitleOfProject() {
        return titleOfProject;
    }

    public void setTitleOfProject(String titleOfProject) {
        this.titleOfProject = titleOfProject;
    }

    public String getIntroOfProject() {
        return introOfProject;
    }

    public void setIntroOfProject(String introOfProject) {
        this.introOfProject = introOfProject;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
    }

    public String getModulesOfProject() {
        return modulesOfProject;
    }

    public void setModulesOfProject(String modulesOfProject) {
        this.modulesOfProject = modulesOfProject;
    }
}
