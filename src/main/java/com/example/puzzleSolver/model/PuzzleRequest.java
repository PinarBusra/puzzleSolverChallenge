package com.example.puzzleSolver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PuzzleRequest {
    private String board;
    private List<String> pieces;
    private int depth = 2;
}
