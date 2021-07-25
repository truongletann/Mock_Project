package com.mock.service.imp;

import com.mock.dto.UserDTO;
import com.mock.entity.User;
import com.mock.repository.UserRepository;
import com.mock.service.RoleService;
import com.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        List<User> entities = userRepository.findAll();
        for(User entity : entities){
            dtos.add(new UserDTO(
                    entity.getUser_id(),
                    entity.getEmail(),
                    entity.getFull_name(),
                    entity.getPassword(),
                    entity.getAvatar(),
                    entity.getPhone(),
                    entity.getAddress(),
                    entity.isStatus(),
                    entity.getRole_id(),
                    roleService.getById(entity.getRole_id()).getRole_name()));
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        userRepository.deleteById(id);
    }
}
