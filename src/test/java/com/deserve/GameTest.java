package com.deserve;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.deserve.exception.InvalidPlayerException;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.Player;
import com.deserve.models.impl.Snake;

public class GameTest {

    @Test
    public void play() {
        final Player p = new Player("Akanksha");
        final Game game = new Game(100, List.of(p));
        final int currentPosition = p.getPosition();
        game.play(p);
        Assert.assertNotEquals("Player should not be at same Position after Start ", currentPosition, p.getPosition());
    }

    @Test(expected = InvalidPlayerException.class)
    public void play_with_1_size_board() {
        final Player p = new Player("Akanksha");
        final Game game = new Game(1, List.of(new Player("Akanksha")));
        game.play(p);
    }

    @Test
    public void test_with_snake() {
        final Player p = new Player("Akanksha");
        final GameObject snake = new Snake(14, 7);
        final Game game = new Game(100, new Dice() {
            @Override
            public int roll() {
                return 13;
            }
        }, List.of(snake), List.of(p));
        game.play(p);
        Assert.assertNotEquals("Player should be at 13th Position after Start ", 13, p.getPosition());
    }
}