package com.deserve.models.impl;

import com.deserve.models.Dice;

public class CrookedDice extends Dice {

    public int roll() {
        return (random.nextInt(3) + 1) * 2;
    }
}
