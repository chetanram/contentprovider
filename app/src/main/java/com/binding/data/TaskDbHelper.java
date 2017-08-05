package com.binding.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.binding.data.DatabaseContract.TaskColumns;

public class TaskDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "names.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_NAME = String.format("create table %s"
                    + " (%s integer primary key autoincrement, %s text, %s integer)",
            DatabaseContract.TABLE_NAME,
            TaskColumns._ID,
            TaskColumns.NAME,
            TaskColumns.IS_DELETE
    );

    public TaskDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DatabaseContract.TABLE_NAME);

        onCreate(db);
    }
}
