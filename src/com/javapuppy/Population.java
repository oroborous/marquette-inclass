package com.javapuppy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Population {
    private List<Individual>  individuals;
    private int populationSize;

    public Population(int populationSize) {
        individuals = new ArrayList<>();
        this.populationSize = populationSize;

        for (int i = 0; i < populationSize; i++) {
            individuals.add(new Individual());
        }
    }

    public Individual getFittest() {
        return individuals.get(0);
    }

    public void selectSurvivors() {
        individuals.sort(Comparator.comparing(individual -> (-1 * individual.fitness())));
        individuals = individuals.subList(0, populationSize);
    }

    public void createOffspring() {
        for (int i = 0; i < populationSize; i++) {
            Individual newGuy = new Individual(individuals.get(i));
            newGuy.mutate();
            individuals.add(newGuy);
        }
    }
}
