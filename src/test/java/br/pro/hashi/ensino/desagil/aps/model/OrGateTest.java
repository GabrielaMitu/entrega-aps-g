package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrGateTest {
    @Test
    public void whenReceivingFalseAndFalseShouldReturnFalse() {
        OrGate gate = new OrGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnTrue() {
        OrGate gate = new OrGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnTrue() {
        OrGate gate = new OrGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnTrue() {
        OrGate gate = new OrGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }
}
