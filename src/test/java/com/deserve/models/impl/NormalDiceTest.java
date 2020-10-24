package com.deserve.models.impl;

import org.junit.Assert;
import org.junit.Test;

public class NormalDiceTest {

    @Test
    public void roll() {
        Assert.assertNotEquals(7, new NormalDice().roll());
    }
}