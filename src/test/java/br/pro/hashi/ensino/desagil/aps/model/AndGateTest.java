package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AndGateTest {
    @Test
    public void whenReceivingFalseAndFalseShouldReturnFalse() {
        AndGate gate = new AndGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnFalse() {
        AndGate gate = new AndGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnFalse() {
        AndGate gate = new AndGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnTrue() {
        AndGate gate = new AndGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }
}
