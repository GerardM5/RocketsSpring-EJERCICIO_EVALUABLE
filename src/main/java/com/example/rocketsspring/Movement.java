package com.example.rocketsspring;

public class Movement {

    public static final int ACCELERATE = 1;
    public static final int BRAKE = 2;
    private Integer movementType;
    private int times;

    public Movement(Integer movementType, int times) {
        this.movementType = movementType;
        this.times = times;
    }

    public Integer getMovementType() {
        return movementType;
    }

    public void setMovementType(Integer movementType) {
        this.movementType = movementType;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
