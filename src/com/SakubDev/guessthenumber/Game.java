package com.SakubDev.guessthenumber;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private int lastNumberOfTries = -1;

    private int random;
    private int numberOfTries;
    private boolean enabled;

    private int min;
    private int max;

    public Game(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public GuessResult guess(int number) {
        if (!enabled) {
            throw new IllegalStateException("Game is not running!");
        }

        if (number == this.random) {
            this.lastNumberOfTries = numberOfTries;
            enabled = false;
            return GuessResult.EXACT;
        }

        numberOfTries++;
        if (number > this.random) {
            return GuessResult.BIGGER;
        } else {
            return GuessResult.SMALLER;
        }
    }

    public void start() {
        if (enabled) {
            throw new IllegalStateException("Game is already running!");
        }

        this.random = ThreadLocalRandom.current().nextInt(min, max + 1);
        this.enabled = true;
        this.numberOfTries = 0;
    }

    public int getLastNumberOfTries() {
        if (lastNumberOfTries == -1) {
            throw new RuntimeException("Game hasn't ever run.");
        }
        return lastNumberOfTries;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
