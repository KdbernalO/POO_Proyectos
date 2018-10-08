/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.*;
import javax.swing.*;

public final class DialogAcerca extends JDialog {

    Container c;
    JLabel labelTitulo, labelImagen;
    JTextArea textAcerca;

    public DialogAcerca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void initComponents() {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(255, 255, 255));
        labelTitulo = new JLabel("Agenda Personal", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial Black", 1, 20));
        labelTitulo.setBounds(10, 10, 280, 50);
        c.add(labelTitulo);
        labelImagen = new JLabel();
        labelImagen.setIcon(new ImageIcon(getClass().getClassLoader().
                getResource("escudo_ud.gif")));
        labelImagen.setBounds(2, 2, 50, 80);
        c.add(labelImagen);
        textAcerca = new JTextArea();
        textAcerca.setColumns(50);
        textAcerca.setRows(5);
        textAcerca.setText(
                "Universidad Distrital\nIngeniería Industrial\n"
                        + "Programación Orientada a Objetos\n\n"
                        + "Ejemplo de acceso a datos");
        textAcerca.setBounds(70, 50, 220, 100);
        textAcerca.setEditable(false);
        c.add(textAcerca);

        pack();
        setSize(300, 200);
    }
}
