package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

//import br.pro.hashi.ensino.desagil.crossover.model.Calculator;

// A classe JPanel representa uma das componentes mais
// simples da Swing. A função dela é simplesmente ser
// um contêiner para colocar outras componentes dentro.
// A razão de implementar ActionListener está mais abaixo.
public class View extends JPanel implements ActionListener {

    // A ideia é que essa componente gráfica mostre um menu
    // que permite selecionar uma calculadora e também mostre
    // a representação gráfica da calculadora atualmente
    // selecionada. Esse menu é uma instância de JComboBox
    // e essa representação gráfica da calculadora é uma
    // instância da classe CalculatorView, que você já leu.
    private final JComboBox<Gate> menu;
    private GateView gateView;


    // O construtor recebe uma lista de calculadoras, que
    // devem ser adicionadas ao menu. O menu consegue mostrar
    // os nomes das calculadoras graças ao método toString.
    public View(LinkedList<Gate> model) {
        menu = new JComboBox<>();
        for (Gate gate : model) {
            menu.addItem(gate);
        }

        // Um JPanel tem um layout, ou seja, um padrão para
        // organizar as componentes dentro dele. A linha abaixo
        // estabelece um dos padrões mais simples: simplesmente
        // colocar uma componente debaixo da outra, alinhadas.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Vamos adicionar a este JPanel o menu e a representação
        // gráfica da calculadora atualmente selecionada, que é
        // a primeira. Como sempre, a contagem começa de zero.
        // A implementação de addCalculatorView está logo abaixo.
        add(menu);
        addGateView(0);

        // Um menu tem uma lista de observadores que reagem
        // quando o usuário selecionar algum item. Usamos o
        // método addActionListener para adicionar esta
        // instância de View, ou seja "this", nessa lista. Só
        // que addActionListener espera receber um objeto do
        // tipo ActionListener como parâmetro. É por isso que
        // adicionamos o "implements ActionListener" lá em cima.
        menu.addActionListener(this);
    }

    // Este método é responsável por adicionar a este JPanel a
    // representação gráfica da calculadora identificada por
    // um índice. Isso consiste em três passos simples.
    private void addGateView(int index) {

        // 1. Usar o índice para pegar a calculadora do menu.
        Gate gate = menu.getItemAt(index);

        // 2. Construir a representação gráfica a partir dela.
        gateView = new GateView(gate);

        // 3. Adicionar essa representação gráfica no JPanel.
        add(gateView);
    }

    // O que esta componente deve fazer quando o usuário
    // selecionar um item no menu? Bem, ela deve...
    @Override
    public void actionPerformed(ActionEvent event) {

        // ...tirar a atual representação gráfica de calculadora...
        remove(gateView);

        // ...descobrir qual é o índice da calculadora selecionada...
        int index = menu.getSelectedIndex();

        // ...e usar o método acima para adicionar a nova.
        addGateView(index);

        // Mantenha esta linha, mas não precisa entendê-la.
        // É necessária para evitar bugs em alguns sistemas.
        ((JFrame) SwingUtilities.getRoot(this)).pack();
    }
}
