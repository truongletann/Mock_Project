package com.mock.service.imp;


import com.mock.dto.RoleDTO;
import com.mock.entity.Role;
import com.mock.repository.RoleRepository;
import com.mock.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAll() {
        List<RoleDTO> dtos = new ArrayList<RoleDTO>();
        List<Role> entities = roleRepository.findAll();
        for(Role entity : entities){
            dtos.add(new RoleDTO(
                    entity.getRole_id(),
                    entity.getRole_name()));
        }
        return dtos;
    }

    @Override
    public void save(RoleDTO roleDTO) {
        if(roleDTO == null){
            return;
        }
        Role entity = new Role(
                roleDTO.getRole_name());
        roleRepository.save(entity);
    }

    @Override
    public void edit(RoleDTO roleDTO) {
        if(roleDTO == null){
            return;
        }
        Role entity = new Role(
                roleDTO.getRole_id(),
                roleDTO.getRole_name());
        roleRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDTO getById(int id) {
        if(id < 0 ){
            return null;
        }
        Role entity = roleRepository.findById(id).get();
        return new RoleDTO(
                entity.getRole_id(),
                entity.getRole_name());
    }
}
