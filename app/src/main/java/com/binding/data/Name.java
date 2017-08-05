package com.binding.data;

import android.database.Cursor;

import static com.binding.data.DatabaseContract.*;
import static com.binding.data.DatabaseContract.getColumnInt;
import static com.binding.data.DatabaseContract.getColumnLong;
import static com.binding.data.DatabaseContract.getColumnString;

/**
 * Helpful data model for holding attributes related to a task.
 */
public class Name {

    /* Constants representing missing data */
    public static final long NO_DATE = Long.MAX_VALUE;
    public static final long NO_ID = -1;

    //Unique identifier in database
    public long id;
    //Name name
    public final String name;
    //Marked if task is done
    public final int isDelete;


    /**
     * Create a new Name from discrete items
     */
    public Name(String name, int isDelete) {
        this.id = NO_ID; //Not set
        this.name = name;
        this.isDelete = isDelete;

    }

    /**
     * Create a new task from a database Cursor
     */
    public Name(Cursor cursor) {
        this.id = getColumnLong(cursor, TaskColumns._ID);
        this.name = getColumnString(cursor, TaskColumns.NAME);
        this.isDelete = getColumnInt(cursor, TaskColumns.IS_DELETE);

    }



}
