package com.example.longyuan.customizedcontentprovidertest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by LONGYUAN on 2017/10/12.
 */

public class MyProvider extends ContentProvider {

    /*
 * Defines a handle to the database helper object. The MainDatabaseHelper class is defined
 * in a following snippet.
 */
    private MainDatabaseHelper mOpenHelper;

    // Defines the database name
    //private static final String DBNAME = "mydb";


    static final String DATABASE_NAME = "College";
    static final String STUDENTS_TABLE_NAME = "students";

    // Holds the database object
    private SQLiteDatabase db;


    // Creates a UriMatcher object.
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    static final String PROVIDER_NAME = "com.example.longyuan.customizedcontentprovidertest.provider";
    static final String URL = "content://" + PROVIDER_NAME + "/students";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String GRADE = "grade";

    static {
        /*
         * The calls to addURI() go here, for all of the content URI patterns that the provider
         * should recognize. For this snippet, only the calls for table 3 are shown.
         */

        /*
         * Sets the integer value for multiple rows in table 3 to 1. Notice that no wildcard is used
         * in the path
         */
        sUriMatcher.addURI(PROVIDER_NAME, "name", 1);

        /*
         * Sets the code for a single row to 2. In this case, the "#" wildcard is
         * used. "content://com.example.app.provider/table3/3" matches, but
         * "content://com.example.app.provider/table3 doesn't.
         */
        //sUriMatcher.addURI("com.example.longyuan.customizedcontentprovidertest.provider", "table3/#", 2);
    }



    @Override
    public boolean onCreate() {


        mOpenHelper = new MainDatabaseHelper(
                getContext()    // the application context
                           // the version number
        );

        return true;
    }

    @Override
    public Cursor query( Uri uri,
                         String[] projection,
                         String selection,
                         String[] selectionArgs,
                         String sortOrder) {

       // Cursor cursor = new Cu

        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }


    // A string that defines the SQL statement for creating a table
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + STUDENTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " grade TEXT NOT NULL);";

    /**
     * Helper class that actually creates and manages the provider's underlying data repository.
     */
    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {

        /*
         * Instantiates an open helper for the provider's SQLite data repository
         * Do not do database creation and upgrade here.
         */
        MainDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        /*
                 * Creates the data repository. This is called when the provider attempts to open the
                 * repository and SQLite reports that it doesn't exist.
                 */
        public void onCreate(SQLiteDatabase db) {

            // Creates the main table
            db.execSQL(CREATE_DB_TABLE);
        }
    }
}
