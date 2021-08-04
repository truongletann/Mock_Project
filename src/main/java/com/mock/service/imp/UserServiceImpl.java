package com.mock.service.imp;

import com.mock.dto.UserDTO;
import com.mock.entity.User;
import com.mock.repository.UserRepository;
import com.mock.service.RoleService;
import com.mock.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
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
        return dtos;
    }

    @Override
    public UserDTO getById(int id) {
        if(id <0){
            return null;
        }
        User entity = userRepository.findById(id).get();
        return new UserDTO(
                entity.getUser_id(),
                entity.getEmail(),
                entity.getFull_name(),
                entity.getPassword(),
                entity.getAvatar(),
                entity.getPhone(),
                entity.getAddress(),
                entity.isStatus(),
                entity.getRole_id(),
                roleService.getById(entity.getRole_id()).getRole_name());
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        userRepository.deleteUser(id);
    }

    @Override
    public void acticeByID(int id) {
        if(id < 0){
            return;
        }
        userRepository.activeUser(id);
    }

    @Override
    public void edit(UserDTO userDTO) {
        if(userDTO == null){
            return;
        }
        User entity = new User(
                userDTO.getUser_id(),
                userRepository.findById(userDTO.getUser_id()).get().getEmail(),
                userDTO.getFull_name(),
                BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()),
                userDTO.getAvatar(),
                userDTO.getPhone(),
                userDTO.getAddress(),
                userRepository.findById(userDTO.getUser_id()).get().isStatus(),
                userRepository.findById(userDTO.getUser_id()).get().getRole_id());
        userRepository.saveAndFlush(entity);
    }

    @Override
    public void save(UserDTO userDTO) {
        if(userDTO == null){
            return;
        }
        User entity = new User(
                userDTO.getEmail(),
                userDTO.getFull_name(),
                BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()),
                true,
                2);
        userRepository.save(entity);

    }
}
