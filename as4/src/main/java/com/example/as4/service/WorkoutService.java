package com.example.as4.service;

import com.example.as4.model.dto.WorkoutDTO;
import java.util.List;

public interface WorkoutService {
    WorkoutDTO create(WorkoutDTO dto);
    WorkoutDTO getById(Long id);
    List<WorkoutDTO> getAll();
    WorkoutDTO update(Long id, WorkoutDTO dto);
    void delete(Long id);
}
