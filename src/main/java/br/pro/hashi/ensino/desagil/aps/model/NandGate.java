package br.pro.hashi.ensino.desagil.aps.model;

public class NandGate extends Gate {
    private final Emitter[] emitters;

    public NandGate() {
        super("NAND", 2);

        emitters = new Emitter[2];
    }

    @Override
    public boolean read() {
        boolean a = (emitters[0] != null && emitters[0].read());
        boolean b = (emitters[1] != null && emitters[1].read());
        return !(a && b);
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        emitters[inputIndex] = emitter;
    }
}
