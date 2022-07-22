package com.sofkaU.PostApp.repository;

import com.sofkaU.PostApp.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
