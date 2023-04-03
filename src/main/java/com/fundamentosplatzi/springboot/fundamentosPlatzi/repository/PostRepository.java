package com.fundamentosplatzi.springboot.fundamentosPlatzi.repository;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
