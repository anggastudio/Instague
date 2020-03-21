package com.anggastudio.instague.ui.home;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anggastudio.instague.R;
import com.anggastudio.instague.adapter.PostAdapter;
import com.anggastudio.instague.data.model.Post;
import com.anggastudio.instague.util.ViewModelFactory;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rvPostList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPostList = view.findViewById(R.id.rv_post_list);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            homeViewModel = obtainViewModel(getActivity().getApplication());
            observeViewModel();
        }
    }

    private void observeViewModel() {
        homeViewModel.getPost().observe(getViewLifecycleOwner(), this::setPostsToView);
    }

    private void setPostsToView(List<Post> posts) {
        rvPostList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPostList.setAdapter(new PostAdapter(posts));
    }

    @NonNull
    private HomeViewModel obtainViewModel(Application application) {
        ViewModelFactory factory = ViewModelFactory.getInstance(application);
        return factory.create(HomeViewModel.class);
    }
}
