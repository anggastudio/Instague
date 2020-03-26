package com.anggastudio.instague.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.anggastudio.instague.data.model.Post;
import com.anggastudio.instague.data.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    PostRepository postRepository;

    public HomeViewModel(Application application) {
        postRepository = new PostRepository(application);
//        postRepository.insert(getMockList());
    }

    public LiveData<List<Post>> getPost() {
        return postRepository.getAllPost();
    }

    private List<Post> getMockList() {
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setUsername("anggastudiocademy");
        post.setAvatarPath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setImagePath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setCaption("ini postingan pertama gue, udah mah pertama, dummy lagi");
        postList.add(post);
        postList.add(post);
        postList.add(post);
        return postList;
    }

    private Post getMock() {
        Post post = new Post();
        post.setUsername("anggastudiocademy");
        post.setAvatarPath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setImagePath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setCaption("ini postingan pertama gue, udah mah pertama, dummy lagi");
        return post;
    }
}