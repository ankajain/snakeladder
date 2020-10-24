package com.deserve.models;

import java.util.Random;

public abstract class Dice {

    public final Random random = new Random();

    public abstract int roll();
}
