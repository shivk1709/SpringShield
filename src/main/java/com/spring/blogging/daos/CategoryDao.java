package com.spring.blogging.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blogging.beans.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
