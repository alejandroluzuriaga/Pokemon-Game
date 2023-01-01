package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class AnadirEntrenador implements ActionListener{
    private JFrame VentanaNuevoEntrenador = new JFrame();
    private JToggleButton botonEntrenador1;
    private JToggleButton botonEntrenador2;
    private JToggleButton botonEntrenador3;
    private JToggleButton botonEntrenador4;
    private JButton botonLimpiar;
    private ButtonGroup grupoEntrenadores;
    private JLabel imagenPersonaje;
    private JButton botonGuardar;

    private Color cLetra = new Color (240, 245, 249);
    private Color cBotones = new Color (58,71,80);
    private Color cFondo = new Color (48,56,65);
    

    AnadirEntrenador(){
        botonEntrenador1 = new JToggleButton("LORETO");
            botonEntrenador1.setBounds(100,25,170,40);
            botonEntrenador1.setFont(new Font("Courier New", Font.BOLD, 15));
            botonEntrenador1.setFocusable(false);
            botonEntrenador1.setForeground(cLetra);
            botonEntrenador1.setBackground(cBotones);
            botonEntrenador1.setBorder(BorderFactory.createEtchedBorder());
            botonEntrenador1.addActionListener(this);

        botonEntrenador2 = new JToggleButton("SILVIA");
            botonEntrenador2.setBounds(100,75,170,40);
            botonEntrenador2.setFont(new Font("Courier New", Font.BOLD, 15));
            botonEntrenador2.setFocusable(false);
            botonEntrenador2.setForeground(cLetra);
            botonEntrenador2.setBackground(cBotones);
            botonEntrenador2.setBorder(BorderFactory.createEtchedBorder());
            botonEntrenador2.addActionListener(this);

        botonEntrenador3 = new JToggleButton("OLEKSANDR");
            botonEntrenador3.setBounds(100,125,170,40);
            botonEntrenador3.setFont(new Font("Courier New", Font.BOLD, 15));
            botonEntrenador3.setFocusable(false);
            botonEntrenador3.setForeground(cLetra);
            botonEntrenador3.setBackground(cBotones);
            botonEntrenador3.setBorder(BorderFactory.createEtchedBorder());
            botonEntrenador3.addActionListener(this);

        botonEntrenador4 = new JToggleButton("ALEJANDRO");
            botonEntrenador4.setBounds(100,175,170,40);
            botonEntrenador4.setFont(new Font("Courier New", Font.BOLD, 15));
            botonEntrenador4.setFocusable(false);
            botonEntrenador4.setForeground(cLetra);
            botonEntrenador4.setBackground(cBotones);
            botonEntrenador4.setBorder(BorderFactory.createEtchedBorder());
            botonEntrenador4.addActionListener(this);

        botonLimpiar = new JButton("Quitar Selección");
            botonLimpiar.setBounds(100,300,170,40);
            botonLimpiar.setFont(new Font("Courier New", Font.ITALIC, 12));
            botonLimpiar.setFocusable(false);
            botonLimpiar.setForeground(cLetra);
            botonLimpiar.setBackground(null);
            botonLimpiar.setBorder(null);
            botonLimpiar.addActionListener(this);

        grupoEntrenadores = new ButtonGroup();
        grupoEntrenadores.add(botonEntrenador1);
        grupoEntrenadores.add(botonEntrenador2);
        grupoEntrenadores.add(botonEntrenador3);
        grupoEntrenadores.add(botonEntrenador4);
        grupoEntrenadores.add(botonLimpiar);

        JPanel elegirPersonaje = new JPanel();
        elegirPersonaje.setLayout(null);
        elegirPersonaje.setBackground(cFondo);
        elegirPersonaje.add(botonEntrenador1);
        elegirPersonaje.add(botonEntrenador2);
        elegirPersonaje.add(botonEntrenador3);
        elegirPersonaje.add(botonEntrenador4);
        elegirPersonaje.add(botonLimpiar);

        imagenPersonaje = new JLabel();
        imagenPersonaje.setVerticalAlignment(JLabel.CENTER);
        imagenPersonaje.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelPersonajes = new JPanel();
        panelPersonajes.setLayout(new GridLayout(1,2,0,0));
        panelPersonajes.setBackground(cFondo);
        panelPersonajes.add(elegirPersonaje);
        panelPersonajes.add(imagenPersonaje);

        botonGuardar = new JButton("GUARDAR");
            botonGuardar.setBounds(20,0,645,80);
            botonGuardar.setHorizontalAlignment(JButton.CENTER);
            botonGuardar.setIcon(new ImageIcon("lib/botonGuardar.png"));
            botonGuardar.setFont(new Font("Courier New", Font.BOLD, 25));
            botonGuardar.setFocusable(false);
            botonGuardar.setForeground(cBotones);
            botonGuardar.setBackground(cLetra);
            botonGuardar.setBorder(BorderFactory.createEtchedBorder());
            botonGuardar.addActionListener(this);

        JPanel panelGuardar = new JPanel();
        panelGuardar.setLayout(null);
        panelGuardar.setPreferredSize(new Dimension(0,100));
        panelGuardar.setBackground(cFondo);
        panelGuardar.add(botonGuardar);
        VentanaNuevoEntrenador.setIconImage(new ImageIcon("./src/GUI/Imagenes/logo.png").getImage());
        VentanaNuevoEntrenador.setTitle("POOkemon");
        VentanaNuevoEntrenador.setResizable(false);
        VentanaNuevoEntrenador.setSize(700,500);
        VentanaNuevoEntrenador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        VentanaNuevoEntrenador.getContentPane().setBackground(cFondo);
        VentanaNuevoEntrenador.setLayout(new BorderLayout());
        VentanaNuevoEntrenador.setLocationRelativeTo(null);
        VentanaNuevoEntrenador.add(panelPersonajes, BorderLayout.CENTER);
        VentanaNuevoEntrenador.add(panelGuardar, BorderLayout.SOUTH);
        VentanaNuevoEntrenador.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonEntrenador1){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Loreto_G.png"));
        }
        if(e.getSource()==botonEntrenador2){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Silvia_G.png"));
        }
        if(e.getSource()==botonEntrenador3){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Oleksandr_G.png"));
        }
        if(e.getSource()==botonEntrenador4){
            imagenPersonaje.setIcon(new ImageIcon("./src/GUI/Imagenes/Entrenadores/Alejandro_G.png"));
        }
        if(e.getSource()==botonLimpiar){
            grupoEntrenadores.clearSelection();
            imagenPersonaje.setIcon(null);
        }
        if(e.getSource()==botonGuardar){
            VentanaNuevoEntrenador.dispose();
            if(botonEntrenador1.isSelected()){
                JButton botonLoreto = new JButton("Loreto");
            }
        }
    }
}


