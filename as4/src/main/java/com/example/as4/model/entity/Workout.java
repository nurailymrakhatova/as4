package com.example.as4.model.entity;

import jakarta.persistence.*;
        import lombok.*;
        import java.time.LocalDate;

@Entity
@Table(name = "workouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_name", nullable = false, unique = true)
    private String workoutName;

    @Column(name = "workout_type", nullable = false)
    private String workoutType;

    @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

    @Column(name = "calories_burned", nullable = false)
    private int caloriesBurned;

    @Column(name = "workout_date", nullable = false)
    private LocalDate workoutDate;
}

