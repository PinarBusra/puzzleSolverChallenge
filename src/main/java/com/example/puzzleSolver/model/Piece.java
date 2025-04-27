package com.example.puzzleSolver.model;

public class Piece {
        public int[][] shape;

        public Piece(int[][] shape) {
            this.shape = shape;
        }

        public static Piece fromString(String str) {
            String[] lines = str.split(",");
            int[][] shape = new int[lines.length][lines[0].length()];
            for (int i = 0; i < lines.length; i++) {
                for (int j = 0; j < lines[i].length(); j++) {
                    shape[i][j] = lines[i].charAt(j) == 'X' ? 1 : 0;
                }
            }
            return new Piece(shape);
        }

        public int getHeight() {
            return shape.length;
        }

        public int getWidth() {
            return shape[0].length;
        }
    }


