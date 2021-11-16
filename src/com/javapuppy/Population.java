package com.javapuppy;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private List<Individual>  individuals;

    public Population(int populationSize) {
        individuals = new ArrayList<>();

        for (int i = 0; i < populationSize; i++) {
            individuals.add(new Individual());
        }
    }
}
