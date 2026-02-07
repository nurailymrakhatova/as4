package com.example.as4.controller;

import com.example.as4.model.dto.WorkoutDTO;
import com.example.as4.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    public WorkoutDTO create(@RequestBody WorkoutDTO dto) {
        return workoutService.create(dto);
    }

    @GetMapping("/{id}")
    public WorkoutDTO getById(@PathVariable Long id) {
        return workoutService.getById(id);
    }

    @GetMapping
    public List<WorkoutDTO> getAll() {
        return workoutService.getAll();
    }

    @PutMapping("/{id}")
    public WorkoutDTO update(@PathVariable Long id, @RequestBody WorkoutDTO dto) {
        return workoutService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workoutService.delete(id);
    }
}

