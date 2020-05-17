package br.pro.hashi.ensino.desagil.aps.model;

public abstract class Gate implements Emitter, Receiver {
    private final String name;
    private final int inputSize;

    protected Gate(String name, int inputSize) {
        this.name = name;
        this.inputSize = inputSize;
    }

    public String toString() {
        return name;
    }

    public int getInputSize() {
        return inputSize;
    }
}
