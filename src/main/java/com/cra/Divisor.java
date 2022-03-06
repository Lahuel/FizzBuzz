package com.cra;

public class Divisor {
    private final int divisor;
    private final String sound;

    public Divisor(int divisor, String sound) {
        this.divisor = divisor;
        this.sound = sound;
    }

    public int getDivisor() {
        return divisor;
    }

    public String getSound() {
        return sound;
    }
}
