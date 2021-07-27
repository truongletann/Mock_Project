package com.mock.service;

import com.mock.dto.TargetDTO;

import java.util.List;

public interface TargetService {

    List<TargetDTO> getTargetByID(int id);

    void save(TargetDTO targetDTO);

    void edit(TargetDTO targetDTO);

    void deleteById(int id);

    TargetDTO getById(int id);

}
