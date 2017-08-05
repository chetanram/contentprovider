package com.binding.data;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    //Database schema information
    public static final String TABLE_NAME = "tbl_name";

    public static final class TaskColumns implements BaseColumns {

        public static final String _ID = BaseColumns._ID;
        //Name name
        public static final String NAME = "NAME";

        //Completed marker
        public static final String IS_DELETE = "is_delete";
    }

    //Unique authority string for the content provider
    public static final String CONTENT_AUTHORITY = "com.binding";

   //Base content Uri for accessing the provider
    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(CONTENT_AUTHORITY)
            .appendPath(TABLE_NAME)
            .build();


    /* Helpers to retrieve column values */
    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString( cursor.getColumnIndex(columnName) );
    }
    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt( cursor.getColumnIndex(columnName) );
    }
    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong( cursor.getColumnIndex(columnName) );
    }
}
