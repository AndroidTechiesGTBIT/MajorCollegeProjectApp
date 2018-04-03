package com.example.androidtechies.majorproject.Data;


import android.os.Parcel;
import android.os.Parcelable;

public class ProjectModel implements Parcelable {

        private String projectBranch;
        private String titleOfProject;
        private String introOfProject;
        private String technologyUsed;
        private String modulesOfProject;


        public ProjectModel(String projectBranch, String titleOfProject, String introOfProject, String technologyUsed, String modulesOfProject) {
            this.projectBranch = projectBranch;
            this.titleOfProject = titleOfProject;
            this.introOfProject = introOfProject;
            this.technologyUsed = technologyUsed;
            this.modulesOfProject = modulesOfProject;
        }

    /*
    Getters and Setters
     */
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

        protected ProjectModel(Parcel in) {
            titleOfProject = in.readString();
            introOfProject = in.readString();
            technologyUsed = in.readString();
            modulesOfProject = in.readString();
        }

        public static final Parcelable.Creator<ProjectModel> CREATOR = new Parcelable.Creator<ProjectModel>() {
            @Override
            public ProjectModel createFromParcel(Parcel in) {
                return new ProjectModel(in);
            }

            @Override
            public ProjectModel[] newArray(int size) {
                return new ProjectModel[0];
            }
        };
    }
