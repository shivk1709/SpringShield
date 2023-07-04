package com.spring.blogging.daos;

import com.spring.blogging.beans.Category;
import com.spring.blogging.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blogging.beans.Post;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Integer> {

    public List<Post> findByCategory(Category category);
    public List<Post> findByUser(User user);

}
