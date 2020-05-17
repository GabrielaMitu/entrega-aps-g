package br.pro.hashi.ensino.desagil.aps.model;


public class OrGate extends Gate {
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;

    public OrGate() {
        super("OR", 2);

        nandTop = new NandGate();

        nandBottom = new NandGate();

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
    }

    @Override
    public boolean read() {
        return nandRight.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nandTop.connect(0, emitter);
                nandTop.connect(1, emitter);
                break;
            case 1:
                nandBottom.connect(0, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputIndex);
        }
    }
}
