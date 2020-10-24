package com.deserve;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deserve.exception.GameOverException;
import com.deserve.exception.InvalidPlayerException;
import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.Player;
import com.deserve.models.impl.CrookedDice;
import com.deserve.models.impl.Ladder;
import com.deserve.models.impl.Snake;

public class GameTest {

    Player p;

    @Before
    public void before() {
        p = new Player("Akanksha");
    }

    @Test
    public void play() {

        final Game game = new Game(100, List.of(p));
        final int currentPosition = p.getPosition();
        game.play(p);
        Assert.assertNotEquals("Player should not be at same Position after Start ", currentPosition, p.getPosition());
    }

    @Test(expected = InvalidPlayerException.class)
    public void playWith1SizeBoard() {
        final Game game = new Game(0, List.of(new Player("Akanksha")));
        game.play(p);
    }

    @Test
    public void testWithSnake() {
        final GameObject snake = new Snake(14, 7);
        final Game game = new Game(100, new Dice() {

            @Override
            public int roll() {
                return 14;
            }
        }, List.of(snake), List.of(p));
        game.play(p);
        Assert.assertNotEquals("Player should be at 13th Position after Start ", 13, p.getPosition());
    }

    @Test
    public void testWithCrookedDice() {
        final Game game = new Game(100, new CrookedDice(), List.of(new Snake(14, 7)), List.of(p));
        game.play(p);
        Assert.assertEquals("As initial position is 0 so crooked dice will put player to all even position", 0, p.getPosition() % 2);
    }

    @Test(expected = GameOverException.class)
    public void endToEndWithTwoPlayersTest() {
        final Player p2 = new Player("Snehal");

        final Game game = new Game(100, new Dice() {

            @Override
            public int roll() {
                return 50;
            }
        }, List.of(new Snake(14, 7)), List.of(p, p2));
        game.play(p);
        game.play(p2);
        game.play(p);
    }

    @Test(expected = GameOverException.class)
    public void endToEndWithTwoPlayersWithSnakeAndLadderTest() {
        final Player p2 = new Player("Snehal");
        final Game game = new Game(100, new Dice() {

            @Override
            public int roll() {
                return 20;
            }
        }, List.of(new Snake(20, 7), new Ladder(40, 27),
                new Snake(60, 50), new Snake(90, 80)),
                List.of(p, p2));
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
    }

    @Test(expected = GameOverException.class)
    public void endToEndWithMultiPlayersTest() {
        final Player p2 = new Player("A1");
        final Player p3 = new Player("A2");
        final Player p4 = new Player("A3");
        final Player p5 = new Player("A4");
        final Game game = new Game(100, new Dice() {

            @Override
            public int roll() {
                return 50;
            }
        }, List.of(new Snake(14, 7)), List.of(p, p2, p3, p4, p5));
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
        game.play(game.getNextPlayer());
    }

}