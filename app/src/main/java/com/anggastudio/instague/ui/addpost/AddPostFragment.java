package com.anggastudio.instague.ui.addpost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.anggastudio.instague.R;

public class AddPostFragment extends Fragment {

    private AddPostViewModel addPostViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
