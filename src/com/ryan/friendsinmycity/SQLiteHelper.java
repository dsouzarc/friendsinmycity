package com.ryan.friendsinmycity;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    
    private static final int DATABASE_VERSION = 1;
    
    private static final String DATABASE_NAME = "FBFriendsDB";
    private static final String TABLE_FRIENDS = "LIST_OF_FRIENDS";
    
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PROFILE_PHOTO_LINK = "profilePhotoLink";
    private static final String KEY_CITY = "city";
    
    public SQLiteHelper(final Context context) { 
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) { 
        final String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS +
                "(" + KEY_ID + " INTEGER PRIMARY KEY," + 
                KEY_NAME + " TEXT," + 
                KEY_PROFILE_PHOTO_LINK + " TEXT," + 
                KEY_CITY + " TEXT)";
        db.execSQL(CREATE_FRIENDS_TABLE);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);
        onCreate(db);
    }
    
    public void addFriend(final Friend theFriend) { 
        
    }
    
    
}
