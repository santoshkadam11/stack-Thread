package com.net.stackthread.repositories;

import com.net.stackthread.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);

    List<Tag> findAll();
}
