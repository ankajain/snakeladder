package com.deserve.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Cell> cells;

    public Board(
        final int numberOfCells) {
        this.cells = new ArrayList<>();
        for (int i = 1 ; i <= numberOfCells ; i++) {
            cells.add(new Cell(i));
        }
    }
}
