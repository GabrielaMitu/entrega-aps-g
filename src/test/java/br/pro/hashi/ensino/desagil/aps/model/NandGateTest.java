package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NandGateTest {
    @Test
    public void whenReceivingFalseAndFalseShouldReturnTrue() {
        NandGate gate = new NandGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnTrue() {
        NandGate gate = new NandGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnTrue() {
        NandGate gate = new NandGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnFalse() {
        NandGate gate = new NandGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }
}
