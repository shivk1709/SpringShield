package com.spring.blogging.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blogging.beans.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
