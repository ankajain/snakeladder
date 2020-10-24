package com.deserve.models.impl;

import com.deserve.models.Dice;

public class NormalDice extends Dice {

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
