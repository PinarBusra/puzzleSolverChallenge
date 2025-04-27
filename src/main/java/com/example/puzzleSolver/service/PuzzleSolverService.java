package com.example.puzzleSolver.service;

import com.example.puzzleSolver.model.Piece;
import com.example.puzzleSolver.model.PuzzleRequest;
import com.example.puzzleSolver.model.PuzzleResponse;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PuzzleSolverService {
    private int[][] board;
    private int rows;
    private int cols;
    private int depth;
    private List<Piece> pieces;
    private List<String> solution;

    public PuzzleResponse solve(PuzzleRequest request) {
        this.board = parseBoard(request.getBoard());
        this.rows = board.length;
        this.cols = board[0].length;
        this.depth = request.getDepth();
        this.solution = new ArrayList<>();
        this.pieces = new ArrayList<>();

        for (String pieceStr : request.getPieces()) {
            pieces.add(Piece.fromString(pieceStr));
        }

        boolean solved = backtrack(0);

        return new PuzzleResponse(solved, solved ? solution : List.of());
    }

    private int[][] parseBoard(String input) {
        String[] lines = input.split(",");
        int[][] b = new int[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                b[i][j] = lines[i].charAt(j) - '0';
            }
        }
        return b;
    }

    private boolean backtrack(int index) {
        if (index == pieces.size()) {
            return isAllZero();
        }

        Piece piece = pieces.get(index);

        for (int r = 0; r <= rows - piece.getHeight(); r++) {
            for (int c = 0; c <= cols - piece.getWidth(); c++) {
                if (canPlace(piece, r, c)) {
                    applyPiece(piece, r, c);
                    solution.add(c + "," + r);

                    if (backtrack(index + 1)) {
                        return true;
                    }

                    solution.remove(solution.size() - 1);
                    undoPiece(piece, r, c);
                }
            }
        }

        return false;
    }

    private boolean isAllZero() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell % depth != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canPlace(Piece piece, int row, int col) {
        return row + piece.getHeight() <= rows && col + piece.getWidth() <= cols;
    }

    private void applyPiece(Piece piece, int row, int col) {
        for (int i = 0; i < piece.getHeight(); i++) {
            for (int j = 0; j < piece.getWidth(); j++) {
                if (piece.shape[i][j] == 1) {
                    board[row + i][col + j] = (board[row + i][col + j] + 1) % depth;
                }
            }
        }
    }

    private void undoPiece(Piece piece, int row, int col) {
        for (int i = 0; i < piece.getHeight(); i++) {
            for (int j = 0; j < piece.getWidth(); j++) {
                if (piece.shape[i][j] == 1) {
                    board[row + i][col + j] = (board[row + i][col + j] - 1 + depth) % depth;
                }
            }
        }
    }

}
