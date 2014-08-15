package com.ryan.friendsinmycity;

import java.util.ArrayList;
import java.util.LinkedList;
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

        final ContentValues theValues = new ContentValues();
        theValues.put(KEY_ID, theFriend.getId());
        theValues.put(KEY_NAME, theFriend.getName());
        theValues.put(KEY_PROFILE_PHOTO_LINK, theFriend.getProfilePhotoLink());
        theValues.put(KEY_CITY, theFriend.getLastCity());
        
        final SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_FRIENDS, null, theValues);
        db.close();
    }
    
    public Friend getFriend(final int ID) { 
        
        final String[] theVals = {KEY_ID, KEY_NAME, KEY_PROFILE_PHOTO_LINK, KEY_CITY};
        
        final SQLiteDatabase db = this.getReadableDatabase();
        
        final Cursor theCursor = db.query(TABLE_FRIENDS, theVals, KEY_ID + "=?", 
                new String[] {String.valueOf(ID)}, null, null, null, null);
        
        if(theCursor != null) { 
            theCursor.moveToFirst();
        }
        
        final Friend theFriend = new Friend(Integer.parseInt(theCursor.getString(0)),
                theCursor.getString(1), theCursor.getString(2), theCursor.getString(3));
        return theFriend;
    }
    
    public ArrayList<Friend> getAllFriendsList() { 
        return new ArrayList<Friend>(getAllFriends());
    }
    
    public Friend[] getAllFriendsArray() { 
        final List<Friend> friends = getAllFriends();
        return friends.toArray(new Friend[friends.size()]);
    }
    
    private List<Friend> getAllFriends() { 
        final LinkedList<Friend> theFriends = new LinkedList<Friend>();
        
        final String query = "SELECT * FROM " + TABLE_FRIENDS;
        final SQLiteDatabase db = this.getWritableDatabase();
        final Cursor cursor = db.rawQuery(query, null);
        
        if(cursor.moveToFirst()) { 
            do { 
                final int ID = Integer.parseInt(cursor.getString(0));
                final String name = cursor.getString(1);
                final String profLink = cursor.getString(2);
                final String city = cursor.getString(3);
                theFriends.add(new Friend(ID, name, profLink, city));
            } while(cursor.moveToNext());
        }
        return theFriends;
    }
    
    public void updateFriend(final Friend oldFriend, final Friend newFriend) { 
        final SQLiteDatabase db = this.getWritableDatabase();
        final ContentValues values = new ContentValues();
        values.put(KEY_CITY, oldFriend.getLastCity());
        
        db.update(TABLE_FRIENDS, values, KEY_ID + " = ?", new String[] {String.valueOf(oldFriend.getId())});
        db.close();
    }
    
    public void deleteFriend(final Friend formerFriend) { 
       final SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_FRIENDS, KEY_ID + " = ?", new String[] {String.valueOf(formerFriend.getId())});
    }
    
    public int getFriendsCount() { 
        final String query = "SELECT * FROM " + TABLE_FRIENDS;
        final SQLiteDatabase db = this.getReadableDatabase();
        final Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        return cursor.getCount();
    }
}
