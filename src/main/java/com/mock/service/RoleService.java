package com.mock.service;

import com.mock.dto.RoleDTO;
import com.mock.dto.TargetDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAll();

    void save(RoleDTO roleDTO);

    void edit(RoleDTO roleDTO);

    void deleteById(int id);

    RoleDTO getById(int id);

}
