package br.pro.hashi.ensino.desagil.aps.model;

public class XnorGate extends Gate{
    private final NandGate nandLeft;
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;
    private final NandGate nandFront;

    public XnorGate() {
        super("XNOR", 2);

        nandLeft = new NandGate();

        nandTop = new NandGate();
        nandTop.connect(1, nandLeft);

        nandBottom = new NandGate();
        nandBottom.connect(0, nandLeft);

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);

        nandFront = new NandGate();
        nandFront.connect(0, nandRight);
        nandFront.connect(1, nandRight);
    }

    @Override
    public boolean read() {
        return nandRight.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex > 1) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        nandTop.connect(inputIndex, emitter);
        nandLeft.connect(inputIndex, emitter);
        nandFront.connect(inputIndex, emitter);
        nandRight.connect(1, emitter);// deixa assim
        //nandBottom.connect(inputIndex, emitter);

    }
}

