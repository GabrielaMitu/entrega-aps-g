package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Light;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

//import br.pro.hashi.ensino.desagil.crossover.model.Calculator;


// Duas modificações em relação à versão da entrega anterior:
// (a) esta classe agora é subclasse de FixedPanel em vez
// de JPanel; e (b) esta classe agora implementa MouseListener,
// indicando que ela reage a eventos de interação com o mouse.
public class GateView extends FixedPanel implements ActionListener, MouseListener {
    private final Gate gate;

    // private final JTextField weightField;
    //private final JTextField radiusField;
    private final JCheckBox[] entradas;
    //private final JCheckBox outputBox;
    private final Switch[] switches;
    private final Light lights;

    private final Image image;
    // Novos atributos necessários para esta versão da interface.
    private Color color;
    private Color gateColor;


    public GateView(Gate gate) {
        super();

        // Como subclasse de FixedPanel, esta classe agora
        // exige que uma largura e uma altura sejam fixadas.
        this.gate = gate;

        int inputSize = gate.getInputSize();
        entradas = new JCheckBox[inputSize];
        switches = new Switch[inputSize];
        lights = new Light(255, 0, 0);


        for (int i = 0; i < inputSize; i++) {
            entradas[i] = new JCheckBox();
            switches[i] = new Switch();
            lights.connect(0, gate);

            gate.connect(i, switches[i]);
        }


        int y_out = 176;

        int x = 15;
        int y;
        int w = 50;
        int h = 50;
        if (inputSize == 1) {
            y = y_out;
            // se só tiver uma entrada, ela fica na mesma altura da saída
        } else {
            y = 135;
        }
        int incremento = 66;
        for (JCheckBox inputBox : entradas) {
            add(inputBox, x, y, w, h);
            y += incremento;
        }


        for (JCheckBox inputbox : entradas) {
            inputbox.addActionListener(this);
        }


        // Toda componente Swing tem uma lista de observadores
        // que reagem quando algum evento de mouse acontece.
        // Usamos o método addMouseListener para adicionar a
        // própria componente, ou seja "this", nessa lista.
        // Só que addMouseListener espera receber um objeto
        // do tipo MouseListener como parâmetro. É por isso que
        // adicionamos o "implements MouseListener" lá em cima.
        addMouseListener(this);


        // Carregando as imagens das portas
        String name = gate.toString() + ".png";
        URL url = getClass().getClassLoader().getResource(name);
        image = getToolkit().getImage(url);
//fonte das imagens:
        //https://bmet.fandom.com/wiki/Logic_Gates

        update();


    }

    private void update() {
        for (int i = 0; i < gate.getInputSize(); i++) {
            if (entradas[i].isSelected()) {
                switches[i].turnOn();
            } else {
                switches[i].turnOff();
            }
        }


        gateColor = lights.getColor();
        System.out.println(gate.read());

    }


    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {


        // Descobre em qual posição o clique ocorreu.
        int x = event.getX();
        int y = event.getY();

        // Se o clique foi dentro do círculo colorido...
        int x_out = 168;
        int y_out = 193;
        int h_out = 35;
        if (((x - x_out) * (x - x_out) + (y - y_out) * (y - y_out)) < ((h_out / 2) * (h_out / 2))) {
            update();


            // ...então abrimos a janela seletora de cor...
            color = JColorChooser.showDialog(this, null, color);

            lights.setColor(color);

            // ...e chamamos repaint para atualizar a tela.
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de pressionar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Não precisamos de uma reação específica à ação de soltar
        // um botão do mouse, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.

    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // entrar no painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Não precisamos de uma reação específica à ação do mouse
        // sair do painel, mas o contrato com MouseListener obriga
        // esse método a existir, então simplesmente deixamos vazio.
    }

    @Override
    public void paintComponent(Graphics g) {

        // Não podemos esquecer desta linha, pois não somos os
        // únicos responsáveis por desenhar o painel, como era
        // o caso nos Desafios. Agora é preciso desenhar também
        // componentes internas, e isso é feito pela superclasse.
        super.paintComponent(g);
        int x_out = 150;
        int y_out = 176;
        int w_out = 35;
        int h_out = 35;


        // Desenha a imagem, passando sua posição e seu tamanho.
        g.drawImage(image, 10, 80, 221, 221, this);

        gateColor = lights.getColor();
        g.setColor(gateColor);
        g.fillOval(x_out, y_out, w_out, h_out);
        repaint();


        // Linha necessária para evitar atrasos
        // de renderização em sistemas Linux.
        getToolkit().sync();
    }
}

//https://www.tutorialspoint.com/how-can-we-add-insert-a-jcheckbox-inside-a-jtable-cell-in-java