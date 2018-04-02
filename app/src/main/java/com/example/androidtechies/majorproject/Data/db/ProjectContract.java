package com.example.androidtechies.majorproject.Data.db;

import android.provider.BaseColumns;

public class ProjectContract {

    public static final class ProjectEntry implements BaseColumns {
        public static final String TABLE_NAME = "project_table";
        public static final String COLUMN_BRANCH = "branch";
        public static final String COLUMN_PROJECT_TITLE = "title_project";
        public static final String COLUMN_PROJECT_INTRO = "intro_project";
        public static final String COLUMN_TECH_USED = "technology_used";
        public static final String COLUMN_MODULES_USED = "modules_used";
    }
}
