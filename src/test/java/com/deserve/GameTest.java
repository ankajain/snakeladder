package com.deserve;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.deserve.exception.InvalidPlayerException;
import com.deserve.models.Player;

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
        final Game game = new Game(1, List.of(new Player("Akanksha")));
        game.play(new Player("Akanksha"));
    }
}