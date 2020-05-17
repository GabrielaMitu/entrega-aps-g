package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XorGateTest {
    @Test
    public void whenReceivingFalseAndFalseShouldReturnFalse() {
        XorGate gate = new XorGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnTrue() {
        XorGate gate = new XorGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnTrue() {
        XorGate gate = new XorGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnFalse() {
        XorGate gate = new XorGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }
}
