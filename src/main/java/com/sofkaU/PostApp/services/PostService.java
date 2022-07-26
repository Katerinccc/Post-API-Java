package com.sofkaU.PostApp.services;

import com.sofkaU.PostApp.entity.Comment;
import com.sofkaU.PostApp.entity.Post;
import com.sofkaU.PostApp.repository.CommentRepository;
import com.sofkaU.PostApp.repository.PostRepository;
import com.sofkaU.PostApp.services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post createComment(Comment comment) {
        Post post = postRepository.findById(comment.getFkPostId()).get();
        post.addComment(comment);
        commentRepository.save(comment);
        return postRepository.save(post);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deletePost(Long id) {
        Post currentPost = postRepository.findById(id).get();
        if (!currentPost.getComments().isEmpty()){
            currentPost.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
        }
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
