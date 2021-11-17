package com.javapuppy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {

    private static Random random = new Random();

    private List<Float> representation;
    private double mutationRate = 0.5;
    private double mutationStepSize = 0.2;

    public Individual() {
        representation = new ArrayList<>();
        representation.add((random.nextFloat() * 9) - 4);
        representation.add((random.nextFloat() * 9) - 4);
    }

    public Individual(Individual original) {
        this();
        representation.addAll(original.representation);
    }

    public void mutate() {
        for (Float gene : representation) {
            if(random.nextDouble() < mutationRate) {
                double mutationAmt = random.nextGaussian() * mutationStepSize;
                representation.set(0, (float)(gene + mutationAmt));
                representation.set(1, (float)(gene + mutationAmt));
            }
        }
    }

    public double fitness() {
        float x0 = representation.get(0);
        float x1 = representation.get(1);
        return (100 - 2*10*((Math.pow(x0, 2) - 10 * Math.cos(2 * Math.PI * x0))
                + (Math.pow(x1, 2) - 10 * Math.cos(2 * Math.PI * x1))));
    }

    public String toString() {
        return String.format("(%f, %f)", representation.get(0),representation.get(1));
    }
}
