package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.*;

import javax.swing.*;
import java.util.LinkedList;

public class APS {
    public static void main(String[] args) {

        // Constrói o modelo, que é simplesmente uma lista
        // de calculadoras. Aqui a coesão está boa: para
        // criar uma nova calculadora, basta criar a
        // respectiva classe e adicionar uma linha abaixo.
        LinkedList<Gate> model = new LinkedList<>();
        model.add(new AndGate());
        model.add(new NandGate());
        model.add(new NotGate());
        model.add(new OrGate());
        model.add(new XorGate());


        // Constrói a visão, que também é um controlador.
        // Juntar visão e controlador prejudica a coesão,
        // mas decidir fazê-lo para simplificar o código.
        View view = new View(model);

        // Todas as linhas abaixo já foram explicadas nos Desafios.
        // Além disso, não é importante entendê-las para estas APS.
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(view);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        });
    }
}


