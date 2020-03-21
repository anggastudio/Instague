package com.anggastudio.instague.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.anggastudio.instague.data.model.Post;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Post post);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Iterable<Post> post);

    @Update
    void update(Post post);

    @Delete
    void delete(Post post);

    @Query("SELECT * FROM post ORDER BY id ASC")
    LiveData<List<Post>> getAllPost();
}
