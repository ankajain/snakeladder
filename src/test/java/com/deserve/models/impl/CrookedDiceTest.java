package com.deserve.models.impl;

import org.junit.Assert;
import org.junit.Test;

public class CrookedDiceTest {

    @Test
    public void testCrookedScore() {
        Assert.assertEquals(0, new CrookedDice().roll() % 2);
    }
}