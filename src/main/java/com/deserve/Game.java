package com.deserve;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.deserve.exception.GameOverException;
import com.deserve.exception.InvalidPlayerException;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.Player;
import com.deserve.models.impl.NormalDice;

public class Game {

    private final int boardSize;
    private final List<GameObject> gameObjects;
    private final Dice dice;
    private final Queue<Player> players;

    public Game(
        final int boardSize,
        final Dice dice) {
        this(boardSize, dice, new ArrayList<>(), new ArrayList<>());

    }

    public Game(
        final int boardSize,
        final List<Player> playerList) {
        this(boardSize, new NormalDice(), new ArrayList<>(), playerList);
    }

    public Game(
        final int boardSize,
        final Dice dice,
        final List<GameObject> gamesObjects,
        final List<Player> playerList) {
        this.boardSize = boardSize;
        this.gameObjects = gamesObjects;
        this.dice = dice;
        this.players = new ArrayDeque<>(playerList);
    }

    public void play(
        final Player player) {
        if (checkPositionValidToPlay(player.getPosition())) {
            final int newNo = dice.roll();
            Integer newPosition = player.getPosition() + newNo;
            newPosition = getNextPositionAfterCheckingWithGamesObjects(newPosition);
            moveToNextLocation(player, newPosition);
        } else {
            throw new InvalidPlayerException(player.getName() + " already won the game.");
        }
    }

    private void moveToNextLocation(
        final Player player,
        final int newPosition) {
        if (player.getPosition() <= 100) {
            player.setPosition(newPosition);
            updateGameStatus(player);
        }
    }

    private Integer getNextPositionAfterCheckingWithGamesObjects(
        final Integer newPosition) {
        final Optional<GameObject> gameObjectOptional = gameObjects.parallelStream()
            .filter(gameObject -> gameObject.getHeadPosition() == newPosition || gameObject.getTailPosition() == newPosition)
            .findFirst();
        return gameObjectOptional.map(gameObject -> gameObject.checkPosition(newPosition))
            .orElse(newPosition);
    }

    private boolean checkPositionValidToPlay(
        final int position) {
        return position < this.boardSize;
    }

    private void updateGameStatus(
        final Player player) {
        if (player.getPosition() == 100) {
            players.poll();
            if (players.size() <= 1)
                throw new GameOverException("Game over");
        } else {
            players.poll();
            players.offer(player);
        }
    }

    public Player getNextPlayer() {
        return players.peek();
    }
}
