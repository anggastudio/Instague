package com.anggastudio.instague.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.anggastudio.instague.data.dao.PostDao;
import com.anggastudio.instague.data.db.PostDatabase;
import com.anggastudio.instague.data.model.Post;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PostRepository {

    private PostDao postDao;
    private ExecutorService executorService;

    public PostRepository(Application application) {
        PostDatabase db = PostDatabase.getPostDb(application);
        postDao = db.postDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Post post) {
        executorService.execute(() -> postDao.insert(post));
    }

    public void update(Post post) {
        executorService.execute(() -> postDao.update(post));
    }

    public void delete(Post post) {
        executorService.execute(() -> postDao.delete(post));
    }

    public LiveData<List<Post>> getAllPost() {
        return postDao.getAllPost();
    }
}
