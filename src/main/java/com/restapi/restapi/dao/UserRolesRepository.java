package com.restapi.restapi.dao;

import com.restapi.restapi.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRole,Integer> {

}
