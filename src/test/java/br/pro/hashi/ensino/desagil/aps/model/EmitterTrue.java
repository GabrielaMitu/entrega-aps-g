package br.pro.hashi.ensino.desagil.aps.model;

public class EmitterTrue implements Emitter {
    @Override
    public boolean read() {
        return true;
    }
}
