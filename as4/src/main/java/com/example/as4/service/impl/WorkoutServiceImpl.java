package com.example.as4.service.impl;

import com.example.as4.model.dto.WorkoutDTO;
import com.example.as4.model.entity.Workout;
import com.example.as4.repository.WorkoutRepository;
import com.example.as4.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Override
    public WorkoutDTO create(WorkoutDTO dto) {
        Workout workout = mapToEntity(dto);
        workout = workoutRepository.save(workout);
        return mapToDTO(workout);
    }

    @Override
    public WorkoutDTO getById(Long id) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        return mapToDTO(workout);
    }

    @Override
    public List<WorkoutDTO> getAll() {
        return workoutRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WorkoutDTO update(Long id, WorkoutDTO dto) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        workout.setWorkoutName(dto.getWorkoutName());
        workout.setWorkoutType(dto.getWorkoutType());
        workout.setDurationMinutes(dto.getDurationMinutes());
        workout.setCaloriesBurned(dto.getCaloriesBurned());
        workout.setWorkoutDate(dto.getWorkoutDate());

        workout = workoutRepository.save(workout);
        return mapToDTO(workout);
    }

    @Override
    public void delete(Long id) {
        workoutRepository.deleteById(id);
    }

    // ========== Mapping helpers ==========
    private WorkoutDTO mapToDTO(Workout workout) {
        return WorkoutDTO.builder()
                .id(workout.getId())
                .workoutName(workout.getWorkoutName())
                .workoutType(workout.getWorkoutType())
                .durationMinutes(workout.getDurationMinutes())
                .caloriesBurned(workout.getCaloriesBurned())
                .workoutDate(workout.getWorkoutDate())
                .build();
    }

    private Workout mapToEntity(WorkoutDTO dto) {
        return Workout.builder()
                .id(dto.getId())
                .workoutName(dto.getWorkoutName())
                .workoutType(dto.getWorkoutType())
                .durationMinutes(dto.getDurationMinutes())
                .caloriesBurned(dto.getCaloriesBurned())
                .workoutDate(dto.getWorkoutDate())
                .build();
    }
}
