package com.yuyuto.procrafter.energy;

public class EnergyStorage {
    private int energy;

    public EnergyStorage(int initialEnergy) {
        this.energy = initialEnergy;
    }

    public void addEnergy(int amount) {
        energy += amount;
    }

    public void removeEnergy(int amount) {
        energy -= amount;
        if (energy < 0) {
            energy = 0;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public boolean hasEnergy(int amount) {
        return energy >= amount;
    }
}
