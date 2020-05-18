package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XnorGateTest {
    @Test
    public void whenReceivingFalseAndFalseShouldReturnTrue() {
        XnorGate gate = new XnorGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnFalse() {
        XnorGate gate = new XnorGate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnFalse() {
        XnorGate gate = new XnorGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnTrue() {
        XnorGate gate = new XnorGate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }
}
