package com.deserve;

import java.util.ArrayList;
import java.util.List;

import com.deserve.models.Board;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.Player;
import com.deserve.models.impl.NormalDice;

public class Game {

    private final Board board;
    private final List<GameObject> gameObjects;
    private final Dice dice;
    private List<Player> players;

    public Game(
        final int boardSize,
        final Dice dice) {
        board = new Board(boardSize);
        this.dice = dice;
        gameObjects = new ArrayList<>();
    }

    public Game(
        final int boardSize) {
        board = new Board(boardSize);
        this.dice = new NormalDice();
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

    public void play(
        final Player player) {

    }

}
