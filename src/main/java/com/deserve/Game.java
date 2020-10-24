package com.deserve;

import java.util.ArrayList;
import java.util.List;

import com.deserve.models.Board;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;

public class Game {

    private final Board board;
    private final List<GameObject> gameObjects;
    private final Dice dice;

    public Game(
        final int boardSize,
        final Dice dice) {
        board = new Board(boardSize);
        this.dice = dice;
        gameObjects = new ArrayList<>();
    }

    public Game(
        final int boardSize,
        final Dice dice,
        final List<GameObject> gamesObjects) {
        board = new Board(boardSize);
        this.gameObjects = gamesObjects;
        this.dice = dice;
    }

    // public void addObject(
    // final GameObject gameObject) {
    // if (gameObject instanceof Snake)
    // snakeList.add((Snake)gameObject);
    // else if (gameObject instanceof Ladder)
    // ladderList.add((Ladder)gameObject);
    // }

    public void play() {

    }

}
