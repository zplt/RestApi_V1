package com.restapi.restapi.service.userrole;

import com.restapi.restapi.model.dto.UserRoleDTO;
import com.restapi.restapi.model.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserRoleService {


    Page<UserRole> findAllUser(Pageable pageable);

    UserRoleDTO findById(Integer id);

    UserRole save(UserRole theUser);

    void deleteById(Integer id);


}
