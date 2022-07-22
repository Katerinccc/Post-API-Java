package com.sofkaU.PostApp.repository;

import com.sofkaU.PostApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
