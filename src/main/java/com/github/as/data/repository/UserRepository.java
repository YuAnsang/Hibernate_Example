package com.github.as.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import com.github.as.data.entity.User;

public interface UserRepository extends JpaRepository<User, String>, QueryDslPredicateExecutor<User> {

}