/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import agenda.Datos.*;
import agenda.logica.*;
import javax.swing.table.DefaultTableModel;

public final class interfazCitas implements ActionListener {

    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel;
    DefaultTableModel modeloTabla;
    JTable tablaCitas;
    JTabbedPane pestana;
    Container panelInformacion, panelCitas;
    JLabel labelId, labelPersona, labelLugar, labelHora,
            labelDescripcion, labelDireccionDomicilio, labelDireccionOficina,
            labelCelular, labelCorreo;
    JTextField textId, textPersona, textLugar, textHora, textDescripcion,
            textDireccionDomicilio, textDireccionOficina, textCelular, textCorreo;
    JButton botonNuevoCita, botonGuardarCita, botonEditarCita, botonBorrarCita;

    DBCitas dbc2 = new DBCitas();
    Cita[] citas;
    int estado = 0;
    int fila;

    public interfazCitas() {
        initComponents();
    }

    public void initComponents() {
        frame = new JFrame("Agenda de Citas");
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu = new JMenu("Opciones");
        menuBar.add(menu);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        panelCitas = new JPanel(null);
        panelCitas.setLayout(null);
        pestana = new JTabbedPane();
        pestana.addTab("Información de citas", panelInformacion);
        pestana.addTab("Citas", panelCitas);

        int y = 5;
        int x = 10;
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;

        y += 30;
        labelPersona = new JLabel("persona", SwingConstants.RIGHT);
        labelPersona.setBounds(x, y, labelAncho, labelAlto);
        panelInformacion.add(labelPersona);

        textPersona = new JTextField();
        textPersona.setBounds(x + 160, y, textAncho, textAlto);
        panelInformacion.add(textPersona);

        labelLugar = new JLabel("Lugar", SwingConstants.RIGHT);
        labelLugar.setBounds(x + 350, y, labelAncho, labelAlto);
        panelInformacion.add(labelLugar);

        textLugar = new JTextField();
        textLugar.setBounds(x + 510, y, textAncho, textAlto);
        panelInformacion.add(textLugar);
        y += 30;
        labelHora = new JLabel("Hora", SwingConstants.RIGHT);
        labelHora.setBounds(x, y, labelAncho, labelAlto);
        panelInformacion.add(labelHora);

        textHora = new JTextField();
        textHora.setBounds(x + 160, y, textAncho, textAlto);
        panelInformacion.add(textHora);

        labelDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
        labelDescripcion.setBounds(x + 350, y, labelAncho, labelAlto);
        panelInformacion.add(labelDescripcion);

        textDescripcion = new JTextField();
        textDescripcion.setBounds(x + 510, y, textAncho, textAlto);
        panelInformacion.add(textDescripcion);

        y += 60;
        botonNuevoCita = new JButton("Nuevo Cita");
        botonNuevoCita.setBounds(x, y, labelAncho, 50);
        panelInformacion.add(botonNuevoCita);
        botonNuevoCita.addActionListener(this);

        botonGuardarCita = new JButton("Guardar Cita");
        botonGuardarCita.setBounds(x + 200, y, labelAncho, 50);
        panelInformacion.add(botonGuardarCita);
        botonGuardarCita.addActionListener(this);
        botonEditarCita = new JButton("Editar Cita");
        botonEditarCita.setBounds(x + 400, y, labelAncho, 50);
        panelInformacion.add(botonEditarCita);
        botonEditarCita.addActionListener(this);

        botonBorrarCita = new JButton("Borrar Cita");
        botonBorrarCita.setBounds(x + 600, y, labelAncho, 50);
        panelInformacion.add(botonBorrarCita);
        botonBorrarCita.addActionListener(this);

        citas = dbc2.getCitas();
        Object[][] data = new Object[citas.length][5];
        for (int c = 0; c < citas.length; c++) {
            data[c][0] = citas[c].getPersona();
            data[c][1] = citas[c].getLugar();
            data[c][2] = citas[c].getHora();
            data[c][3] = citas[c].getDescripcion();

        }

        String[] columNames = {"persona", "lugar", "hora", "descripcion"};

        modeloTabla = new DefaultTableModel(data, columNames);

        tablaCitas = new JTable(modeloTabla);
        tablaCitas.setPreferredScrollableViewportSize(new Dimension(500, 150));

        scrollPanel = new JScrollPane(tablaCitas);

        tablaCitas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                fila = tablaCitas.rowAtPoint(e.getPoint());
                int columna = tablaCitas.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    textId.setText(String.valueOf(tablaCitas.getValueAt(fila, 0)));
                    for (int i = 0; i < citas.length; i++) {
                        if (String.valueOf(citas[i].getPersona()).equals(String.valueOf(tablaCitas.getValueAt(fila, 0)))) {
                            textPersona.setText(citas[i].getPersona());
                            textLugar.setText(citas[i].getLugar());
                            textHora.setText(citas[i].getHora());
                            textDescripcion.setText(citas[i].getDescripcion());

                        }

                    }
                    estado = 2;
                    alterarEstado();
                }
            }
        });

        frame.getContentPane().add(scrollPanel, BorderLayout.NORTH);
        frame.getContentPane().add(pestana, BorderLayout.CENTER);

        frame.pack();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setVisible(true);

        alterarEstado();
    }

    public void alterarEstado() {
        switch (this.estado) {
            case 0://estado por defecto
                botonNuevoCita.setEnabled(true);
                botonBorrarCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonGuardarCita.setEnabled(false);
                textPersona.setEditable(false);
                textLugar.setEditable(false);
                textHora.setEditable(false);
                textDescripcion.setEditable(false);

                break;
            case 1://estado para un nuevo contacto
                botonNuevoCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonGuardarCita.setEnabled(true);
                textPersona.setEditable(true);
                textLugar.setEditable(true);
                textHora.setEditable(true);
                textDescripcion.setEditable(true);

                break;
            case 2://estado de carga de un contacto
                botonNuevoCita.setEnabled(false);
                botonBorrarCita.setEnabled(true);
                botonEditarCita.setEnabled(true);
                botonGuardarCita.setEnabled(false);
                textPersona.setEditable(false);
                textLugar.setEditable(false);
                textHora.setEditable(false);
                textDescripcion.setEditable(false);
                
                break;
            case 3://estado para editar un contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                textId.setEditable(false);
                textNombre.setEditable(true);
                textApellido.setEditable(true);
                textTelefonoDomicilio.setEditable(true);
                textTelefonoOficina.setEditable(true);
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
                break;
        }
    }

    public void limpiarCampos() {
        textId.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textTelefonoDomicilio.setText("");
        textTelefonoOficina.setText("");
        textDireccionDomicilio.setText("");
        textDireccionOficina.setText("");
        textCorreo.setText("");
        textCelular.setText("");
    }

}
