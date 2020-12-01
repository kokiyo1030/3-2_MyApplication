package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class EWProvider extends ContentProvider {
    static final Uri CONTENT_URI =
            Uri.parse("content://com.example.myapplication/word");
    SQLiteDatabase mDB;
    static final int ALLWORD = 1;
    static final int ONEWORD = 2;
    static final UriMatcher Matcher;
    static {
        Matcher = new UriMatcher(UriMatcher.NO_MATCH);
        Matcher.addURI("com.example.myapplication", "word", ALLWORD);
        Matcher.addURI("com.example.myapplication", "word/*", ONEWORD);
    }
    public EWProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        int count = 0;
        switch (Matcher.match(uri)) {
            case ALLWORD:
                count = mDB.delete("dic", selection, selectionArgs);
                break;
            case ONEWORD:
                String where;
                where = "eng = '" + uri.getPathSegments().get(1) + "'";
                if (TextUtils.isEmpty(selection) == false) {
                    where += " AND" + selection;
                }
                count = mDB.delete("dic", where, selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long row = mDB.insert("dic", null, values);
        if (row > 0) {
            Uri notiuri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(notiuri, null);
            return notiuri;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        WordDBHelper helper = new WordDBHelper(getContext());
        mDB = helper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        String sql = "SELECT eng, han FROM dic";
        if (Matcher.match(uri) == ONEWORD) {
            sql += " where eng = '" + uri.getPathSegments().get(1) + "'";
        }
        Cursor cursor = mDB.rawQuery(sql, null);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        int count = 0;
        switch (Matcher.match(uri)) {
            case ALLWORD:
                count = mDB.update("dic", values, selection, selectionArgs);
                break;
            case ONEWORD:
                String where;
                where = "eng = '" + uri.getPathSegments().get(1) + "'";
                if (TextUtils.isEmpty(selection) == false) {
                    where += " AND " + selection;
                }
                count = mDB.update("dic", values, where, selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}