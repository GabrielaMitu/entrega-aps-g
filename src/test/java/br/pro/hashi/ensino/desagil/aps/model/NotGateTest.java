package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotGateTest {
    @Test
    public void whenReceivingFalseShouldReturnTrue() {
        NotGate gate = new NotGate();
        gate.connect(0, new EmitterFalse());
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueShouldReturnFalse() {
        NotGate gate = new NotGate();
        gate.connect(0, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }
}
