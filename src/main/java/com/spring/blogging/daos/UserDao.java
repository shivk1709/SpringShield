package com.spring.blogging.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blogging.beans.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
