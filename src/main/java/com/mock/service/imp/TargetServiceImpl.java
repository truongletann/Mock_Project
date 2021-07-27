package com.mock.service.imp;

import com.mock.dto.TargetDTO;
import com.mock.entity.Target;
import com.mock.repository.TargetRepository;
import com.mock.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private TargetRepository targetRepository;

    @Override
    public List<TargetDTO> getTargetByID(int id) {
        return targetRepository.getTargetByCourses(id);
    }

    @Override
    public void save(TargetDTO targetDTO) {
        if(targetDTO == null){
            return;
        }
        Target entity = new Target(
                targetDTO.getTarget_id(),
                targetDTO.getTarget_title(),
                targetDTO.getCourse_id());
        targetRepository.save(entity);
    }

    @Override
    public void edit(TargetDTO targetDTO) {
        if(targetDTO == null){
            return;
        }
        Target entity = new Target(
                targetDTO.getTarget_id(),
                targetDTO.getTarget_title());

        targetRepository.editTarget(targetDTO.getTarget_title(),targetDTO.getTarget_id());
//        targetRepository.saveAndFlush(entity);

    }

    @Override
    public void deleteById(int id) {
        if(id < 0 ){
            return;
        }
        targetRepository.deleteById(id);
    }

    @Override
    public TargetDTO getById(int id) {
        if(id < 0 ){
            return null;
        }
        Target entity = targetRepository.findById(id).get();
        return new TargetDTO(
                entity.getTarget_id(),
                entity.getTarget_title(),
                entity.getCourse_id());
    }
}
