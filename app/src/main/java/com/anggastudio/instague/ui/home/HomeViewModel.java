package com.anggastudio.instague.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anggastudio.instague.data.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    public HomeViewModel() {
    }

    public LiveData<List<Post>> getPost() {
        MutableLiveData<List<Post>> ldPostList = new MutableLiveData<>();
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setUsername("anggastudiocademy");
        post.setAvatarPath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setImagePath("https://anggastudio.dev/assets/img/anggapratama.jpg");
        post.setCaption("ini postingan pertama gue, udah mah pertama, dummy lagi");
        postList.add(post);
        postList.add(post);
        postList.add(post);
        ldPostList.setValue(postList);
        return ldPostList;
    }
}