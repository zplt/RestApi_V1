package com.restapi.restapi.dao;

import com.infobip.spring.data.jpa.QuerydslJpaFragment;
import com.restapi.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User,Integer> , QuerydslPredicateExecutor<User>, QuerydslJpaFragment<User> {

}
