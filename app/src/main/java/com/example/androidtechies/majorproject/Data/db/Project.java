package com.example.androidtechies.majorproject.Data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "project_table")
public class Project implements Parcelable {

    @NonNull
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

    @ColumnInfo(name = "modules_used")
    private String modulesOfProject;


    public Project(String projectBranch, String titleOfProject, String introOfProject, String technologyUsed, String modulesOfProject) {
        this.projectBranch = projectBranch;
        this.titleOfProject = titleOfProject;
        this.introOfProject = introOfProject;
        this.technologyUsed = technologyUsed;
        this.modulesOfProject = modulesOfProject;
    }

    /*
    Getters and Setters
     */

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

    /*
        parcellable functions
     */

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(titleOfProject);
        parcel.writeString(introOfProject);
        parcel.writeString(technologyUsed);
        parcel.writeString(modulesOfProject);
    }

    protected Project(Parcel in) {
        titleOfProject = in.readString();
        introOfProject = in.readString();
        technologyUsed = in.readString();
        modulesOfProject = in.readString();
    }

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[0];
        }
    };
}
