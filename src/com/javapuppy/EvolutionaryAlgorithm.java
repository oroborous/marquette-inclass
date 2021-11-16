package com.javapuppy;

public class EvolutionaryAlgorithm {
    private Population population;
    private int maxGenerations;

    public EvolutionaryAlgorithm(int maxGenerations) {
        this.maxGenerations = maxGenerations;
        this.population = new Population(100);
    }

    public void run() {
        for (int i = 0; i < maxGenerations; i++) {
            population.createOffspring();
            population.selectSurvivors();
            System.out.println(population.getFittest());
        }

    }

    public static void main(String[] args) {
        new EvolutionaryAlgorithm(100).run();
    }
}
