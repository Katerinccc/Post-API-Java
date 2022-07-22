package com.sofkaU.PostApp.services.interfaces;

import com.sofkaU.PostApp.entity.Comment;
import com.sofkaU.PostApp.entity.Post;
import java.util.List;

public interface IPostService {

    Post createPost(Post post);

    Post createComment(Comment comment);

    void deleteComment(Comment comment);

    void deletePost(Post post);

    List<Post> findAllPosts();

}
