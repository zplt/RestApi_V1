package com.restapi.restapi.service.userrole;

import com.restapi.restapi.dao.UserRolesRepository;
import com.restapi.restapi.model.dto.UserRoleDTO;
import com.restapi.restapi.model.entity.UserRole;
import com.restapi.restapi.model.dto.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRolesRepository userRoleService;
    private ModelMapper modelMapper;


    @Autowired
    public UserRoleServiceImpl(UserRolesRepository userRoleService, ModelMapper modelMapper) {
        this.userRoleService = userRoleService;
        this.modelMapper=modelMapper;
    }

    @Override
    public Page<UserRole> findAllUser(Pageable pageable) {
        return userRoleService.findAll(pageable);
    }

    @Override
    public UserRoleDTO findById(Integer id) {
        UserRole userRole= userRoleService.findById(id).orElseThrow(()-> new UserNotFoundException("User Role Not Found id " + id));
        UserRoleDTO userRoleDTO= modelMapper.map(userRole,UserRoleDTO.class);
        return userRoleDTO;
    }

    @Override
    public UserRole save(UserRole theUser) {
        return userRoleService.save(theUser);
    }

    @Override
    public void deleteById(Integer id) {
        userRoleService.deleteById(id);
    }
}
