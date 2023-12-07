package com.net.stackthread.repositories;

import com.net.stackthread.entities.Post;
import com.net.stackthread.entities.Tag;
import com.net.stackthread.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

    List<Post> findByTags(Tag tag);
}
