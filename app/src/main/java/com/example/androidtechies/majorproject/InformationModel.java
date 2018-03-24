package com.example.androidtechies.majorproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TANSU on 22/03/2018.
 */

public class InformationModel implements Parcelable {
    String titleOfProject;
    String introProject;
    String technologyUsed;

    public InformationModel(String titleOfProject, String introProject, String technologyUsed) {
        this.titleOfProject = titleOfProject;
        this.introProject = introProject;
        this.technologyUsed = technologyUsed;
    }

    public String getTitleOfProject() {
        return titleOfProject;
    }

    public void setTitleOfProject(String titleOfProject) {
        this.titleOfProject = titleOfProject;
    }

    public String getIntroProject() {
        return introProject;
    }

    public void setIntroProject(String introProject) {
        this.introProject = introProject;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titleOfProject);
        parcel.writeString(introProject);
        parcel.writeString(technologyUsed);
    }

    protected InformationModel(Parcel in) {
        titleOfProject = in.readString();
        introProject = in.readString();
        technologyUsed = in.readString();
    }

    public static final Creator<InformationModel> CREATOR = new Creator<InformationModel>() {
        @Override
        public InformationModel createFromParcel(Parcel in) {
            return new InformationModel(in);
        }

        @Override
        public InformationModel[] newArray(int size) {
            return new InformationModel[size];
        }
    };

}
