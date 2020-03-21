package com.anggastudio.instague.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anggastudio.instague.data.dao.PostDao;
import com.anggastudio.instague.data.model.Post;

@Database(entities = {Post.class}, version = 1, exportSchema = false)
public abstract class PostDatabase extends RoomDatabase {

    public abstract PostDao postDao();

    private static PostDatabase postDb;

    public static PostDatabase getPostDb(final Context context) {
        if (postDb == null) {
            postDb = Room.databaseBuilder(context.getApplicationContext(), PostDatabase.class, "post_database")
                    .build();
        }
        return postDb;
    }
}
