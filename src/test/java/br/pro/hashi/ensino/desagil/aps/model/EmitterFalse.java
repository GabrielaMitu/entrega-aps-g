package br.pro.hashi.ensino.desagil.aps.model;

public class EmitterFalse implements Emitter {
    @Override
    public boolean read() {
        return false;
    }
}
