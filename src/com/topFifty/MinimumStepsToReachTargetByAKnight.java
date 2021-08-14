package com.topFifty;

import java.util.*;

public class MinimumStepsToReachTargetByAKnight {
    class Cell {
        int row;
        int column;
        int distance;

        public Cell(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row && column == cell.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    static int[] rowMove = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] columnMove = {1, 2, 2, 1, -1, -2, -2, -1};


    public int solution(int[] knightPos, int[] targetPos, int boardLength) {
        int minJump = 0;
        Queue<Cell> queue = new LinkedList<>();
        Set<Cell> visitedPositions = new HashSet<>();
        Cell target = new Cell(targetPos[0], targetPos[1], -1);
        Cell candidatePos;
        Cell curr;
        if (target.equals(new Cell(knightPos[0], knightPos[1], 0))) {
            return minJump;
        }
        queue.offer(new Cell(knightPos[0], knightPos[1], 0));

        while (!queue.isEmpty()) {
            curr = queue.poll();
            minJump = curr.distance + 1;
            for (int i = 0; i < rowMove.length; i++) {
                if (curr.row + rowMove[i] >= 0 && curr.row + rowMove[i] < boardLength && curr.column + columnMove[i] >= 0 && curr.column + columnMove[i] < boardLength) {
                    candidatePos = new Cell(curr.row + rowMove[i], curr.column + columnMove[i], minJump);
                    if (candidatePos.equals(target)) {
                        return minJump;
                    } else if (!visitedPositions.contains(candidatePos)) {
                        queue.offer(candidatePos);
                        visitedPositions.add(candidatePos);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] knightPos = {0, 0};
        int[] targetPos = {1, 1};
        System.out.println(new MinimumStepsToReachTargetByAKnight().solution(knightPos, targetPos, 7));
    }
}
