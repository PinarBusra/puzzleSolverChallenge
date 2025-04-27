package com.example.puzzleSolver.controller;


import com.example.puzzleSolver.model.PuzzleRequest;
import com.example.puzzleSolver.model.PuzzleResponse;
import com.example.puzzleSolver.service.PuzzleSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/puzzle")
public class PuzzleController {
    @Autowired
    private PuzzleSolverService puzzleSolverService;

    @PostMapping("/solve")
    public PuzzleResponse solve(@RequestBody PuzzleRequest request) {
        return puzzleSolverService.solve(request);
    }
}
