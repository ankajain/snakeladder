package com.deserve;

import java.util.ArrayList;
import java.util.List;

import com.deserve.exception.InvalidPlayerException;
import com.deserve.models.Board;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.Player;
import com.deserve.models.impl.NormalDice;

public class Game {

    private final Board board;
    private final int boardSize;
    private final List<GameObject> gameObjects;
    private final Dice dice;
    private List<Player> players;

    public Game(
        final int boardSize,
        final Dice dice) {
        board = new Board(boardSize);
        this.dice = dice;
        gameObjects = new ArrayList<>();
        this.boardSize = boardSize;
    }

    public Game(
        final int boardSize,
        final List<Player> playerList) {
        board = new Board(boardSize);
        this.dice = new NormalDice();
        gameObjects = new ArrayList<>();
        this.players = playerList;
        this.boardSize = boardSize;
    }

    public Game(
        final int boardSize,
        final Dice dice,
        final List<GameObject> gamesObjects) {
        board = new Board(boardSize);
        this.gameObjects = gamesObjects;
        this.dice = dice;
        this.boardSize = boardSize;
    }

    public void play(
        final Player player) {
        if (checkPositionValidToPlay(player.getPosition())) {
            final int newNo = dice.roll();
            final int newPosition = player.getPosition() + newNo;
            if (checkPositionValidToPlay(newPosition))
                player.setPosition(newPosition);
        } else {
            throw new InvalidPlayerException(player.getName() + " already won the game.");
        }
    }

    private boolean checkPositionValidToPlay(
        final int position) {
        return position < this.boardSize;
    }
}
