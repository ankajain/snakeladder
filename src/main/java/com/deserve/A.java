package com.deserve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.deserve.models.Dice;
import com.deserve.models.GameObject;
import com.deserve.models.impl.CrookedDice;
import com.deserve.models.impl.Ladder;
import com.deserve.models.impl.NormalDice;
import com.deserve.models.impl.Snake;

public class A {

    private static final Scanner scanner = new Scanner(System.in);

    private static int MenuList() {
        System.out.println("1.Enter Snake Details");
        System.out.println("2.Enter Ladder Details");
        System.out.println("3.Start Game");
        return scanner.nextInt();
    }

    private static int diceMenu() {
        System.out.println("1.Normal Dice");
        System.out.println("2.Crooked Dice Throwing only Even Number");
        return scanner.nextInt();
    }

    private static int acceptPosition(
        final String s) {
        System.out.println(s);
        return scanner.nextInt();
    }

    public static void main(
        final String[] args) {

        System.out.println("Enter Board Size");
        final int boardSize = scanner.nextInt();
        System.out.println("Do you want to choose Dice Type Y/N");
        final String diceTypeChoice = scanner.nextLine();
        Dice dice = new NormalDice();
        if (diceTypeChoice == "Y") {
            System.out.println("Enter Dice Type");
            final int diceChoice = diceMenu();
            switch (diceChoice) {
                case 2:
                    dice = new CrookedDice();
                    break;
            }
        }
        int choice;
        final List<GameObject> gameObjectList = new ArrayList<GameObject>();
        while ((choice = A.MenuList()) != 3) {
            if (A.MenuList() == 1)
                gameObjectList.add(new Snake(acceptPosition("Enter head Position"), acceptPosition("Enter Tail Position")));
            else if (A.MenuList() == 2)
                gameObjectList.add(new Ladder(acceptPosition("Enter head Position"), acceptPosition("Enter Tail Position")));
            else if (A.MenuList() == 3)
                break;
        }
        Game game;

        if (choice == 3) {
            // game = new Game(boardSize, dice, gameObjectList);
            // game.play();
        }

    }

}
