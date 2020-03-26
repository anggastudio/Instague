package com.anggastudio.instague.ui.addpost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anggastudio.instague.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AddPostFragment extends Fragment {

    private AddPostViewModel addPostViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivAvatar = view.findViewById(R.id.iv_post_owner_avatar);
        Glide.with(this)
                .load("https://anggastudio.dev/assets/img/anggapratama.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(ivAvatar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity() != null){
            addPostViewModel = new ViewModelProvider(this).get(AddPostViewModel.class);
            observeViewModel();
        }
    }

    private void observeViewModel() {
        addPostViewModel.getText().observe(getViewLifecycleOwner(), s -> {
        });
    }
}
