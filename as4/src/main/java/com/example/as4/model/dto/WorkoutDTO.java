package com.example.as4.model.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutDTO {
    private Long id;
    private String workoutName;
    private String workoutType;
    private int durationMinutes;
    private int caloriesBurned;
    private LocalDate workoutDate;
}
