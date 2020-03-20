package com.anggastudio.instague.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.anggastudio.instague.R;
import com.anggastudio.instague.data.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Holder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Post post = posts.get(position);
        holder.tvUsername.setText(post.getUsername());
        String captionDisplay = getCaptionDisplay(post);
        holder.tvCaption.setText(HtmlCompat.fromHtml(captionDisplay, HtmlCompat.FROM_HTML_MODE_COMPACT));

    }

    private String getCaptionDisplay(Post post) {
        return "<b>" + post.getUsername() + "</b>" + " " + post.getCaption();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvUsername;
        TextView tvCaption;
        ImageView ivAvatar;
        ImageView ivPostImage;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.post_owner_username);
            tvCaption = itemView.findViewById(R.id.post_caption);
            ivAvatar = itemView.findViewById(R.id.post_owner_avatar);
            ivPostImage = itemView.findViewById(R.id.post_image);
        }
    }
}
