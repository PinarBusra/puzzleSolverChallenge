package com.example.puzzleSolver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PuzzleResponse {
    private boolean solvable;
    private List<String> placements;


}
